package com.company;

import java.sql.*;
import java.util.List;
import java.util.concurrent.*;

import redis.clients.jedis.Jedis;

public class Main {

    public static void main(String[] args) {
        int limit = 30;
        int offset = 0;
        List<Item> res = new CopyOnWriteArrayList<>();
        // 查询最新的1000条记录
        for (int i = 0; i < 1000; i += limit) {
            // 分页查询30条记录
            List<Item> dataList = new CopyOnWriteArrayList<>();
            if (i + limit > 1000) {
                dataList = getDataFromDatabase(1000 - (i + limit), offset);
            } else {
                dataList = getDataFromDatabase(limit, offset);
            }

            // 线程池并发查询redis
            ThreadPoolTool<Item> tool = new ThreadPoolTool(5, dataList);
            tool.setCallBack(new ThreadPoolTool.CallBack<Item>() {
                @Override
                public void method(List<Item> list) {
                    // todo redis操作
                    for (int i = 0; i < list.size(); i++) {
                        Item item = list.get(i);
                        Integer stock = getDataFromRedis(item.getId());
                        item.setStock(stock);
                    }
                }
            });
            try {
                tool.excute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            res.addAll(dataList);
            offset += limit;
        }
    }

    // 从Redis中查询
    public static Integer getDataFromRedis(Integer key) {
        Jedis jedis = RedisPool.getJedis();
        return jedis.get(key);
    }

    // 从数据库中查询
    public static List<Item> getDataFromDatabase(int limit, int offset) {
        List<Item> res = new CopyOnWriteArrayList<>();
        String url = "jdbc:mysql://127.0.0.1/test";
        String name = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName(name);
            //获取连接
            conn = DriverManager.getConnection(url, user, password);
            //关闭自动提交，不然conn.commit()运行到这句会报错
            conn.setAutoCommit(false);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (conn != null) {
            String sql = "select item_id,item_name,pic from item limit " + limit + "offset" + offset + "order by update_time";
            try {
                Statement stmt = conn.createStatement();
                //获取结果集
                ResultSet rs = stmt.executeQuery(sql);
                res.add((Item) rs);
                conn.commit();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("数据库连接失败:");
        }
        return res;
    }
}
