package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet
{
	Ship ship;
	Ship ship1;
	ShipAI shipAI;


	public void settings()
	{
		size(500, 500);
		
	}

	public void setup() {
		ship = new Ship(width / 2, height / 2, 50, 70, this);
		ship1 = new Ship(100, 50, 80, 6, this);
		shipAI = new ShipAI(width/4, height/4, 30, 200, this);
		colorMode(HSB);
	}

	public void draw()
	{	background(0);
		ship.render();
		ship.move();
		
		ship1.render();
		ship1.move();

		shipAI.render();
	}
}
