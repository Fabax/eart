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

public class trigo2 extends PApplet {

float angle, rayon ; 
int satX, satY; 
int tailleEllipse; 
int angle360; 

boolean goRound = true;

public void setup() {
	size(512, 512, P2D);
	background(255);
	tailleEllipse = 200;
	rayon = tailleEllipse/2; 
	angle = radians(angle360); 
	
	smooth(8);
}

public void draw() {
	background(255);

	pushMatrix();
		//cercle de debug 
		fill(255);
		stroke(120);
		strokeWeight(3);
		translate(width/2, height/2);
		ellipse(0, 0, tailleEllipse, tailleEllipse );

		// !!!!! IMPORTANT
		satX = PApplet.parseInt(rayon * sin(angle));
		satY = PApplet.parseInt(rayon * cos(angle));
		// !!!!! IMPORTANT 
		// 
		line(0, 0, satX, satY);


		fill(255,0,0);
		noStroke();
		ellipse(satX, satY, 20, 20);
		
	popMatrix();

	if(angle360 > 360){
		goRound = false; 
	}else if(angle360 < 0){
		goRound = true; 
	}

	if(goRound){
		angle360 ++;
	}else{
		angle360 --; 
	}

	angle = radians(angle360); 


	
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "trigo2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
