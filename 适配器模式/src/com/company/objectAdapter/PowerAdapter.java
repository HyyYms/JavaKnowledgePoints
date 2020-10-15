package com.company.objectAdapter;

/**
 * @program: 适配器模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-15 08:51
 **/
public class PowerAdapter extends AC220 implements DC5 {

    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputDC5V() {
        int adapterInput = ac220.outputAC220V();
        int adapterOutput = adapterInput / 44;
        System.out.println("输入AC" + adapterInput + "输出DC" + adapterOutput);
        return adapterOutput;
    }

}
