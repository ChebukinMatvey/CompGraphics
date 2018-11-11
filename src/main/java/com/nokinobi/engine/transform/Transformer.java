package com.nokinobi.engine.transform;

import com.nokinobi.ui.lab4.MainFormController;

import java.util.List;

import java.awt.*;

public interface Transformer {


    List<Point> doTransform(List<Point> points, MainFormController mainFormController);
}
