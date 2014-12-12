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

public class superHeroNoise2 extends PApplet {

int h, w;
PImage source,destination;
ArrayList points = new ArrayList();
int elapsedFrames = 0;
boolean imageLoad = false;
String imageName = "captain2.jpg";
int multiplicator = 1;
boolean showColors = true;
String mainColor = "red";

public void setup() {
  source = loadImage(imageName);
  source.resize(PApplet.parseInt(source.width*multiplicator),PApplet.parseInt(source.height*multiplicator));
  w = source.width;
  h = source.height;

  destination = createImage(w, h, RGB);
  size(w ,h,OPENGL);
  smooth(8);
    // noLoop();
}

public void draw() {
  if(!imageLoad){
  //----Manipulation de l'image
  float threshold = 127;
  // We are going to look at both image's pixels
  source.loadPixels();
  destination.loadPixels();
  
  for (int x = 0; x < source.width; x++) {
    for (int y = 0; y < source.height; y++ ) {
      int loc = x + y*source.width;

      //couleurs
      float r = red(source.pixels[loc]);
      float g = green(source.pixels[loc]);
      float b = blue(source.pixels[loc]);
      PVector rgb = new PVector(r,g,b);

      // Test the brightness against the threshold
      if (brightness(source.pixels[loc]) > threshold) {

        if(showColors){
           destination.pixels[loc]  = color(r,g,b);  // White
        }
        if(mainColor == "red"){
          int rand = (int) random(0, 5);
          if(rand == 1){
            if(r > b && r > g){
              addPoint(x,y,rgb); 
            }
          }
int rand2 = (int) random(0, 3);
          if(rand2 == 1){
              if(x > (w/2)-150 && x < (w/2)+200){
              if(b > r && b > g){
            addPoint(x,y,rgb); 
          }
            }
          }
           
          
        }else if(mainColor == "blue"){
          if(b > r && b > g){
            addPoint(x,y,rgb); 
          }

        }else if(mainColor == "green"){
          if(g > r && g > b){
            addPoint(x,y,rgb); 
          }

        }
        

      }  else {
        destination.pixels[loc]  = color(0);    // Black

      }
    }
  }

  // We changed the pixels in destination
  destination.updatePixels();
  image(destination,0,0);
  imageLoad = true;
  }




  //-------Perlin noice
   for(int i = 0; i < points.size(); i++){
     Point localPoint = (Point) points.get(i);
     if(localPoint.isDead == true){
      points.remove(i); 
     }
     localPoint.update();
     localPoint.draw();
  }
  elapsedFrames++;
}

public void addPoint(int _x, int _y, PVector _rgb){
    PVector pos = new PVector();
    pos.x = _x;
    pos.y = _y;

    PVector vel = new PVector();
    vel.x = (0);
    vel.y = (0);
    int lifetime = (int) random(200,300);
    Point punt = new Point(pos, vel, lifetime, _rgb);
    points.add(punt);
  
}


public void keyPressed() {
  if(key == 's' || key =='S'){
    int rand = (int) random(0,100000);
      saveFrame("result/fb-day2.2-"+imageName+rand+".jpg");
  }
}
class Point{
  
  PVector pos, vel, noiseVec;
  float noiseFloat, lifeTime, age;
  boolean isDead;
  PVector rgb; 
  
  public Point(PVector _pos, PVector _vel, float _lifeTime, PVector _rgb){
    pos = _pos;
    vel = _vel;
    lifeTime = _lifeTime;
    age = 0;
    isDead = false;
    noiseVec = new PVector();
    rgb = _rgb;

  }
  
  public void update(){
    //noiseFloat = noise(pos.x * 0.0025, pos.y * 0.0025, elapsedFrames * 0.001);
    noiseFloat = noise(pos.x * 0.0125f, pos.y * 0.0125f, elapsedFrames * 0.001f);
    noiseVec.x = cos(((noiseFloat -0.3f) * TWO_PI) * 10);
    noiseVec.y = sin(((noiseFloat - 0.3f) * TWO_PI) * 10);
    
    vel.add(noiseVec);
    vel.div(2);
    pos.add(vel);
    
    if(1.0f-(age/lifeTime) == 0){
     isDead = true; 
    }
    
    if(pos.x < 0 || pos.x > width || pos.y < 0 || pos.y > height){
     isDead = true;
    }
    
    age++;    
  }
  
  public void draw(){   



    fill(rgb.x,rgb.y,rgb.z);
    noStroke();
    ellipse(pos.x, pos.y, 1-(age/lifeTime), 1-(age/lifeTime));
  }
};
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--hide-stop", "superHeroNoise2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
