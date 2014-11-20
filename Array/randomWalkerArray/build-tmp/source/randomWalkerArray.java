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

public class randomWalkerArray extends PApplet {

int [] posX = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,0};
int [] posY = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,0,};

int [] walkerSize = {5,10,15,23,12,32,17,11,15,40,10,20,30,25,78,27,34,17,29,12,48};
int randX; 
int randY; 

boolean debug = true;

public void setup() {
	size(500, 500);
	background(255);
}

public void draw() {
	
	for (int i = 0; i < posX.length; i++) {
		randX = (int) random(-2, 2);
		randY = (int) random(-2, 2);

		posX[i] = posX[i] + randX;
		posY[i] = posY[i] + randY; 

		ellipse(posX[i], posY[i], walkerSize[i], walkerSize[i]);
	}

	if(debug == true){
		println("walker 1 -> posX: "+posX[0]);
		println("walker 1 -> posY: "+posY[0]);
		println("walker 1 -> walkerSize: "+walkerSize[0]);
	}
	

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "randomWalkerArray" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
