class Gommette  {

	float taille = 0.0;
	PVector noiseColor = new PVector(0,0,0);
	PVector c = new PVector(0,0,0);
	PVector p = new PVector(0,0,0);
	float timeColor = 0.01; 

	Gommette (float _t) {
		taille = _t-10; 
		noiseColor.x = round(random(0, 255));
		noiseColor.y = round(random(0, 255));
		noiseColor.z = round(random(0, 255));

	}

	void render(){
		pushStyle();
		animate();
		ellipse(p.x,p.y, taille, taille);
		popStyle(); 
	}

	void animate()	{
	   float distanceSourie = dist(mouseX, mouseY, p.x, p.y);
	   if (distanceSourie < taille/2){

	   	noiseColor.x = noise(timeColor);
	   	noiseColor.y = noise(timeColor+1000);
	   	noiseColor.z = noise(timeColor+2000);

	   	c.x = map(noiseColor.x, 0, 1, 0, 255);
	   	c.y = map(noiseColor.y, 0, 1, 0, 255);
	   	c.z = map(noiseColor.z, 0, 1, 0, 255);

	   	fill(c.x,c.y,c.z);

	   	timeColor += 0.01;
	   }else{
	   	fill(c.x,c.y,c.z);
	   }
	}

	void setPosition(int _x, int _y){
		p.x = _x; 
		p.y = _y; 
	}

}
