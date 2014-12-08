Mover thomas; 

void setup() {
	background(255);
	size(512, 512);
	initMovers();
	textAlign(CENTER);
}

void draw() {
	drawMovers();
	fill(0);
}

void initMovers(){
	thomas = new Mover(100,100,30);

}

void drawMovers(){
	background(255);
	thomas.afficher();

}