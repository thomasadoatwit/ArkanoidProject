package edu.wit.cs.comp1050.javafx_maven_example;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Blocks extends Rectangle{


    public static final int width = 75;
    public static final int height = 35;


    public Blocks(double x, double y, Color c) {
        super(width, height, c);
        setTranslateX(x);
        setTranslateY(y);
}


	public void add(Blocks block1) {
		// TODO Auto-generated method stub
		
	}
    
	}