package com.neuedu.solar.entity;

import com.neuedu.solar.common.FrameUtil;
import com.neuedu.solar.constant.Constant;

import java.awt.*;

public class Sun {
    int x;
    int y;
    Image img;
    int width;
    int height;
    public Sun(){
        this.img=FrameUtil.getImage("com/neuedu/solar/img/太阳.png");
        this.width=img.getWidth(null);
        this.height=img.getHeight(null);
        this.x=Constant.FRAME_WIDTH/2-width/2;
        this.y=Constant.FRAME_HEIGHT/2-height/2;
    }

    public void draw(Graphics g){
        g.drawImage(img,x,y,null);
    }
}
