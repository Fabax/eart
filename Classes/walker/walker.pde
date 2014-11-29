Mover thomas, faustine; 

void setup() {
	background(255);
	size(512, 512);
	initMovers();
	textAlign(CENTER);
}

void draw() {
	drawMovers();
	fill(0);
	text("Classe de base à utilisé comme modèle", width/2, height/2);
}

void initMovers(){
	thomas = new Mover(100,100,30);
	faustine = new Mover(300,150,40);
}

void drawMovers(){
	fill(255);
	strokeWeight(3);
	background(255);
	thomas.afficher();
	faustine.afficher();
}