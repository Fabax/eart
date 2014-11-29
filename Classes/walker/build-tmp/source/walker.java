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

public class walker extends PApplet {

Mover thomas, faustine; 

public void setup() {
	background(255);
	size(512, 512);
	initMovers();
	textAlign(CENTER);
}

public void draw() {
	drawMovers();
	fill(0);
	text("Class de base \u00e0 utilis\u00e9 comme mod\u00e8le", width/2, height/2);
}

public void initMovers(){
	thomas = new Mover(100,100,30);
	faustine = new Mover(300,150,40);
}

public void drawMovers(){
	fill(255);
	strokeWeight(3);
	background(255);
	thomas.afficher();
	faustine.afficher();
}
class Mover {

	PVector position = new PVector(0,0,0);
	PVector taille = new PVector(0,0,0);
	PVector vitesse = new PVector(0,0,0);
	PVector tailleUnivers = new PVector(512,512,0);

	Mover (int _posX, int _posY, int _taille) {
		position.x = _posX; 
		position.y = _posY; 
		taille.x = _taille; 
		taille.y = taille.x; 

		helperRandomVitesse();
	}

	public void detectionDesMurs(){
		if(position.x > tailleUnivers.x || position.x < 0 ){
			vitesse.x *= -1; 
			
		}

		if(position.y > tailleUnivers.y || position.y < 0){
			vitesse.y *= -1; 
		}
	}

	public void afficher(){
		bouger();
		detectionDesMurs();
		ellipse(position.x, position.y, taille.x, taille.y);
	}

	public void bouger(){
		position.x += vitesse.x; 
		position.y += vitesse.y; 
	}

	public void helperRandomVitesse(){
		vitesse.x = (int) random(-5,5);
		vitesse.y = (int) random(-5,5);

		if(vitesse.x == 0 || vitesse.y == 0){
			helperRandomVitesse();
		}
	}


}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "walker" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
