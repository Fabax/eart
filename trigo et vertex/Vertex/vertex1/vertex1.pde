int a = 0; 
void setup() {
	background(255);
	size(600, 600, P2D);
	strokeWeight(5);
	stroke(0);
}

void draw() {
	background(255);
	translate(width/2, height/2);
	ellipse(0, 0, 5, 5);
	rotate(radians(a));
	showVertex1();

	a++;
}

void quads(){
	beginShape(QUADS);
		vertex(30, 20);
		vertex(30, 75);
		vertex(50, 75);
		vertex(50, 20);
		vertex(65, 20);
		vertex(65, 75);
		vertex(85, 75);
		vertex(85, 20);
	endShape();
}

void showVertex1(){
	fill(123,210,20);
	beginShape();
	fill(255,0,0);
		vertex(0, 0);
		fill(0,255,0);
		vertex(85, 0);
		fill(0,0,255);
		vertex(85, 85);
		fill(0);
		vertex(0, 85);
	endShape(CLOSE);
}

void showVertex2(){
	fill(123,210,20);
	beginShape();
		vertex(0, 0);
		vertex(85, 0);
		vertex(85, 85);
		vertex(0, 85);
	endShape(CLOSE);
}

void showVertexPoints(){
	fill(123,210,20);
	beginShape(POINTS);
		vertex(0, 0);
		vertex(85, 0);
		vertex(85, 85);
		vertex(0, 85);
	endShape();
}

void showVertexLines(){
	fill(0);
	textAlign(CENTER);
	text("ici les points sont relié 2 par 2", 0, -30);

	fill(123,210,20);
	beginShape(LINES);
		vertex(0, 0);
		vertex(85, 0);
		vertex(85, 85);
		vertex(0, 85);
	endShape();

	text("1",0, -10);
	text("2",85, -10);
	text("3",85, 75);
	text("4",0, 75);

}

void showVertexTriangles(){

	fill(123,210,20);
	beginShape(TRIANGLE_STRIP);
		// triangle 1
		vertex(30, 75);
		vertex(40, 20);
		vertex(50, 75);
		// Triangle 2
		vertex(60, 20);
		vertex(70, 75);
		vertex(80, 20);
	endShape();
}

void showVertexTriangleStripes(){

	fill(123,210,20);
	beginShape(TRIANGLE_STRIP);
		// triangle 1
		vertex(30, 75);
		vertex(40, 20);
		vertex(50, 75);
		// Triangle 2
		vertex(60, 20);
		vertex(70, 75);
		vertex(80, 20);
	endShape();
}

void showVertexTriangleFan(){
	fill(123,210,20);
	beginShape(TRIANGLE_FAN);
		//centre
		vertex(57.5, 50);
		//1
		vertex(57.5, 15); 
		//2
		vertex(92, 50); 
		//3
		vertex(57.5, 85); 
		//4
		vertex(22, 50); 
		//1
		vertex(57.5, 15); 
	endShape();
}

void rainbowVertex(){
	pushStyle();
		strokeWeight(3);
		beginShape();
			fill(255, 0,0);
			vertex(30, 20);
			fill(0, 255,0);
			vertex(85, 20);
			fill(0, 0,255);
			vertex(85, 75);
			fill(0, 0,0);
			vertex(30, 75);
		endShape(CLOSE);
	popStyle();
}