package com.company.demo;

/**
 * @program: 模板方法模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 21:26
 **/
public class BCook extends AbstractCook {

    @Override
    protected void washDishes(){
        System.out.println("B洗碗");
    }

}
