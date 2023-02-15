package ie.tudublin;

import processing.core.PApplet;

public class StarMap extends PApplet
{
	public void settings()
	{
		size(800, 800);
	}

	public void setup() {
		colorMode(RGB);
		background(0);

		smooth();
		
	}
	
	public void draw()
	{	
		strokeWeight(2);

        int x1 = 50;
        int x2 = 50;
        int y1 = 50;
        int y2 = 600;

        stroke(50, 205, 50);
        line(x1, y1, x2, y2);

        // for(int i = 0; i < 12; i++)
        // {
        //     // fill(50, 255, 255);
        //     line(x1, y1, x2, y2);
        // }
	}
}