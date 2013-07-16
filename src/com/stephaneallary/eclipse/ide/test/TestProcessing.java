package com.stephaneallary.eclipse.ide.test;

import processing.core.*;

public class TestProcessing extends PApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ParticleSystem ps;
	private PImage img;

	public static void main(String args[]) {
	    //PApplet.main(new String[] {"--full-screen","com.stephaneallary.eclipse.ide.test.Feu"});
	    PApplet.main(new String[] {"com.stephaneallary.eclipse.ide.test.TestProcessing"});
	}
	
	public void setup() {
		this.size(640,360,P2D);
		this.frameRate(120);
		this.smooth(4);
		this.img = loadImage("particle.png");
		this.ps = new ParticleSystem(this, new PVector(width/2,100),this.img);
	}
	
	public void draw() {
		this.frame.setTitle(frameRate+"");
		this.background(0);
		this.blendMode(ADD);
		for (int i = 0; i < 70; i++) {
			this.ps.addParticle();
		}
		PVector gravity = new PVector(0,(float) -0.05);
		this.ps.applyForce(gravity);
		this.ps.run();
		this.ps.location(mouseX,mouseY);
	}

}
