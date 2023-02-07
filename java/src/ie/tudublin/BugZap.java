package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
	float playerX, playerY, playerWidth;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(RGB);
		background(0);

		smooth();

		// width of screen built in var from papplet
		playerX = width / 2;
		playerY = height - 50;
		playerWidth = 50;

	}

	void drawPlayer(float x, float y, float w)
	{
		stroke(255);
		noFill();
		// x and y parameters are in the centre instead of left hand corner
		rectMode(CENTER);
		rect(x, y, w, 20);
		line(x, y - 10, x, y - 20);
	}

	public void draw()
	{
		background(0);
		strokeWeight(2);
		drawPlayer(playerX, playerY, playerWidth);
	}
}
