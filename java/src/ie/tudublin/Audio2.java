package ie.tudublin;

import processing.core.PApplet;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import ddf.minim.AudioBuffer;

public class Audio2 extends PApplet{

    Minim m;
    AudioInput ai; // access microphone
    AudioPlayer ap;
    AudioBuffer ab; 

    FFT fft;

    public void settings()
    {
        size(1024, 1024);
    }

    public void setup()
    {
        // connect to minim library
        m = new Minim(this);
        
        // connect to mic
        // pars - describe digital audio
        // minim, frame size (fit across width of screen), sample rate, size of each sample in bits
        ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        
        // mix left and right channels
        ab = ai.mix;

        lerpedBuffer = new float[width];

        // frame size, sample rate
        fft = 
    }

    float[] lerpedBuffer;

    public void draw()
    {
        background(0);
        colorMode(HSB);

        float half = height / 2;
        
        // iterate over audio buffer
        for(int i = 0; i < ab.size(); i++)
        {   
            // mapping onto hsb colour space from left to right
            stroke(map(i, 0, ab.size(), 0, 255), 255, 255); 

            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);

            // put same value above and below line
            float f = abs(lerpedBuffer[i] * half * 2.0f);

            // go above line              // span screen ab.get(i)
            line(i, half + f, i, half - f);
        }

        fft.forward(ab);
        stroke(255);

        int highestIndex = 0;

        // how much energy in spectrum (between 0 and 1, NOT 1 to -1)
        for(int i = 0; i < fft.specSize() / 2; i++)
        {
            line(i * 2.0f, height, i * 2.0f, height - fft.getBand(i) * 5.0f);

            if(fft.getBand(i) > fft.getBand(highestIndex))
            {
                highestIndex = i;
            }
        }

        float freq = fft.indexToFreq(highestIndex);
        fill(255);
        textSize(20);
        text("Freq: " + freq, 10, 100);

        // between 0 - 10 on range 1000 to 2000
        // 50 % (5) along 1000 and 2000
        // println(map(5, 0, 10, 1000, 2000));
        // println(map1(5, 2, 10, 1000, 2000));
    }

    // percentage

    float map1(float a, float b, float c, float d, float e)
    {
        float range1 = c - b;
        float range2 = e - d;

        // how far a is in range c - b
        float howFar = a - b;

        return d + (howFar / range1) * range2;
    }

    
}