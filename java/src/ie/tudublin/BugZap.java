package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
	float playerX, playerY, playerWidth;
	
	float bugX, bugY, bugWidth;

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

		resetBug();

	}

	private void resetBug()
	{
		bugX = random(bugWidth / 2, width - (bugWidth / 2));
		bugY = 50;
		bugWidth = 50;
	}

	void drawBug(float x, float y, float w)
	{
		float halfw = w / 2;
		stroke(255);
		noFill();
		triangle(x - halfw, y + halfw, x, y - halfw, x + halfw, y + halfw);
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

	float playerSpeed = 5;

	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			playerX -= playerSpeed;
		} // end if
		if (keyCode == RIGHT)
		{
			playerX += playerSpeed;
		} // end if

		// shooting (hitting bug or top of screen)
		if (key == ' ')
		{
			float halfW = bugWidth / 2;

			// am i greater than left hand side of bug + right hand side
			if (playerX > bugX - halfW && playerX < bugX + halfW)
			{
				score++;
				resetBug();
				line(playerX, playerY - 10, playerX, bugY);
			}
			else
			{									// top of screen
				line(playerX, playerY - 10, playerX, 0);
			}
		}

	}

	int score = 0;

	void moveBug()
	{
		bugY++;
		bugX += random(-20, 20);
	}

	public void draw()
	{
		background(0);
		strokeWeight(2);
		drawPlayer(playerX, playerY, playerWidth);
		drawBug(bugX, bugY, bugWidth);
		// if frame count is multiple of 20
		if (frameCount % 20 == 0)
		{
			moveBug();
		}

		// print text to screen (prinf)
		text("Score: " + score, 50, 50);
	}
}
