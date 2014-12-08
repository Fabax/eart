int rayon ; 
float satX, satY; 
int tailleEllipse; 
boolean debug = false;

void setup() {
	size(512, 512, P2D);
	background(255);
	tailleEllipse = 400;
	rayon = tailleEllipse/2; 
	
	smooth(8);
}

void draw() {
	background(255);

	pushMatrix();
		translate(width/2, height/2);
		multiShape(30,rayon);
	popMatrix();

	noLoop();
}

void multiShape(int _angle, int _rayon){
	int iterations =  360/_angle;
	int currentAngle = 0; 

	fill(0);
	stroke(0);
	beginShape();
		
	for (int i = 0; i < iterations; i++) {
		
		satX = _rayon * sin(radians(currentAngle));
		satY = _rayon * cos(radians(currentAngle));
		
		vertex(satX, satY);

		if(debug){
			line(0, 0, satX, satY);
			text(currentAngle, satX+20, satY+20);
			ellipse(satX, satY, 20, 20);
			println("currentAngle: "+currentAngle);
		}

		currentAngle += _angle;
	}

	endShape();
}
