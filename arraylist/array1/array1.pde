int cols; 
int rows; 
int w, h; 
Gommette[] nbGommettes; 

int tailleGommette; 

void setup() {
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

void draw() {
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

