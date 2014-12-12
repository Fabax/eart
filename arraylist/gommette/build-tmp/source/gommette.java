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

public class gommette extends PApplet {

Gommette gommette; 

public void setup() {
	size(600, 600);
	background(255);
	gommette = new Gommette(50); 
}

public void draw() {
	background(255);
	// translate(width/2, height/2);
	gommette.render();
}

class Gommette  {

	float taille = 0.0f;
	PVector noiseColor = new PVector(0,0,0);
	PVector c = new PVector(0,0,0);
	PVector p = new PVector(0,0,0);
	float timeColor = 0.01f; 

	Gommette (float _t) {
		taille = _t; 
		noiseColor.x = round(random(0, 255));
		noiseColor.y = round(random(0, 255));
		noiseColor.z = round(random(0, 255));

		p.x = width/2; 
		p.y = height/2; 

	}

	public void render(){
		pushStyle();
		animate();
		ellipse(p.x,p.y, taille, taille);
		popStyle(); 
	}

	public void animate()	{
	   float distanceSourie = dist(mouseX, mouseY, p.x, p.y);
	   if (distanceSourie < taille){

	   	noiseColor.x = noise(timeColor);
	   	noiseColor.y = noise(timeColor+1000);
	   	noiseColor.z = noise(timeColor+2000);

	   	c.x = map(noiseColor.x, 0, 1, 0, 255);
	   	c.y = map(noiseColor.y, 0, 1, 0, 255);
	   	c.z = map(noiseColor.z, 0, 1, 0, 255);

	   	fill(c.x,c.y,c.z);

	   	timeColor += 0.01f;
	   }else{
	   	fill(c.x,c.y,c.z);
	   }
	}

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "gommette" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
