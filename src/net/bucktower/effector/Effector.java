package net.bucktower.effector;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.video.*;

public class Effector extends PApplet {
	
	Capture cam;
	ArrayList<Integer> myColors;
	ImageEditor view;
	
	int camWidth = 640;
	int camHeight = 360;

	public void setup() 
	{
	  SketchObject.setApp(this);	
		
	  cam = new Capture(this, camWidth,camHeight,15);
	  frameRate(35);
	  size(camWidth,camHeight);
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

	public void draw()
	{
	  cam.read();
	  view = new ImageEditor(cam);
	  view.startEditing();
	    for (int y=0; y<view.height(); y++)
	      for (int x=0; x<view.width(); x++)
	      {
	          // find which color in the list is the closest to the color at (x,y).
	          int closestColor = color(0,0,0); // black... but we can do better.
	          
	          float minDistSquared = 3*pow(256,2);  // worse than any possible color distance....
	          
	          for (int c: myColors)
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
	  view.drawAt(0,0);
	   
	}

	float colorDistanceSquared(int c1, int c2)
	{
	   //Note: I'm not square rooting this to save time...
	   return pow(red(c1)-red(c2),2)+pow(green(c1)-green(c2),2)+pow(blue(c1)-blue(c2),2); 
	}

	
	public static void main(String _args[]) {
		PApplet.main(new String[] { net.bucktower.effector.Effector.class.getName() });
	}
}
