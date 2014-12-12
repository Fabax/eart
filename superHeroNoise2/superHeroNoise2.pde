int h, w;
PImage source,destination;
ArrayList points = new ArrayList();
int elapsedFrames = 0;
boolean imageLoad = false;
String imageName = "captain2.jpg";
int multiplicator = 1;
boolean showColors = true;
String mainColor = "red";

void setup() {
  source = loadImage(imageName);
  source.resize(int(source.width*multiplicator),int(source.height*multiplicator));
  w = source.width;
  h = source.height;

  destination = createImage(w, h, RGB);
  size(w ,h,OPENGL);
  smooth(8);
    // noLoop();
}

void draw() {
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

void addPoint(int _x, int _y, PVector _rgb){
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


void keyPressed() {
  if(key == 's' || key =='S'){
    int rand = (int) random(0,100000);
      saveFrame("result/fb-day2.2-"+imageName+rand+".jpg");
  }
}
