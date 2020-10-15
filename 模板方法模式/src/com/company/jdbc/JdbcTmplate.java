package com.company.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.ResultSet;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: 模板方法模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 20:55
 **/
public abstract class JdbcTmplate {

    private DataSource dataSource;

    public JdbcTmplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public final List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) {
        try {
            // 获取连接
            Connection connection = this.getCononection();
            // 创建语句集
            PreparedStatement pstm = this.createPreparseStatement(connection, sql);
            // 执行语句集
            ResultSet resultSet = this.executeQuery(pstm, values);
            // 处理结果集
            List<?> result = this.parseResultSet(resultSet, rowMapper);
            // 关闭结果集
            resultSet.close();
            // 关闭语句集
            pstm.close();
            // 关闭连接
            connection.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<?> parseResultSet(ResultSet resultSet, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<>();
        int rowNum = 0;
        while (resultSet.next()) {
            result.add(rowMapper.mapRow(resultSet, rowNum++));
        }
        return result;
    }

    private ResultSet executeQuery(PreparedStatement pstm, Object[] values) throws SQLException {
        for (int i = 0; i < values.length; i++) {
            pstm.setObject(i, values[i]);
        }
        return pstm.executeQuery();
    }

    private PreparedStatement createPreparseStatement(Connection connection, String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    private Connection getCononection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
