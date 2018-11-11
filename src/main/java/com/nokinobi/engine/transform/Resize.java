package com.nokinobi.engine.transform;

import com.nokinobi.ui.lab4.MainFormController;

import java.awt.*;
import java.util.List;

public class Resize implements Transformer {


    private double kx=0,ky=0;



    @Override
    public List<Point> doTransform(List<Point> points, MainFormController mainFormController) {
        double [] kxy=mainFormController.getCurrentKxy();
        kx=kxy[0];
        ky=kxy[1];

        for(int i=0;i<points.size();i++){
            points.get(i).x*=kx;
            points.get(i).y*=ky;
        }
        return points;
    }
}
