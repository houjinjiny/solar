package com.neuedu.solar.client;

import com.neuedu.solar.common.CommonFrame;
import com.neuedu.solar.common.FrameUtil;
import com.neuedu.solar.constant.Constant;
import com.neuedu.solar.entity.Moon;
import com.neuedu.solar.entity.Planet;
import com.neuedu.solar.entity.Sun;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SolarSystem extends CommonFrame {
    Sun sun = new Sun ();

    Planet Mercury = new Planet (sun,"水星",0.3287,88,0.2056,"com/neuedu/solar/img/水星.png",false);
    Planet Venus = new Planet (sun,"金星",0.72,225,0.0068,"com/neuedu/solar/img/金星.png",true);
    Planet earth = new Planet (sun,"地球",1.31,365,0.0167,"com/neuedu/solar/img/地球.png",false);
    Planet Mars = new Planet (sun,"火星",2.02,687,0.0934, "com/neuedu/solar/img/火星.png",false);
    Planet Juipter = new Planet (sun,"木星",3.12,4330,0.0489,"com/neuedu/solar/img/木星.png",false);
    Planet Saturn = new Planet (sun,"土星",4.04,10832,0.0557,"com/neuedu/solar/img/土星.png",false);
    Planet Uranus = new Planet (sun,"天王星",4.9,30777,0.0444,"com/neuedu/solar/img/天王星.png",false);
    Planet Neptune = new Planet (sun,"海王星",5.62,60328,0.0112,"com/neuedu/solar/img/海王星.png",false);
    Planet Pluto = new Planet (sun,"冥王星",6.2,90717,0.249,"com/neuedu/solar/img/冥王星.png",false);
    Planet halei = new Planet (sun,"halei星",3.58,900,0.249,"com/neuedu/solar/img/冥王星.png",false);
    Moon moon=new Moon(earth,"月亮",1.3,300,0.0167,"com/neuedu/solar/img/MOON.png",false);
    List<Planet> smallPlanets = new ArrayList<Planet> ();
    {
        for (int i = 0; i < 100; i++) {
            double q =  Math.random() * 1+2.12;
            int qq = (int) (Math.random() + 687 + (Math.random() * 2000));
            double qqq = Math.random() * 0.08;
            Planet smallPlent = new Planet(sun, "", q, qq, qqq, "com/neuedu/solar/img/水星1.png", false);
            smallPlanets.add(smallPlent);
        }
    }


    @Override
    public void paint(Graphics g) {
        g.drawImage(FrameUtil.getImage("背景1.jpg"), 0, 0, Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT, null);
        sun.draw (g);
        Mercury.draw (g);
        Venus.draw (g);
        earth.draw (g);
        moon.draw(g);
        Mars.draw (g);
        for (int i = 0; i < smallPlanets.size(); i++) {
            Planet p = smallPlanets.get(i);
            p.draws(g);
        }
        Juipter.draw (g);
        Saturn.draw (g);
        Uranus.draw (g);
        Neptune.draw (g);
        Pluto.draw (g);
        halei.drawss (g);

    }

    public static void main(String[] args) {

        new SolarSystem ().loadFrame ("太阳系八行星运行图");
    }
}
