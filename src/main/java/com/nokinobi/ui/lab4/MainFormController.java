package com.nokinobi.ui.lab4;

import com.nokinobi.engine.transform.*;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFormController {


    private List<Point> points=new ArrayList<>();
    private GraphicsContext gc;
    private Color c=new Color(1,1,1,1);
    private int lineWidth=3;
    private Transformer curTransformer;
    private int resultCount=0;

    @FXML
    private Canvas mainCanvas;


    @FXML
    private TabPane tabs;

    @FXML
    private Label resultsLabel;

    @FXML
    private TextArea testArea;

    @FXML
    private TextField dx;

    @FXML
    private TextField dy;

    @FXML
    private Button goButton;

    @FXML
    private TextField alpha;

    @FXML
    private TextField kx;

    @FXML
    private TextField ky;


    public MainFormController() {

    }

    @FXML
    void mouseClicked(MouseEvent event) {
        if(gc==null)
            gc=mainCanvas.getGraphicsContext2D();

        if(event.getButton()== MouseButton.PRIMARY) {
            gc.fillOval(event.getX(),event.getY(),3,3);
            points.add(new Point((int)event.getX(),(int)event.getY()));
        }
        if(event.getButton()==MouseButton.SECONDARY){
            gc.fill();
            draw();
        }
    }

    @FXML
    void goClicked(MouseEvent event) {
        curTransformer.doTransform(points,this);
        draw();
    }

    private void draw() {
        gc.setFill(c);
        gc.setLineWidth(lineWidth);
        gc.beginPath();
        for(int i=0;i<points.size();i++){
            gc.lineTo(points.get(i).x,points.get(i).y);
        }
        gc.closePath();
        gc.stroke();
        showResult();
    }

    public void selectionChanged(Event event) {
        String tabName= ((Tab)event.getTarget()).getText();
        curTransformer= TransformersFactory.getTransformer(tabName);
    }

    private void showResult() {
        resultCount++;
        String res="         "+resultCount+"       \n";
        for(int i=0;i<3;i++)
            res+=" [ %d  %d   %d  ]\n";
        List<Integer> numbers=new ArrayList<>();
        for (int i=0;i<points.size();i++) {
            numbers.add(points.get(i).x);
            numbers.add(points.get(i).y);
            numbers.add(0);
        }
        res=String.format(res,numbers.toArray());
        String curText=testArea.getText();
        testArea.setText(curText+res+"\n\n");
    }

    public double[] getCurrentDxy(){
        return  new double[]{Double.parseDouble(dx.getText()),Double.parseDouble(dy.getText())};
    }

    public double[] getCurrentKxy(){
        return  new double[]{Double.parseDouble(kx.getText()),Double.parseDouble(ky.getText())};
    }

    public double getCurrentAlpha(){
        return Double.parseDouble(alpha.getText());
    }
}
