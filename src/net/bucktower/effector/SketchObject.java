package net.bucktower.effector;

import java.awt.Color;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

/**
 * This baby is a wrapper class
 * 
 * @author johnchuray
 */
public class SketchObject {

	protected static PApplet app;
	protected static PGraphics g;
	protected static int width, height;
	
	public static void setApp(PApplet newApp)
	{
	    app = newApp;
	    width = app.width;
	    height = app.height;
	    g = app.g;
	}
	
	public int CORNERS()
	{
	    return app.CORNERS;
	}
	
	public void resetMatrix()
	{
	    g.resetMatrix();
	}
	
	public void pushMatrix()
	{
	    g.pushMatrix();
	}
	
	public void popMatrix()
    {
        g.popMatrix();
    }
	
	public void translate(float x, float y)
	{
	    g.translate(x, y);
	}
	
	public void translateX(float xTrans)
	{
	    g.translate(xTrans, 0);
	}
	
	public void translateY(float yTrans)
    {
        g.translate(0, yTrans);
    }
	
	/**
	 * The parameters change meanings based off of rectMode
	 * 
	 * CENTER:  Center the rect at (a, b) with a xDiameter of c and yDiameter of d
	 * 		(centerX, centerY, width, height)
	 * CORNER:  Place the upperLeftCorner of the rect at (a, b) with a width and height c and d
	 * 		(x, y, width, height)
	 * CORNERS: Draws rect() from (a,b) to (c, d)
	 * 		(x1, y1, x2, y2)
	 * RADIUS:  Center the rect at (a, b) and double (c, d)
	 * 		(centerX, centerY, halfWidth, halfHeight)
	 */
	public void rect(float a, float b, float c, float d)
	{
		g.rect(a, b, c, d);
	}
	
	/**
	 * The parameters change meanings based off of rectMode
	 * 
	 * CENTER:  Center the rect at (a, b) with a xDiameter of c and yDiameter of d
	 * 		(centerX, centerY, width, height)
	 * CORNER:  Place the upperLeftCorner of the rect at (a, b) with a width and height c and d
	 * 		(x, y, width, height)
	 * CORNERS: Draws rect() from (a,b) to (c, d)
	 * 		(x1, y1, x2, y2)
	 * RADIUS:  Center the rect at (a, b) and double (c, d)
	 * 		(centerX, centerY, halfWidth, halfHeight)
	 * 
	 * r always signifies a rounding to the rectangle based off pixels to the corner
	 */
	public void rect(float a, float b, float c, float d, float r)
	{
		g.rect(a, b, c, d, r);
	}
	
	/**
	 * The parameters change meanings based off of rectMode
	 * 
	 * CENTER:  Center the rect at (a, b) with a xDiameter of c and yDiameter of d
	 * 		(centerX, centerY, width, height)
	 * CORNER:  Place the upperLeftCorner of the rect at (a, b) with a width and height c and d
	 * 		(x, y, width, height)
	 * CORNERS: Draws rect() from (a,b) to (c, d)
	 * 		(x1, y1, x2, y2)
	 * RADIUS:  Center the rect at (a, b) and double (c, d)
	 * 		(centerX, centerY, halfWidth, halfHeight)
	 * 
	 * the last four values indicate individual corners rounding going counter clockwise
	 * the rounding is based off distance of the corner
	 */
	public void rect(float a, float b, float c, float d, float tl, float tr, float br, float bl)
	{
		g.rect(a, b, c, d, tl, tr, br, bl);
	}
	
	/**
	 * Effects the rect() command
	 * 
	 * CENTER:  Center the rect at (a, b) with a xDiameter of c and yDiameter of d
	 * 		(centerX, centerY, width, height)
	 * CORNER:  Place the upperLeftCorner of the rect at (a, b) with a width and height c and d
	 * 		(x, y, width, height)
	 * CORNERS: Draws rect() from (a,b) to (c, d)
	 * 		(x1, y1, x2, y2)
	 * RADIUS:  Center the rect at (a, b) and double (c, d)
	 * 		(centerX, centerY, halfWidth, halfHeight)
	 * @param mode
	 */
	public void rectMode(int mode)
	{
		g.rectMode(mode);
	}
	
	
	/**
	 * the parameters change meaning based off of ellipseMode
	 * 
	 * CENTER:  Center the ellipse at (x, y)
	 * 		(centerX, centerY, width, height)
	 * CORNER:  Place the upperLeftCorner of the ellipse at (x, y)
	 * 		(x, y, width, height)
	 * CORNERS: Draws ellipse() from (x,y) to (width, height)
	 * 		(x1, y1, x2, y2)
	 * RADIUS:  Center the ellipse at (x, y) and double (width, height)
	 * 		(centerX, centerY, halfWidth, halfHeight)
	 */
	public void ellipse(float a, float b, float c, float d)
	{
		g.ellipse(a, b, c, d);
	}
	
