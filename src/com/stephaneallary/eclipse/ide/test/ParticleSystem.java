package com.stephaneallary.eclipse.ide.test;

import processing.core.*;
import java.util.*;

public class ParticleSystem {
  private ArrayList<Particle> particles;
  private PVector origin;
  private PApplet parent;
  private PImage img;
 

  ParticleSystem(PApplet parent, PVector location,PImage img) {
    this.origin = location.get();
    this.particles = new ArrayList<Particle>();
    this.parent = parent;
    this.img = img;
  }

  void addParticle() {
    this.particles.add(new Particle(this.parent,this.origin,this.img));
  }
  
  void location(float x,float y){
    this.origin = new PVector(x,y);
  }

  // Applying a force as a PVector
  void applyForce(PVector f) {
    for (Particle p: this.particles) {
      p.applyForce(f);
    }
  }


  void run() {
    Iterator<Particle> it = this.particles.iterator();
    while (it.hasNext()) {
      Particle p = (Particle) it.next();
      p.run();
      if (p.isDead()) {
        it.remove();
      }
    }
  }
}
