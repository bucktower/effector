package net.bucktower.effector;

import processing.core.PApplet;
import processing.video.*;


public class Effector extends PApplet {
	
	Capture cam;
	ArrayList<Integer> myColors;
	ImageEditor view;

	void setup() 
	{
	  cam = new Capture(this, 640,360,15);
	  frameRate(15);
	  size(640*2,360);
	  cam.start();
	  // this next part waits for the camera to warm up.
	  int i=0;
	  while (cam.available() == false)
	  {
	    println("waiting: "+i); // do nothing - wait!
	    i++;
	  } // done waiting....

	  
	  myColors = new ArrayList<Integer>();  // why Integer? It's complicated. Colors are really just ints.
	  myColors.add(color(200,0,0)); // red
	  myColors.add(color(200,100,0)); // orange 
	  myColors.add(color(200,200,0)); // yellow
	  myColors.add(color(0,200,0)); // green
	  myColors.add(color(0,200,100));  // cyan
	  myColors.add(color(0,0,200));  // blue
	  myColors.add(color(100,0,200)); // purple
	  myColors.add(color(200,200,200)); // white
	  //myColors.add(color(0,0,0));  // black
	}

	void draw()
	{
	  cam.read();
	  view = new ImageEditor(cam);
	  view.drawAt(0,0);
	  view.startEditing();
	    for (int y=0; y<view.height(); y++)
	      for (int x=0; x<view.width(); x++)
	      {
	          // find which color in the list is the closest to the color at (x,y).
	          color closestColor = color(0,0,0); // black... but we can do better.
	          
	          float minDistSquared = 3*pow(256,2);  // worse than any possible color distance....
	          
	          for (color c: myColors)
	          {
	             // how far is the color at (x,y) from this item in the list?
	             float colDist = colorDistanceSquared(c,view.colorAt(x,y));
	             if (colDist<minDistSquared)
	             {
	                 minDistSquared = colDist;
	                 closestColor = c;
	             } 
	          }
	          // now that we've found which color is closest to the original pixel, we'll replace
	          // the pixel with that color.
	          view.setColorAt(closestColor,x,y);
	      }
	  view.stopEditing();
	  view.drawAt(640,0);
	   
	}

	float colorDistanceSquared(color c1, color c2)
	{
	   //Note: I'm not square rooting this to save time...
	   return pow(red(c1)-red(c2),2)+pow(green(c1)-green(c2),2)+pow(blue(c1)-blue(c2),2); 
	}

	
	public static void main(String _args[]) {
		PApplet.main(new String[] { net.bucktower.effector.Effector.class.getName() });
	}
}
