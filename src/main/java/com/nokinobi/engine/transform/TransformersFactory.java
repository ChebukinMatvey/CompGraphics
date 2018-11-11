package com.nokinobi.engine.transform;

public class TransformersFactory {


    static Resize r=new Resize();
    static Transform t= new Transform();
    private static Rotate rotate=new Rotate();


    public static Transformer getTransformer(String  tabName){
        switch (tabName){
            case "Resize":
                return r;
            case "Transform":
                return t;
            case "Rotate":
                return rotate;
            default:
                return null;
        }
    }

}
