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
		background(0);
		
	}

	
	public void draw()
	{	
		stroke(255);
		line(10, 10, 100, 100); // x1, y1, x2, y2
		fill(150, 150, 50); // r g b
		circle(300, 250, 70); // centre x, centre y, diameter

		fill(20); // r g b changing rectanlge
		rect(10, 300, 10, 100); // top left x, top left y, width, height
		stroke(127); // outline colour 1 or 3 parameters (0 - 255)

		fill(200, 50, 100); // r g b changing triangle
		triangle(40, 90, 300, 20, 80, 70); // 

		//strokeWeight();
		//noFill();

	}

}
