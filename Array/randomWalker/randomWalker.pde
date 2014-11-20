int posX; 
int posY; 
int randX; 
int randY; 
int walkerSize;

void setup() {
	size(500, 500);
	background(255);
	walkerSize = 20; 

	//point de depart du random walker
	posX = width/2; 
	posY = height/2; 
}

void draw() {
	
	randX = (int) random(-2, 2);
	randY = (int) random(-2, 2);

	posX = posX + randX;
	posY = posY + randY;

	ellipse(posX, posY, walkerSize, walkerSize);

}