	/**
	 * the parameters change meaning based off of ellipseMode
	 * 
	 * CENTER:  Center the ellipse at (x, y)
	 * 		(centerX, centerY, width, height)
	 * CORNER:  Place the upperLeftCorner of the ellipse at (x, y)
	 * 		(x, y, width, height)
	 * CORNERS: Draws ellipse() from (x,y) to (width, height)
	 * 		(x1, y1, x2, y2)
	 * RADIUS:  Center the ellipse at (x, y) and double (width, height)
	 * 		(centerX, centerY, halfWidth, halfHeight)
	 * 
	 * start is the radians of where to start drawing the circle from
	 * stop is the radians of where to stop drawing the circle to
	 * 0 is directly right of the center and continues counter clockwise
	 */
	public void arc(float a, float b, float c, float d, float start, float stop)
	{
		g.arc(a, b, c, d, start, stop);
	}
	
	/**
	 * the parameters change meaning based off of ellipseMode
	 * 
	 * CENTER:  Center the ellipse at (x, y)
	 * 		(centerX, centerY, width, height)
	 * CORNER:  Place the upperLeftCorner of the ellipse at (x, y)
	 * 		(x, y, width, height)
	 * CORNERS: Draws ellipse() from (x,y) to (width, height)
	 * 		(x1, y1, x2, y2)
	 * RADIUS:  Center the ellipse at (x, y) and double (width, height)
	 * 		(centerX, centerY, halfWidth, halfHeight)
	 * 
	 * start is the radians of where to start drawing the circle from
	 * stop is the radians of where to stop drawing the circle to
	 * 0 is directly down of the center and continues counter clockwise
	 * 
	 * mode changes the way of the fill and stroke
	 */
	public void arc(float a, float b, float c, float d, float start, float stop, int mode)
	{
		g.arc(a, b, c, d, start, stop, mode);
	}
	
	/**
	 * Effects the ellipse() and arc() commands
	 * 
	 * CENTER:  Center the ellipse at (x, y)
	 * 		(centerX, centerY, width, height)
	 * CORNER:  Place the upperLeftCorner of the ellipse at (x, y)
	 * 		(x, y, width, height)
	 * CORNERS: Draws ellipse() from (x,y) to (width, height)
	 * 		(x1, y1, x2, y2)
	 * RADIUS:  Center the ellipse at (x, y) and double (width, height)
	 * 		(centerX, centerY, halfWidth, halfHeight)
	 * 
	 * @param mode
	 */
	public void ellipseMode(int mode)
	{
		g.ellipseMode(mode);
	}
	
	/**
	 * Fills that pixel using strokeColor
	 */
	public void point(float x, float y)
	{
		g.point(x, y);
	}
	
	/**
	 * Fills that pixel using strokeColor
	 */
	public void point(float x, float y, float z)
	{
		g.point(x, y, z);
	}
	
	/**
	 * Draws a line between two points
	 * Uses strokeColor
	 */
	public void line(float x1, float y1, float x2, float y2)
	{
		g.line(x1, y1, x2, y2);
	}
	
	/**
	 * Draws a 3D line connecting two points
	 * Uses strokeColor
	 */
	public void line(float x1, float y1, float z1, float x2, float y2, float z2)
	{
		g.line(x1, y1, z1, x2, y2, z2);
	}
	
	/**
	 * Give the four corners in (x, y)
	 * Uses strokeColor to draw lines between
	 * Uses fillColor to fill area
	 */
	public void quad(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4)
	{
		g.quad(x1, y1, x2, y2, x3, y3, x4, y4);
	}
	
	/**
	 * Give the (x,y) locs of the vertices
	 */
	public void triangle(float x1, float y1, float x2, float y2, float x3, float y3)
	{
		g.triangle(x1, y1, x2, y2, x3, y3);
	}
	
	public void stroke(float gray)
	{
		g.stroke(gray);
	}
	
	public void stroke(int rgb)
	{
		g.stroke(rgb);
	}
	
