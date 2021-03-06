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

public class randomWalkerArrayTarget extends PApplet {

int [] posX = new int [100];
int [] posY = new int [100];
int [] walkerSize = new int [100];

int randX; 
int randY; 

boolean debug = false;

public void setup() {
	size(500, 500);
	background(255);

	//set up des positions 
	for (int i = 0; i < posX.length; i++) {
		posX[i] = (int) random(0, width);
		posY[i] = (int) random(0, height);
		walkerSize[i] = (int) random(10, 50);
	}
}

public void draw() {
	
	for (int i = 0; i < posX.length; i++) {
		randX = (int) random(-2, 2);
		randY = (int) random(-2, 2);

		posX[i] = posX[i] + randX;
		posY[i] = posY[i] + randY; 

		if (posX[i] > width/4 && posX[i] < width - (width/4) &&
			posY[i] > height/4 && posY[i] < height - (height/4) ){

			fill(255,127,72);
			ellipse(posX[i], posY[i], walkerSize[i], walkerSize[i]);

		}else{

			fill(122);
			ellipse(posX[i], posY[i], walkerSize[i], walkerSize[i]);
		}
		
		
	}

	if(debug == true){
		println("walker 1 -> posX: "+posX[0]);
		println("walker 1 -> posY: "+posY[0]);
		println("walker 1 -> walkerSize: "+walkerSize[0]);
	}
	

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "randomWalkerArrayTarget" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
