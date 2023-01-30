package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		//colorMode(HSB);
		background(255, 0 , 0);
		
	}

	
	public void draw()
	{	
		noStroke();

		fill(255, 233, 0); // r g b
		circle(250, 250, 400); // centre x, centre y, diameter

		fill(117, 255, 255);
		triangle(0, 400, 500, 400, 255, 0);

		fill(255, 255, 255);
		ellipse(250, 250, 200, 100);

		fill(0, 0, 0);
		circle(250, 250, 50);

		// background(0);
		// circle(mouseX, mouseY, 10);
		
	}

}
