int cols; 
int rows; 
int w, h; 
ArrayList<Gommette> gommettes = new ArrayList<Gommette>();

int tailleGommette; 

void setup() {
	cols = 5; 
	rows = cols; 
	tailleGommette = 100; 

	w = ((tailleGommette) * cols)+tailleGommette; 
	h = w; 

	size(h, w, P2D);
	background(0);
	smooth(8);
	noStroke();
}

void draw() {
	background(0);

	for (int i = 0; i < gommettes.size(); i++) {
	  Gommette currentGommette = gommettes.get(i);
	  currentGommette.render();
	}

	// The second is using an enhanced loop:
	for (Gommette currentGommette : gommettes) {
	  currentGommette.render();
	  PVector pos = currentGommette.getPosition();
	  println("pos.x: "+pos.x);
	  println("pos.y: "+pos.y);
	  println("pos.z: "+pos.z);
	}

}

void mousePressed() {
	gommettes.add(new Gommette(mouseX,mouseY));


	// println("var: "+var);
}

