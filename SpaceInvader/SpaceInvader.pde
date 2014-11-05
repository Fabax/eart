//Declaration des variables 
int rectSize;
int rectColor; 

int rows; 
int columns; 

int halfInvaderW;
int halfInvaderH;

int posX;
int posY; 

boolean debug = false;
boolean switchButton = true;

// Pgraphic halfInvader; 

void setup() {
	//proprietés du sketch
	size(512, 400);
	background(80);

	// initialisation des variables
	columns = 5; 
	rows = 8; 
	rectSize = 40;

	halfInvaderH = rectSize * rows; 
	halfInvaderW = rectSize * columns;	

	// position du space invader
	posX = (width/2) - rectSize ;
	posY = (height/2) - (halfInvaderH/2);

	noStroke();
}

void draw() {
	background(80);
	pushMatrix();
		translate(posX, posY);
		drawInvader();	
	popMatrix();

	//expliquer noloop
	noLoop();
}

void drawInvader(){
	//affichage de la debug
	if(switchButton){
		stroke(255,0,0);
	}else{
		noStroke();	
	}

	for (int i = 0; i < columns; i++) {
		for (int j = 0; j < rows; j++) {
			// retourne une couleur au hasard ( nuance de gris)
			int rectColor = colorRandomizer();
			fill(rectColor);
			//dessin d'une moitié du space invader
			rect((i*rectSize)+rectSize, (j*rectSize), rectSize, rectSize);
			//puis de l'autre 
			rect((i*rectSize)*-1, (j*rectSize), rectSize, rectSize);
		}
	}
}

//fonction de typy Int car elle retourne un int
int colorRandomizer(){
	//caster
	int r = (int)random(2);
	int response; 

	if(r == 1){
		response = 0;
	}else{
		response = 255;
	}

	println("response: "+response);

	//info produite par la fonction 
	return response;
}

void mousePressed() {
	loop();
}

void keyPressed() {
	//sauvagarde de l'image
	if(key == 's' || key == 'S'){
		if(debug){println("imageSaved: ");}
		String imageName = hour()+""+minute()+""+second()+""+day()+""+month()+""+year();
		saveFrame("results/spaceInvader-"+imageName+".jpg");

	//affichage du mode de debug
	}else if(key == 'd' || key == 'D'){
		println("keyPressed");
		if(switchButton){
			switchButton = false; 
		}else{
			switchButton = true;
		}
	
	}
}




// check this ou : https://amnonp5.wordpress.com/2012/01/28/25-life-saving-tips-for-processing/