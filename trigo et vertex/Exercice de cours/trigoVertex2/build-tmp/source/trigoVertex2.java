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

public class trigoVertex2 extends PApplet {

int rayon ; 
float satX, satY, n; 
int tailleEllipse; 
boolean debug = false;
float t = 0.01f; 

public void setup() {
	size(512, 512, P2D);
	background(255);
	tailleEllipse = 400;
	rayon = tailleEllipse/2; 
	
	smooth(8);
	frameRate(25);
}

public void draw() {
	background(255);

	

	pushMatrix();
		translate(width/2, height/2);
		multiShape(30,rayon);
	popMatrix();

	
}

public void multiShape(int _angle, int _rayon){
	int iterations =  360/_angle;
	int currentAngle = 0; 

	fill(0);
	noStroke();
	beginShape();
		
	for (int i = 0; i < iterations; i++) {

		n = noise(random(0.3f));
		float r = map(n, 0, 1, _rayon/4, _rayon); 
		
		satX = r * sin(radians(currentAngle));
		satY = r * cos(radians(currentAngle));
		
		vertex(satX, satY);

		if(debug){
			line(0, 0, satX, satY);
			text(currentAngle, satX+20, satY+20);
			ellipse(satX, satY, 20, 20);
			println("currentAngle: "+currentAngle);
		}

		currentAngle += _angle;

	}

	endShape();
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "trigoVertex2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
