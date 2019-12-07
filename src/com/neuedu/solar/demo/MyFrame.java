package com.neuedu.solar.demo;

import com.neuedu.solar.common.FrameUtil;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
    //在构造方法中设置生成窗口的属性
    public MyFrame(){
        //1.设置大小
        this.setSize(1000,1000);
        //2.设置位置
        //水平垂直居中
        this.setLocationRelativeTo(null);
        //3.设置可见性（默认不可见）
        this.setVisible(true);
        //4.设置关闭窗口按钮的方法的实现
        //使用匿名内部类完成抽象类对象的实现
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //5.设置改变窗口大小的方法（默认可改变）
        this.setResizable(false);
        //6.设置标题
        this.setTitle("第一个窗口程序");
    }
    public static void main(String[] args) {
        MyFrame myFrame=new MyFrame();
    }
    public void paint(Graphics g){
//        //画直线
//        g.drawLine(50,50,150,150);
//        //画矩形
//        g.drawRect(100,100,400,400);
//        //画圆
//        g.drawOval(100,100,400,200);
//        //获取系统默认颜色
//        Color c=g.getColor();
//        //改变画笔颜色
//        g.setColor(new Color(255,0,0));
//        g.fillRect(200,200,400,200);
//        g.setColor(c);
//        //不规则多边形
//        //画图片
//        int[] xPointer={100,200,400,250};
//        int[] yPointer={100,400,300,250};
//        int nPointer=4;
//        g.drawPolygon(xPointer,yPointer,nPointer);
        g.drawImage(FrameUtil.getImage("mu.png"),200,200,80,80,null);
        g.drawImage(FrameUtil.getImage("Earth.png"),300,200,80,80,null);
        g.drawImage(FrameUtil.getImage("hs.png"),400,200,80,80,null);
        g.drawImage(FrameUtil.getImage("hw.png"),500,200,80,80,null);
        g.drawImage(FrameUtil.getImage("j.png"),200,300,80,80,null);
        g.drawImage(FrameUtil.getImage("mw.png"),200,400,80,80,null);
        g.drawImage(FrameUtil.getImage("shui.png"),200,500,80,80,null);
        g.drawImage(FrameUtil.getImage("Sun.png"),200,600,80,80,null);
        g.drawImage(FrameUtil.getImage("tu.png"),200,700,80,80,null);
        g.drawImage(FrameUtil.getImage("tw.png"),200,800,80,80,null);
        g.drawImage(FrameUtil.getImage("xk.png"),200,900,80,80,null);


    }

}
