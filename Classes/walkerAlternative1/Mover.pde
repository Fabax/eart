//ici la vitesse du mover depend de sa vitesse

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

		reglageVitesse();
	}

	void detectionDesMurs(){
		if(position.x > tailleUnivers.x || position.x < 0 ){
			vitesse.x *= -1; 
			
		}

		if(position.y > tailleUnivers.y || position.y < 0){
			vitesse.y *= -1; 
		}
	}

	void afficher(){
		bouger();
		detectionDesMurs();
		ellipse(position.x, position.y, taille.x, taille.y);
	}

	void bouger(){
		position.x += vitesse.x; 
		position.y += vitesse.y; 
	}

	void reglageVitesse(){

		vitesse.x = map(vitesse.x, 1, taille.x, 1, 100);
		vitesse.y = map(vitesse.y, 1, taille.y, 1, 100);

		println("vitesse.x: "+vitesse.x);
		println("vitesse.y: "+vitesse.y);

	
	}


}