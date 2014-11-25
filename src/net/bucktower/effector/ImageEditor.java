// version 1.1
// October 13, 2014
// author: Harlan Howe

package net.bucktower.effector;

import processing.core.PImage;

class ImageEditor extends SketchObject
{
  int myWidth, myHeight, myNumPixels;
  PImage myImage;
  int[] myPixels;
  boolean isEditing;

  /**
  * loads the given filename and creates an imageEditor of it.
  * @param the name of the file holding an image that we should use.
  */
  public ImageEditor(String filename)
  {
     this(SketchObject.loadImage(filename));  
  }

  /**
  * creates an ImageEditor of specified (width,height) that starts off blank - using ARGB format.
  * @param width - the width of the blank image created.
  * @param height  the height of the blank image created.
  */
  public ImageEditor(int width, int height)
  {
     this(createImage(width,height,ARGB())); 
  }
  /*
  * creates an ImageEditor of specified (w, h) that is filled with content from the screen,
  * using the rectangular section (startX, startY, w, h) as the source of that content.
  * Note: the rectangular section must fall within the confines of the screen.
  */
  public ImageEditor(int startX, int startY, int w, int h)
  {
     this(w,h);
     if (startX+w>SketchObject.width || startY+h>SketchObject.height)
       throw new RuntimeException("Attempted to create image with rectangular data from ("+
                                   startX+", "+startY+") to ("+(startX+w)+", "+(startY+h)+
                                   "), but the screen is only "+width+" x "+height+" pixels.");
     loadPixels();
     startEditing();
     for (int y = 0; y<h; y++)
        for( int x = 0; x<w; x++)
          setColorAt(pixels((startX+x),(startY+y)), x,y);
     stopEditing();
     updatePixels();
  }  
  
  /**
  * creates an ImageEditor with a <i>copy</i> of the specified image, starting off out of editing mode.
  * @param inImage - the image to copy and use.
  */
  public ImageEditor(PImage inImage)
  {
      if (inImage == null)
      {
        throw new RuntimeException("Attempted to create an ImageEditor with a null image.");
      }
    myImage = createImage(inImage.width,inImage.height,ARGB());
    myImage.copy(inImage,0,0,inImage.width,inImage.height,0,0,inImage.width,inImage.height);
    myWidth = myImage.width;
    myHeight = myImage.height;    
    myNumPixels = myWidth * myHeight;
    isEditing = false;
  }
  
  public int width()
  {   return myWidth; }
  
  public int height()
  {   return myHeight; }
  
  public boolean isEditing()
  {   return isEditing; }
  
  
  /**
  * enter "editing mode" - you can now read and manipulate pixel data, but you
  * cannot draw the image until you exit this mode.
  */
  public void startEditing()
  {
     if (!isEditing)
     {
       myImage.loadPixels();
       myPixels = myImage.pixels;
       isEditing = true;
     }
  }
  
  
  /**
  * exit "editing mode" - you can no longer read or manipulate pixel data,
  * but you can now draw the image.
  */
  public void stopEditing()
  {
    if (isEditing)
    {
      myImage.updatePixels();
      isEditing = false;
    }
  }
  
  
  /**
  * indicates whether the given point is within this image.
  * @param x - the x-coordinate of the pixel
  * @param y - the y-coordinate of the pixel
  */
  public boolean inBounds(int x, int y)
  {
    return (x>=0) && (x<myWidth) && (y>=0) && (y<myHeight);
  }
  
  /**
  * returns the pixel int value at the given coordinates.
  * Note: editing mode must be on to use this method.
  * @param x - the x-coordinate of the pixel
  * @param y - the y-coordinate of the pixel
  * @return the int of the pixel at (x,y)
  */
  public int intAt(int x, int y)
  {
    if (!isEditing)
      throw new RuntimeException("Attempted to get pixel data at ("+x+", "+y+") but image is not in editing mode.");
    if (!inBounds(x,y))
      throw new RuntimeException("Attempted to get pixel data at ("+x+", "+y+") but this must fall between (0,0) and ("+(myWidth-1)+", "+(myHeight-1)+"), inclusive.");
    return myPixels[x+myWidth*y];
  }
  
  
  /**
  * updates the int at the given (x,y) coordinates.
  * note: editing mode must be on to use this method.
  * @param c - the int to which the pixel should be set
  * @param x - the x-coordinate of the pixel
  * @param y - the y-coordinate of the pixel
  */
  public void setColorAt(int c, int x, int y)
  {
    if (!isEditing)
      throw new RuntimeException("Attempted to set pixel data at ("+x+", "+y+") but image is not in editing mode.");
    if (!inBounds(x,y))
      throw new RuntimeException("Attempted to set pixel data at ("+x+", "+y+") but this must fall between (0,0) and ("+(myWidth-1)+", "+(myHeight-1)+"), inclusive.");
    myPixels [x+myWidth*y] = c;
  }

  /**
  * draws the image at the given (x,y) location.
  * Note: this throws an exception (i.e., crashes) if we are in editing mode.
  * @param x - the x-coordinate in the current Matrix where the upper-left image of the image will start.
  * @param y - the y-coordinate in the current Matrix where the upper-left image of the image will start.
  */
  public void drawAt(int x, int y)
  {
     if (isEditing)
       throw new RuntimeException("Attempted to draw image while in \"Editing Mode.\"");
     image(myImage,x,y);  
  }
  
  /**
  * returns a copy of the PImage used in this ImageEditor; further edits to this ImageEditor will
  * not affect the copy returned.
  * @return a copy of the PImage currently used in this ImageEditor. 
  */
  public PImage getImage()
  {
    if (isEditing)
       throw new RuntimeException("Attempted to grab image from Image Editor while in \"Editing Mode.\"");
    PImage tempImage = createImage(myWidth, myHeight,ARGB());
    tempImage.copy(myImage,0,0,myWidth,myHeight,0,0,myWidth,myHeight);
    return tempImage;
    
  }
  
  /**
  * returns the pixel color value at the given coordinates.
  * Note: editing mode must be on to use this method.
  * @param x - the x-coordinate of the pixel
  * @param y - the y-coordinate of the pixel
  * @return the color of the pixel at (x,y)
  */
  public int colorAt(int x, int y)
  {
    if (!isEditing)
      throw new RuntimeException("Attempted to get pixel data at ("+x+", "+y+") but image is not in editing mode.");
    if (!inBounds(x,y))
      throw new RuntimeException("Attempted to get pixel data at ("+x+", "+y+") but this must fall between (0,0) and ("+(myWidth-1)+", "+(myHeight-1)+"), inclusive.");
    return myPixels[x+myWidth*y];
  }
  
}
