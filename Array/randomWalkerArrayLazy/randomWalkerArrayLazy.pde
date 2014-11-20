int [] posX = new int [50];
int [] posY = new int [50];
int [] walkerSize = new int [50];

int randX; 
int randY; 

boolean debug = true;

void setup() {
	size(500, 500);
	background(255);

	//set up des positions 
	for (int i = 0; i < posX.length; i++) {
		posX[i] = (int) random(0, width);
		posY[i] = (int) random(0, height);
		walkerSize[i] = (int) random(10, 50);
	}
}

void draw() {
	
	for (int i = 0; i < posX.length; i++) {
		randX = (int) random(-2, 2);
		randY = (int) random(-2, 2);

		posX[i] = posX[i] + randX;
		posY[i] = posY[i] + randY; 

		ellipse(posX[i], posY[i], walkerSize[i], walkerSize[i]);
	}
	

}