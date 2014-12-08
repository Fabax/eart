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

public class trigoVertex extends PApplet {

float angle, rayon ; 

int satX, satY; 
int tailleEllipse; 
int angle360; 

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
		// ellipse(0, 0, tailleEllipse, tailleEllipse );
		
		// fill(255,0,0);
		beginShape();
	

		int angleMax = 360;
		
		for (int i = 0; i < 10; i++) {

			int r = (int) random(50,120);
			satX = PApplet.parseInt(rayon * sin(i*4));
			satY = PApplet.parseInt(rayon * cos(i*4));

			vertex(satX, satY);
		}

		endShape();


		
	popMatrix();

	angle = radians(angle360++); 
	
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "trigoVertex" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
