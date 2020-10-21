package com.company.demo;

/**
 * @program: 模板方法模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 21:21
 **/
public abstract class AbstractCook {

    public final void create() {

        cutUpVegetables();

        stirFry();

        eat();

        if (needWashDishes()) {
            washDishes();
        }
    }

    protected void cutUpVegetables() {
        System.out.println("切菜");
    }

    protected void stirFry() {
        System.out.println("炒菜");
    }

    protected void eat() {
        System.out.println("吃");
    }

    // 钩子方法
    protected boolean needWashDishes() {
        return false;
    }

    protected abstract void washDishes();
}
