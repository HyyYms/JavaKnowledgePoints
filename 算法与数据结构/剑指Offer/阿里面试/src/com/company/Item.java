package com.company;

/**
 * @program: 阿里面试
 * @description:
 * @author: Mr.Huang
 * @create: 2021-03-27 21:02
 **/
public class Item {

    private Integer id;

    private Integer item_id;

    private String item_name;

    private String result_cnt;

    private String pic;

    private Integer stock;

    public Item() {
    }

    public Item(Integer id, Integer item_id, String item_name, String result_cnt, String pic) {
        this.id = id;
        this.item_id = item_id;
        this.item_name = item_name;
        this.result_cnt = result_cnt;
        this.pic = pic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getResult_cnt() {
        return result_cnt;
    }

    public void setResult_cnt(String result_cnt) {
        this.result_cnt = result_cnt;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
