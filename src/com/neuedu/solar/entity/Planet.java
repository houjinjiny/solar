package com.neuedu.solar.entity;

import com.neuedu.solar.common.FrameUtil;
import com.neuedu.solar.constant.Constant;
import com.neuedu.solar.entity.Sun;

import javax.sound.sampled.AudioFileFormat;
import java.awt.*;
import static javax.sound.sampled.AudioFileFormat.Type.AU;

public class Planet {
    /**
     * 半长轴
     */
    int longAxis;
    /**
     * 半短轴
     */
    int shortAxis;
    /**
     * 参数theta
     */
    double theta=0.0;
    /**
     * x坐标
     */
    int x;
    /**
     * y坐标
     */
    int y;
    /**
     * 速度
     */
    double speed;

    /**
     * 行星的图片对象
     */
    Image img;
    /**
     *行星名字
     */
    String name;
    /**
     *转动方向
     */
    boolean ni;

    Sun sun;

    int width;
    int height;

    public Planet(){}

    public Planet(Sun sun,String name,double Au,int T,double e,String imgPath,boolean ni){
        this.sun = sun;
        this.name = name;
        this.longAxis = getLongAxis(Au);
        this.shortAxis = getShortAxis(Au,e);
        this.speed = getSpeed(T);
        this.img = FrameUtil.getImage (imgPath);
        this.width = img.getWidth (null);
        this.height = img.getHeight (null);
        this.ni = ni;
    }

    private double getSpeed(int t) {
        return  365.0/ t * 0.1;
    }

    /**
     * 根据天文单位和离心率计算短轴
     * @param au
     * @param e
     * @return
     */
    private int getShortAxis(double au, double e) {
        return (int)((this.longAxis * Math.sqrt (1-Math.pow (e,2)))/2);
    }

    /**
     * 根据天文单位计算长轴
     * @param au
     * @return
     */
    private int getLongAxis(double au) {
        return (int)(au * 100);
    }
    /**
     * 画除了哈雷所有以外所有的行星
     */
    public void draw(Graphics g){
        //先画轨道再画行星
        drawTrace (g);
        g.drawImage(img, x, y, null);
        move();
    }
    public void draws(Graphics g){
        //画土星和火星中间的行星

        g.drawImage(img, x, y, null);
        move();
    }
    public void drawss(Graphics g){
        //哈雷

        g.drawImage(img,x,y,null);
        move2();
    }
    /**
     * 运行轨迹
     */
    public void move(){
        if (ni){
            x = sun.x + sun.width / 2 - this.width / 2+ (int)(longAxis * Math.sin(theta));
            y = sun.y + sun.height / 2 -this.height / 2 + (int)(shortAxis * Math.cos(theta));
        }else{
            x = sun.x + sun.width / 2 - this.width / 2+ (int)(longAxis * Math.cos(theta));
            y = sun.y + sun.height / 2 -this.height / 2 + (int)(shortAxis * Math.sin(theta));

        }theta += speed;
    }
    private void move2(){//哈雷移动
        x = sun.x +sun.width/2-this.width /2+ (int)(longAxis * Math.sin(theta)-(shortAxis* Math.cos(theta)));
        y = sun.y +sun.height/2-this.height /2 + (int)(shortAxis* Math.cos(theta)+longAxis * Math.sin(theta));
        theta += speed;
    }

    /**
     * 画轨道
     * @param g
     */
    private void drawTrace(Graphics g){
        int x = sun.x + sun.width / 2 -longAxis;
        int y = sun.y + sun.height / 2 - shortAxis;
        int width = 2* longAxis;
        int height = 2* shortAxis;
        g.drawOval (x,y,width,height);
        g.drawString (name,this.x,this.y);
    }


}
