package com.neuedu.solar.entity;

import com.neuedu.solar.common.FrameUtil;

import java.awt.*;

public class Moon extends Planet{
    /**
     * 无参构造方法
     */
    Planet earth;
    public Moon(){ }
    /**
     *ni 值是false时，自西向东
     */
    public Moon(Planet earth,String name,double AU,int T,double e ,String imgPath, boolean ni){
        //行星名
        this.name =name;
        //长轴
        this.longAxis = getLongAxis(AU);//AU:1:100
        //短轴
        this.shortAxis = getShortAxis(AU,e);
        this.speed = getSpeed(T);
        this.img = FrameUtil.getImage(imgPath);
        this.ni =ni;
        this.earth = earth;
        this.height= img.getHeight(null);
        this.width = img.getWidth(null);

    }

    private double getSpeed(int t) {
        //速度初始化
        return 365.0 /t *0.1 ;
    }

    private int getShortAxis(double au, double e) {
        return (int)(this.longAxis* Math.sqrt(1 - Math.pow(e,2) )/2);
    }

    private int getLongAxis(double au) {
        return (int)(au * 100);
    }
    /**
     * java编程中的设计原则：：单一性原则；
     * 画行星
     */
    public void draw(Graphics g){
        drawTrace(g);
        g.drawImage(img,x,y,null);
        move();
    }
    /**
     * 运行轨迹
     */
    public   void move(){
        x = earth.x +earth.width/2-this.width /2+ (int)(longAxis * Math.cos(theta));
        y = earth.y +earth.height/2-this.height /2 + (int)(shortAxis* Math.sin(theta));
        theta += speed;
    }

    /**
     * 画轨道
     */
    private void drawTrace(Graphics g){
        int x = earth.x +earth.width/2 -longAxis;
        int y = earth.y +earth.height/2- shortAxis;
        int width = 2 * longAxis;
        int height = 2 * shortAxis;
        g.drawOval( x,y,width,height);
        g.drawString( name,this.x,this.y);
    }
}






