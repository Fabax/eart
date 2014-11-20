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

public class randomWalker extends PApplet {

int posX; 
int posY; 
int randX; 
int randY; 
int walkerSize;

public void setup() {
	size(500, 500);
	background(255);
	walkerSize = 20; 

	//point de depart du random walker
	posX = width/2; 
	posY = height/2; 
}

public void draw() {
	
	randX = (int) random(-2, 2);
	randY = (int) random(-2, 2);

	posX = posX + randX;
	posY = posY + randY;

	ellipse(posX, posY, walkerSize, walkerSize);

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "randomWalker" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
