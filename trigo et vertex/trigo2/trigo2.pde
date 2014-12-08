float angle, rayon ; 
int satX, satY; 
int tailleEllipse; 
int angle360; 

boolean goRound = true;

void setup() {
	size(512, 512, P2D);
	background(255);
	tailleEllipse = 200;
	rayon = tailleEllipse/2; 
	angle = radians(angle360); 
	
	smooth(8);
}

void draw() {
	background(255);

	pushMatrix();
		//cercle de debug 
		fill(255);
		stroke(120);
		strokeWeight(3);
		translate(width/2, height/2);
		ellipse(0, 0, tailleEllipse, tailleEllipse );

		// !!!!! IMPORTANT
		satX = int(rayon * sin(angle));
		satY = int(rayon * cos(angle));
		// !!!!! IMPORTANT 
		// 
		line(0, 0, satX, satY);


		fill(255,0,0);
		noStroke();
		ellipse(satX, satY, 20, 20);
		
	popMatrix();

	if(angle360 > 360){
		goRound = false; 
	}else if(angle360 < 0){
		goRound = true; 
	}

	if(goRound){
		angle360 ++;
	}else{
		angle360 --; 
	}

	angle = radians(angle360); 


	
}
