package q2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * <p>Triangle.java is a base class which provides a blue-print for a 
 * triangle object.  It contains various methods below for returning 
 * x and y coordinates of a mouse click and/or drag on a Jpanel.  The
 * class also provides a calculation for rotating matrix for identifying 
 * the second and third point</p>
 *
 * @author Steven Ma
 * @version 1.0
 */
public class Triangle {
    /**
     * <p>Constant for a triangle which has 3 sides.</p>
     */
    private static final int TRI_SIDES = 3;
    /**
     * <p>Constant for 120 degrees in radians for an equilateral triangle.</p>
     */
    private static final double THETA = 2 * Math.PI / 3;
    /**
     * <p>Constant for X-coordinate of first triangle point.</p>
     */
    private int tipX;
    /**
     * <p>Constant for Y-coordinate of first triangle point.</p>
     */
    private int tipY;
    /**
     * <p>Constant for X-coordinate for center of triangle.</p>
     */
    private int originX;
    /**
     * <p>Constant for Y-coordinate for center of triangle.</p>
     */
    private int originY;
    /**
     * <p>Declaration of color object.</p>
     */
    private Color color;
    /**
     * <p>Constant for X-coordinate of second triangle point.</p>
     */
    private int firstX;
    /**
     * <p>Constant for X-coordinate of third triangle point.</p>
     */
    private int firstY;
    /**
     * <p>Constant for Y-coordinate of second triangle point.</p>
     */
    private int secondX;
    /**
     * <p>Constant for Y-coordinate of third triangle point.</p>
     */
    private int secondY;
    /**
     * <p>Constant for matrix rotation.</p>
     */
    private double ang1 = Math.cos(THETA);
    /**
     * <p>Constant for matrix rotation.</p>
     */
    private double ang2 = Math.sin(THETA);
    /**
     * <p>Array of X-coordinates for each point.</p>
     */
    private int[] arrayX = new int[TRI_SIDES];
    /**
     * <p>Constant for Y-coordinate for each point.</p>
     */
    private int[] arrayY = new int[TRI_SIDES];
    /**
     * <p>Constructor for Triangle object.</p>
     * @param point formal parameter for the Point object inputed.
     */
    public Triangle(Point point) {
        originX = point.x;
        originY = point.y;
        color = Color.green;
    }
    /**
     * <p>Method for returning an array of X-coordinates for each point.</p>
     * @return arrayX
     */
    public int[] xPoints() {
        firstX = (int) ((ang1 * (tipX - originX)) + (-ang2 * (tipY - originY)));
        firstY = (int) (((tipX - originX) * ang2) + ((tipY - originY) * ang1));
        secondX = (int) ((firstX * ang1) + (firstY * -ang2));
        secondY = (int) ((firstX * ang1) + (firstY * ang1));
        arrayX[0] = tipX;
        arrayX[1] = firstX + originX;
        arrayX[2] = secondX + originX;
        return arrayX;
    }
    /**
     * <p>Method for returning an array of Y-coordinates for each point.</p>
     * @return arrayY
     */
    public int[] yPoints() {
        firstX = (int) ((ang1 * (tipX - originX)) + (-ang2 * (tipY - originY)));
        firstY = (int) (((tipX - originX) * ang2) + ((tipY - originY) * ang1));
        secondX = (int) ((firstX * ang1) + (firstY * -ang2));
        secondY = (int) ((firstX * ang2) + (firstY * ang1));
        arrayY[0] = tipY;
        arrayY[1] = firstY + originY;
        arrayY[2] = secondY + originY;
        return arrayY;
    }
    /**
     * <p>Method for filling in the color of the triangle.</p>
     * @param page formal parameter for the Graphics object inputed
     */
    public void draw(Graphics page) {
        page.setColor(color);
        page.fillPolygon(xPoints(), yPoints(), TRI_SIDES);
    }
    /**
     * <p>Method for returning an array of Y-coordinates for each point.</p>
     * @param p formal parameter for the Point object inputed
     */
    public void move(Point p) {
        tipX = p.x;
        tipY = p.y;
    }
}

