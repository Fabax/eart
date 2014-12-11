Gommette gommette; 

void setup() {
	size(600, 600);
	background(255);
	gommette = new Gommette(50); 
}

void draw() {
	background(255);
	// translate(width/2, height/2);
	gommette.render();
}

