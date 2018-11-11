package com.nokinobi.engine.transform;

import com.nokinobi.ui.lab4.MainFormController;

import java.awt.*;
import java.util.List;

public class Rotate implements Transformer {


    @Override
    public List<Point> doTransform(List<Point> points, MainFormController mainFormController) {
        double alpha=mainFormController.getCurrentAlpha();
        alpha=alpha*Math.PI/180;
        for(int i=0;i<points.size();i++){
            getNewPoints(points.get(i), alpha);
        }
        return points;
    }

    private void getNewPoints(Point p, double alpha) {

        double cos=Math.cos(alpha);
        double sin=Math.sin(alpha);

        p.x=(int)Math.ceil( p.x*cos + p.y*sin);
        p.y=(int)Math.ceil( p.x* -sin + p.y*cos);
    }
}
