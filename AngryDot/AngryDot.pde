int ellipseSize;

int longDistance; 
int mediumDistance;
int shortDistance; 
int distanceMouseToDot;
int noDistance; 

void setup() {
	background(255);
	size(512, 512);

	longDistance = 300; 
	mediumDistance = 200; 
	shortDistance = 100;
	noDistance = 50;

	ellipseSize = 100;
}

void draw() {
	background(255);

	

	distanceMouseToDot = int(dist((width/2), (height/2), mouseX, mouseY));
	
	if(distanceMouseToDot > longDistance){
		fill(255);
	}else if(distanceMouseToDot<longDistance && distanceMouseToDot > mediumDistance){
		fill(0,255,0);
	}else if(distanceMouseToDot<mediumDistance && distanceMouseToDot > shortDistance){
		fill(0,0,255);
	}else if(distanceMouseToDot < shortDistance && distanceMouseToDot > noDistance){
		fill(255,0,0);
	}else if(distanceMouseToDot < noDistance){
		int r = (int) random(0, 255);
		fill(r);
	}

	ellipse((width/2), (height/2), ellipseSize, ellipseSize);
}