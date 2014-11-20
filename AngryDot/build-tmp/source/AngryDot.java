import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class AngryDot extends PApplet {

int ellipseSize;

int longDistance; 
int mediumDistance;
int shortDistance; 
int distanceMouseToDot;
int noDistance; 

public void setup() {
	background(255);
	size(512, 512);

	longDistance = 300; 
	mediumDistance = 200; 
	shortDistance = 100;
	noDistance = 50;

	ellipseSize = 100;
}

public void draw() {
	background(255);

	

	distanceMouseToDot = PApplet.parseInt(dist((width/2), (height/2), mouseX, mouseY));
	
	if(distanceMouseToDot > longDistance){
		fill(255);
	}else if(distanceMouseToDot<longDistance && distanceMouseToDot > mediumDistance){
		fill(0,255,0);
	}else if(distanceMouseToDot<mediumDistance && distanceMouseToDot > shortDistance){
		fill(0,0,255);
	}else if(distanceMouseToDot < shortDistance && distanceMouseToDot > noDistance){
		fill(255,0,0);
	}else if(distanceMouseToDot < noDistance){
		int r = (int) random(0, 255);
		fill(r);
	}

	ellipse((width/2), (height/2), ellipseSize, ellipseSize);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "AngryDot" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
