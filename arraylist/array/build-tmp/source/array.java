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

public class array extends PApplet {

int cols; 
int rows; 
int w, h; 
Gommette[] nbGommettes; 

int tailleGommette; 

public void setup() {
	cols = 5; 
	rows = cols; 
	tailleGommette = 100; 

	nbGommettes = new Gommette[cols*rows];

	for (int i = 0; i < nbGommettes.length; i++) {
		nbGommettes[i] = new Gommette(tailleGommette);
		println("ok: ");
	}

	w = ((tailleGommette) * cols)+tailleGommette; 
	h = w; 


	size(h, w, P2D);
	background(0);

	smooth(8);
	noStroke();
	// gommette = new Gommette(50); 

}

public void draw() {
	background(0);

	int gommetteIndex = 0; 
	for (int i = 1; i <= rows; i++) {
		for (int j = 1; j <= cols; j++) {
			nbGommettes[gommetteIndex].setPosition(tailleGommette*i, tailleGommette*j);
			nbGommettes[gommetteIndex].render();
			gommetteIndex++;
		}
	}

	// gommette.render();
}

class Gommette  {

	float taille = 0.0f;
	PVector noiseColor = new PVector(0,0,0);
	PVector c = new PVector(0,0,0);
	PVector p = new PVector(0,0,0);
	float timeColor = 0.01f; 

	Gommette (float _t) {
		taille = _t-10; 
		noiseColor.x = round(random(0, 255));
		noiseColor.y = round(random(0, 255));
		noiseColor.z = round(random(0, 255));

	}

	public void render(){
		pushStyle();
		animate();
		ellipse(p.x,p.y, taille, taille);
		popStyle(); 
	}

	public void animate()	{
	   float distanceSourie = dist(mouseX, mouseY, p.x, p.y);
	   if (distanceSourie < taille/2){

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

	public void setPosition(int _x, int _y){
		p.x = _x; 
		p.y = _y; 
	}

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "array" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
