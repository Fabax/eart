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
  
  void update(){
    //noiseFloat = noise(pos.x * 0.0025, pos.y * 0.0025, elapsedFrames * 0.001);
    noiseFloat = noise(pos.x * 0.0125, pos.y * 0.0125, elapsedFrames * 0.001);
    noiseVec.x = cos(((noiseFloat -0.3) * TWO_PI) * 10);
    noiseVec.y = sin(((noiseFloat - 0.3) * TWO_PI) * 10);
    
    vel.add(noiseVec);
    vel.div(2);
    pos.add(vel);
    
    if(1.0-(age/lifeTime) == 0){
     isDead = true; 
    }
    
    if(pos.x < 0 || pos.x > width || pos.y < 0 || pos.y > height){
     isDead = true;
    }
    
    age++;    
  }
  
  void draw(){   



    fill(rgb.x,rgb.y,rgb.z);
    noStroke();
    ellipse(pos.x, pos.y, 1-(age/lifeTime), 1-(age/lifeTime));
  }
};