	public void stroke(Color c)
	{
		g.stroke(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
	}
	
	public void stroke(float red, float green, float blue)
	{
		g.stroke(red, green, blue);
	}
	
	public void stroke(float red, float green, float blue, float alpha)
	{
		g.stroke(red, green, blue, alpha);
	}
	
	public void stroke(float gray, float alpha)
	{
		g.stroke(gray, alpha);
	}
	
	public void stroke(int rgb, int alpha)
	{
		g.stroke(rgb, alpha);
	}
	
	public void strokeWeight(float weight)
	{
		g.strokeWeight(weight);
	}
	
	public void noStroke()
	{
		g.noStroke();
	}
	
	public void fill(float gray)
	{
		g.fill(gray);
	}
	
	public void fill(int rgb)
	{
		g.fill(rgb);
	}
	
	public void fill(Color c)
	{
		g.fill(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
	}
	
	public void fill(float red, float green, float blue)
	{
		g.fill(red, green, blue);
	}
	
	public void fill(float red, float green, float blue, float alpha)
	{
		g.fill(red, green, blue, alpha);
	}
	
	public void fill(float gray, float alpha)
	{
		g.fill(gray, alpha);
	}
	
	public void fill(int rgb, int alpha)
	{
		g.fill(rgb, alpha);
	}
	
	public void noFill()
	{
		g.noFill();
	}
	
	public int fillColor()
	{
	    return g.fillColor;
	}
	
	/**
	 * Draws all geometry with smooth (anti-aliased) edges. smooth() will also improve image quality of resized images. 
	 * Note that smooth() is active by default; noSmooth() can be used to disable smoothing of geometry, images, and fonts.
	 * –––
	 * With the default renderer, smooth(2) is bilinear and smooth(4) is bicubic. Nothing implemented on Android 2D.
	 */
	public void smooth()
	{
		g.smooth();
	}
	
	/**
	 * Draws all geometry with smooth (anti-aliased) edges. smooth() will also improve image quality of resized images. 
	 * Note that smooth() is active by default; noSmooth() can be used to disable smoothing of geometry, images, and fonts.
	 * –––
	 * The level parameter increases the level of smoothness with the P2D and P3D renderers. 
	 * This is the level of over sampling glied to the graphics buffer. 
	 * The value "2" will double the rendering size before scaling it down to the display size. 
	 * This is called "2x anti-aliasing." The value 4 is used for 4x anti-aliasing and 8 is specified for 8x anti-aliasing. 
	 * If level is set to 0, it will disable all smoothing; it's the equivalent of the function noSmooth(). 
	 * The maximum anti-aliasing level is determined by the hardware of the machine that is running the software.
	 * –––
	 * With the default renderer, smooth(2) is bilinear and smooth(4) is bicubic. Nothing implemented on Android 2D.
	 */
	public void smooth(int level)
	{
		g.smooth(level);
	}
	
	public void noSmooth()
	{
		g.noSmooth();
	}
	
	public void pushStyle()
	{
	    g.pushStyle();
	}
	
	public void popStyle()
	{
	    g.popStyle();
	}
	
	public static PImage loadImage(String fileName)
	{
	    return app.loadImage(fileName);
	}
	
	public static int ARGB()
	{
	    return app.ARGB;
	}
	
	public static PImage createImage(int width, int height, int type)
	{
	    return app.createImage(width, height, type);
	}
	
	public void loadPixels()
	{
	    g.loadPixels();
	}
	
	public int pixels(int i, int j)
    {
        return g.pixels[i + width * j];
    }
	
	public void updatePixels()
	{
	    g.updatePixels();
	}
	
	public void image(PImage image, int x, int y)
    {
        g.image(image, x, y);
    }
	
	public String[] loadStrings(String fileName)
	{
	    return app.loadStrings(fileName);
	}
	
	public float textWidth(String s)
	{
	    return g.textWidth(s);
	}
	
	public float textWidth(char c)
    {
        return g.textWidth(c);
    }
	
	public void text(String str, float x, float y)
	{
	    g.text(str, x, y);
	}
	
	public void text(char c, float x, float y)
    {
        g.text(c, x, y);
    }
	
	public static void println(Object obj)
	{
	    app.println(obj);
	}

    public static void setGraphics(PGraphics newGraphics)
    {
        g = newGraphics;
        width = g.width;
        height = g.height;
    }
    
    public static float random(float topBounds)
    {
        return app.random(topBounds);
    }
    
    public void background(float grayScale)
    {
        g.background(grayScale);
    }
    
    public void background(int rgb)
    {
        g.background(rgb);
    }
    
    public float sq(float val)
    {
        return app.sq(val);
    }
    
    public float sqrt(float val)
    {
        return app.sqrt(val);
    }
    
    public float max(float x1, float x2)
    {
        return app.max(x1, x2);
    }
    
    public float min(float x1, float x2)
    {
        return app.min(x1, x2);
    }
    
    public float floor(float val)
    {
        return app.floor(val);
    }
    
    public float red(int c)
    {
        return app.red(c);
    }
    
    public float green(int c)
    {
        return app.green(c);
    }
    
    public float blue(int c)
    {
        return app.blue(c);
    }
}
