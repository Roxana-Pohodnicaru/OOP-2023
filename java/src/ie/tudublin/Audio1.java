package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    float waveform;

    public void keyPressed()
    {
		if (key >= '0' && key <= '9')
        {
			mode = key - '0';

		} // end if

        // pauses music if space is pressed
		if (keyCode == ' ') {
            if (ap.isPlaying())
            {
                ap.pause();

            } // end inner if
            else
            {
                ap.rewind();
                ap.play();

            } // end inner else
        } // end if
	} // end void keyPressed

    public void settings()
    {
        size(1024, 1000, P3D);
        //fullScreen(P3D, SPAN);
    } // end void settings

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        // ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        // ab = ai.mix; 

        // And comment the next two lines out
        ap = minim.loadFile("heroplanet.mp3", 1024);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;


        lerpedBuffer = new float[width];        

    } // end void setup


    float off = 0;
    float[] lerpedBuffer;


    public void draw()
    {
        //background(0);
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        off += 1;

        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            sum += abs(ab.get(i));
        }
        average= sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);

        for(int i = 0; i < ab.size(); i++)
        {
            lerpedBuffer[i] = lerp(lerpedBuffer[i], abs(ab.get(i)), 0.05f);
        }
        

        float cx = width / 2;
        float cy = height / 2;

        switch (mode)
        {
			case 0:
            {
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = ab.get(i) * halfH;
                    line(i, halfH + f, i, halfH - f);                    
                } // end for

                break;
            } // end case 0
                
            case 1:
            {
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = ab.get(i) * halfH;
                    line(i, halfH + f, halfH - f, i);                    
                } // end for
    
                break;

            } // end case 1

            case 2:
            {
                background(0);

                for (int i = 0; i < ab.size(); i++)
                {
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);        
                    line(i, halfH - lerpedBuffer[i] * halfH * 4, i, halfH + lerpedBuffer[i] * halfH * 4);
                } 
                
                break;

            } // end case 2

            case 3:
            {
                background(0);

                for (int i = 0; i < ab.size(); i++) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
    
                    line(0, i, lerpedBuffer[i] * halfH * 4, i);
                    line(width, i, width - (lerpedBuffer[i] * halfH * 4), i);
                    line(i, 0, i, lerpedBuffer[i] * halfH * 4);
                    line(i, height, i, height - (lerpedBuffer[i] * halfH * 4));
                }                  

                break;

            } // end case 3
            case 4:
            {
                background(0);
                strokeWeight(1);
                noFill();

                float c = map(smoothedAmplitude, 0, 1f, 0, 255);

                float radius = map(smoothedAmplitude, 0, 1f, 500, 1500);
                
                
                stroke(c, 255, 255);
                circle(cx, cy, radius);


                break;
            }

            case 5:
            {

                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    
                    float f = ab.get(i) * halfH;
                    line(i, lerpedBuffer[i], i, halfH - f);                    
                } // end for

                break;
            }
        } // end switch
        


        
        // Other examples we made in the class
        /*
        stroke(255);
        fill(100, 255, 255);        
        
        circle(width / 2, halfH, lerpedA * 100);

        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);        
        circle(200, smoothedY, 50);
        */

    } // end void draw    
} // end class Audio1