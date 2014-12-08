import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class vertex1 extends PApplet {

int a = 0; 
public void setup() {
	background(255);
	size(600, 600, P2D);
	strokeWeight(5);
	stroke(0);
}

public void draw() {
	background(255);
	translate(width/2, height/2);
	ellipse(0, 0, 5, 5);
	rotate(radians(a));
	showVertex1();

	a++;
}

public void quads(){
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

public void showVertex1(){
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

public void showVertex2(){
	fill(123,210,20);
	beginShape();
		vertex(0, 0);
		vertex(85, 0);
		vertex(85, 85);
		vertex(0, 85);
	endShape(CLOSE);
}

public void showVertexPoints(){
	fill(123,210,20);
	beginShape(POINTS);
		vertex(0, 0);
		vertex(85, 0);
		vertex(85, 85);
		vertex(0, 85);
	endShape();
}

public void showVertexLines(){
	fill(0);
	textAlign(CENTER);
	text("ici les points sont reli\u00e9 2 par 2", 0, -30);

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

public void showVertexTriangles(){

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

public void showVertexTriangleStripes(){

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

public void showVertexTriangleFan(){
	fill(123,210,20);
	beginShape(TRIANGLE_FAN);
		//centre
		vertex(57.5f, 50);
		//1
		vertex(57.5f, 15); 
		//2
		vertex(92, 50); 
		//3
		vertex(57.5f, 85); 
		//4
		vertex(22, 50); 
		//1
		vertex(57.5f, 15); 
	endShape();
}

public void rainbowVertex(){
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
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "vertex1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
