package com.company.demo;

/**
 * @program: 模板方法模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 21:26
 **/
public class ACook extends AbstractCook {

    private boolean needWashDishes = false;

    public void setNeedWash(boolean needWashDishes) {
        this.needWashDishes = needWashDishes;
    }

    @Override
    protected boolean needWashDishes() {
        return this.needWashDishes;
    }

    @Override
    protected void washDishes() {
        System.out.println("A洗碗");
    }
}
