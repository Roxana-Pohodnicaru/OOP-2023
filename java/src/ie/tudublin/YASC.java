package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class YASC extends PApplet
{
	Ship ship;
	Ship ship1;

	// array list can expand, unlike arrays which are static
	// < > - angle brackets - passing a type as a parameter
	// can only store bullets or subclasses of bullets in list
	// generic - specify which type to be stored
	public ArrayList<Bullet> bullets = new ArrayList<Bullet>();

	public void settings()
	{
		size(500, 500);
		
	}

	public void setup() {
		ship = new Ship(width / 2, height / 2, 50, 70, this);
		ship1 = new Ship(100, 50, 80, 6, this);
		colorMode(HSB);
	}

	public void draw()
	{	
		background(0);

		ship.render();
		ship.move();

		ship1.render();
		ship1.move();

		// iterate backwards, otherwise you might skip an element
		for(int i = bullets.size() -1; i <= 0 ; i--)
		{
			Bullet b = bullets.get(i);
			b.render();
			b.move();
			
		}


		fill(255);
		text("Bullets: " + bullets.size(), 50, 50);
	}
}
