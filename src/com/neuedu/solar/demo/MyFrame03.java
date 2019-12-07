package com.neuedu.solar.demo;

import com.neuedu.solar.common.CommonFrame;
import com.neuedu.solar.common.FrameUtil;
import com.neuedu.solar.constant.Constant;

import java.awt.*;

public class MyFrame03 extends CommonFrame {
    /**
     * 长半轴
     */
    int longAxis=400;
    /**
     * 短半轴
     */
    int shortAxis=200;
    /**
     * 参数theta
     */
    double theta=0.0;
    /**
     * x坐标
     */
    int x;
    int y;
    double speed=0.1;
    static Image img=FrameUtil.getImage("Earth.png");
    public void paint(Graphics g){
        g.drawImage(img,x,y,50,50,null);
        x=(int)(Constant.FRAME_WIDTH/2+longAxis*Math.cos(theta));
        y=(int)(Constant.FRAME_HEIGHT/2+shortAxis*Math.sin(theta));
        theta+=speed;
    }

    public static void main(String[] args) {
        MyFrame03 myFrame03=new MyFrame03();
        myFrame03.loadFrame("按照椭圆轨迹运行");
    }
}
