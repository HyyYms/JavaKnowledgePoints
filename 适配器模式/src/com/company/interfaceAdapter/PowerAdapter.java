package com.company.interfaceAdapter;



/**
 * @program: 适配器模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 08:51
 **/
public class PowerAdapter implements DC {

    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int output5V() {
        int adapterInput = ac220.outputAC220V();
        int adapterOutput = adapterInput / 44;
        System.out.println("输入AC" + adapterInput + "输出DC" + adapterOutput);
        return adapterOutput;
    }

    @Override
    public int output12V() {
        return 0;
    }

    @Override
    public int output24V() {
        return 0;
    }

    @Override
    public int output36V() {
        return 0;
    }
}
