Mover thomas, faustine, jerome, florence; 

void setup() {
	background(255);
	size(512, 512);
	initMovers();
	textAlign(CENTER);
}

void draw() {
	drawMovers();
	fill(0);
	text("ici la vitesse du mover depend de sa vitesse", width/2, height/2);
	text("Puis ils changent de couleur en touchant un mur", width/2, (height/2)+20);
}

void initMovers(){
	thomas = new Mover(100,100,30);
	faustine = new Mover(300,150,40);
	florence = new Mover(300,150,10);
	jerome = new Mover(300,150,70);
}

void drawMovers(){
	background(255);
	thomas.afficher();
	faustine.afficher();
	florence.afficher();
	jerome.afficher();
}