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

public class arrayList extends PApplet {

int cols; 
int rows; 
int w, h; 
ArrayList<Gommette> gommettes = new ArrayList<Gommette>();

int tailleGommette; 

public void setup() {
	cols = 5; 
	rows = cols; 
	tailleGommette = 100; 
	// nbGommettes = new Gommette[cols*rows];

	w = ((tailleGommette) * cols)+tailleGommette; 
	h = w; 

	size(h, w, P2D);
	background(0);
	smooth(8);
	noStroke();
}

public void draw() {
	background(0);

	for (int i = 0; i < gommettes.size(); i++) {
	  Gommette currentGommette = gommettes.get(i);
	  currentGommette.render();
	}

	// The second is using an enhanced loop:
	// for (Gommette currentGommette : gommettes) {
	//   currentGommette.render();
	// }

}

public void mousePressed() {
	gommettes.add(new Gommette(mouseX,mouseY));
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

		// p.x = width/2; 
		// p.y = height/2; 

	}

	Gommette (int _x, int _y) {
		taille = (int) random(30, 100); 
		noiseColor.x = round(random(0, 255));
		noiseColor.y = round(random(0, 255));
		noiseColor.z = round(random(0, 255));

		p.x = _x; 
		p.y = _y; 

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
    String[] appletArgs = new String[] { "arrayList" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
