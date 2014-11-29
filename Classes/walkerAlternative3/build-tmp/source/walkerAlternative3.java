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

public class walkerAlternative3 extends PApplet {

Mover thomas, faustine, jerome, florence; 

public void setup() {
	background(255);
	size(512, 512);
	initMovers();
	textAlign(CENTER);
}

public void draw() {
	drawMovers();
	fill(0);
	text("ici la vitesse du mover depend de sa vitesse", width/2, height/2);
}

public void initMovers(){
	thomas = new Mover(100,100,30);
	faustine = new Mover(300,150,40);
	florence = new Mover(300,150,10);
	jerome = new Mover(300,150,70);
}

public void drawMovers(){
	background(255);
	thomas.afficher();
	faustine.afficher();
	florence.afficher();
	jerome.afficher();
}
//ici la vitesse du mover depend de sa vitesse

class Mover {

	PVector position = new PVector(0,0,0);
	PVector taille = new PVector(0,0,0);
	PVector vitesse = new PVector(0,0,0);
	PVector tailleUnivers = new PVector(512,512,0);
	PVector c = new PVector(0,0,0); // couleur

	Mover (int _posX, int _posY, int _taille) {
		position.x = _posX; 
		position.y = _posY; 
		taille.x = _taille; 
		taille.y = taille.x; 

		reglageVitesse();
	}

	public void detectionDesMurs(){
		if(position.x > tailleUnivers.x || position.x < 0 ){
			vitesse.x *= -1; 
			changementDeCouleur();
			
		}

		if(position.y > tailleUnivers.y || position.y < 0){
			vitesse.y *= -1; 
			changementDeCouleur();
		}
	}

	public void afficher(){
		bouger();
		detectionDesMurs();
		fill(c.x,c.y,c.z);
		ellipse(position.x, position.y, taille.x, taille.y);
	}

	public void bouger(){
		position.x += vitesse.x; 
		position.y += vitesse.y; 
	}

	public void reglageVitesse(){

		vitesse.x = map(vitesse.x, 1, taille.x, 1, 100);
		vitesse.y = map(vitesse.y, 1, taille.y, 1, 100);

		println("vitesse.x: "+vitesse.x);
		println("vitesse.y: "+vitesse.y);

	
	}

	public void changementDeCouleur(){
		c.x = (int) random(0,255);
		c.y = (int) random(0,255);
		c.z = (int) random(0,255);
	}


}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "walkerAlternative3" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
