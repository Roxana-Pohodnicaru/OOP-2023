package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	int mode = 0;
	float cx;
	float cy;

	public void settings()
	{
		size(500, 500);
		cx = width / 2;
		cy = height / 2;
	}

	public void setup()
	{
		colorMode(HSB);
	}

	public void keyPressed()
	{
		mode = key - '0';
		println(mode);
	}

	public void draw() 
	{
		background(0);
		noStroke();

		switch (mode)
		{
			case 0:
			{
				// width and height of button
				float w = 200;
				float h = 50;

				rectMode(CENTER);

				if (mouseX > cx - (w / 2) && mouseX < cx + (w/2) && mouseY > cy - (h/2) && mouseY < cy + (h/2))
				{
					fill(50, 255, 255);
				}
				else
				{
					fill(200, 255, 255);
				}
				
				rect(cx, cy, w, h);

				break;
			}
			case 1:
			{	//	moving mouse left to right
				int bars = (int) (mouseX / 20.0f);
				float w = width / (float)bars;

				for (int i = 0; i < bars; i++)
				{
					noStroke();
					fill(map(i, 0, bars, 0, 255), 255, 255);
					rect(map(i, 0, bars, 0, 500), 0, w, height);
				}

				break;
			}
			case 2:
			{						
				int numRects = (int) mouseX / 10;
				float w = width / (float) numRects;
				float cgap = 255 / (float) numRects;
				
				for (int i = 0; i < numRects; i++)
				{
					fill(cgap * i, 255, 255);
					rect(i * w, i * w, w, w);
				}

				break;
 			}
			case 3:
			{
				int numRects = (int) mouseX / 10;
				float w = width / (float) numRects;
				float cgap = 255 / (float) numRects;
					
				for (int i = 0; i < numRects; i++)
				{
					fill(cgap * i, 255, 255);
					rect(i * w, i * w, w, w);
					rect(width - ((i + 1) * w), i * w, w, w);
				}

				break;
			}
			case 4:
			{
				int numCircles = (int) mouseX / 10;
				float cgap = 255 / (float) numCircles;
				float gap = width / (float) numCircles;
				float w = width;

				for (int i = numCircles; i >= 1; i--)
				{
					fill(i * cgap, 255, 255);
					w = i * gap;
					ellipse(cx, cy, w, w);
				}

				break;
			}
			case 5:
			{
				int numCircles = (int) mouseX / 10;
				float w = width / (float) numCircles;
				float cgap = 255 / numCircles;

				for (int i = 0; i < numCircles; i++)
				{
					fill(cgap *  i, 255, 255);
					ellipse((w / 2) + w * i, (w / 2) + w, w, w);
				} // end outer for

				break;
			}
			case 6:
			{
				int numCircles = (int) mouseX / 10;
				float w = width / (float) numCircles;
				//				       no. of cols + rows
				float cgap = 255 / (numCircles + numCircles);

				for (int i = 0; i < numCircles; i++)
				{
					for (int j = 0; j < numCircles; j++)
					{
						fill(cgap * (i + j), 255, 255);
						ellipse((w / 2) + w * j, (w / 2) + w * i, w, w);
					} // end inner for
				} // end outer for
			}
			case 7:
			{
				background(0);
				stroke(255, 255, 255);	
				float cx = width / 2;
				float cy = height / 2;	
				float radius = 200;		
				int points = (int)map(mouseX, 1, width, 5, 20);
				int sides = points * 2;
				float px = cx;
				float py = cy - radius; 

				for(int i = 0 ; i <= sides ; i ++)
				{
					float r = (i % 2 == 0) ? radius : radius / 2; 
					// float r = radius;
					float theta = map(i, 0, sides, 0, TWO_PI);
					float x = cx + sin(theta) * r;
					float y = cy - cos(theta) * r;
					
					//circle(x, y, 20);
					line(px, py, x, y);
					px = x;
					py = y;
				}
			}
			case 8:
			{
				background(0);
				colorMode(RGB);

				float border = width * 0.1f;

				for(int i = -5; i <= 5; i ++)
				{
					float x = map(i, -5, 5, border, width - border);

					stroke(0, 255, 0);

					line(x, border, x, height - border);
					line(border, x, width - border, x);
					
					fill(255);
					text(i, x, border * 0.5f);
					text(i, border * 0.5f, x);
				}
			}
			break;
		}
	}
}
