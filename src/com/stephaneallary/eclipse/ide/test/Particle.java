package com.stephaneallary.eclipse.ide.test;

import processing.core.*;

public class Particle {
  private PVector location;
  private PVector velocity;
  private PVector acceleration;
  private float lifespan;
  private float mass = 1;
  private PApplet parent;
  private PImage img;

 
 //transformer la particule en shape pour de meilleur performance
 
  Particle(PApplet parent,PVector l, PImage img) {
	this.parent = parent;
    this.acceleration = new PVector(0,(float) 0.2);
    this.velocity = new PVector(this.parent.randomGaussian()/5,(this.parent.randomGaussian()-1)/5);
    this.location = l.get();
    this.lifespan = (float) 255.0;
    this.img = img;
  }
 
  void run() {
	  this.update();
	  this.display();
  }
 
  void update() {
	this.velocity.add(this.acceleration);
	this.location.add(this.velocity);
	this.acceleration.mult(0);
	this.lifespan -= 3.0;
  }
  
  void applyForce(PVector force) {
    PVector f = force.get();
    f.div(this.mass);
    this.acceleration.add(f);
  }
 
  void display() {
	this.parent.imageMode(PApplet.CENTER);
	this.parent.tint(255,this.lifespan/10);
	this.parent.image(this.img,this.location.x,this.location.y);
  }
 
 boolean isDead() {
    if (this.lifespan < 0.0) {
      return true;
    } else {
      return false;
    }
  }
}
