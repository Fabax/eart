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

	void helperRandomVitesse(){
		vitesse.x = (int) random(-5,5);
		vitesse.y = (int) random(-5,5);

		if(vitesse.x == 0 || vitesse.y == 0){
			helperRandomVitesse();
		}
	}


}