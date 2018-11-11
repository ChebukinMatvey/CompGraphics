package com.nokinobi.engine.transform;

import com.nokinobi.ui.lab4.MainFormController;

import java.awt.*;
import java.util.List;

public class Transform implements Transformer {

    private double dx;
    private double dy;

    @Override
    public List<Point> doTransform(List<Point> points, MainFormController mainFormController) {
        double [] kxy=mainFormController.getCurrentDxy();
        dx=kxy[0];
        dy=kxy[1];

        for(int i=0;i<points.size();i++){
            points.get(i).x+=dx;
            points.get(i).y+=dy;
        }
        return points;
    }


}
