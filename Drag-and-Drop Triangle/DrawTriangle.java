package q2;


import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <p>DrawTriangle.java is a driver and abase class for drawing a triangle
 * object on a panel. It contains various methods below for creating a panel
 * and creating an event when a mouse is clicked, released or dragged.  Upon
 * clicking on the panel, a triangle object is created.  Upon dragging, the 
 * equilateral triangle changes size and orientation based on where the mouse
 * is dragged.  Upon releasing of the mouse, the triangle is erased.
 * The class also prints out messages which indicate what method is being called
 * during the animation.  </p>
 * 
 * @author Steven Ma
 * @version 1.0
 */
public class DrawTriangle extends JFrame {
    /**
     * <p>Constant for size of panel.</p>
     */
    private static final int MAX_SIZE = 400;
    /**
     * <p>Declaration of Triangle object.</p>
     */
    private Triangle triangle;

    /**
     *<p>Constructor for DrawTriangle object.</p> 
     */
    public DrawTriangle() {
        super("Steven Ma");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new DrawTrianglePanel());
        setSize(MAX_SIZE, MAX_SIZE); 
        setVisible(true);
    }

    /**
     * <p>Private class called, "DrawTrianglePanel" which is a child of Jpanel
     * that implements MouseListener and MouseMotionListener. </p>
     * 
     * @author Steven Ma
     * @version 1.0
     */
    private class DrawTrianglePanel extends JPanel implements MouseListener,
    MouseMotionListener {

        /**
         * <p>Constructor for DrawTrianglePanel object.</p>
         */
        DrawTrianglePanel() {
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        /**
         * <p>Method for drawing triangle if there is none. </p>
         * @param g formal parameter for Graphics object inputed.
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // DRAWING CODE HERE
            if (triangle != null) {
                triangle.draw(g);
            }
            System.out.println("Paint called");
        }
        /**
         * <p>Method for when mouse is pressed down. Instantiates triangle 
         * object.</p>
         * @param e formal parameter for MouseEvent inputed
         */
        public void mousePressed(MouseEvent e) {
            System.out.println("Mouse pressed called");
            triangle = new Triangle(e.getPoint());
        }
        /**
         * <p>Method for when mouse is released. Triangle object 
         * reference becomes null.</p>
         * @param e formal parameter for Mouse event inputed
         */
        public void mouseReleased(MouseEvent e) {
            System.out.println("Mouse released called");
            if (triangle != null) {
                triangle = null;
            }
            repaint();
        }
        /**
         * <p>Method for when mouse is dragged in the pressed position.
         * Triangle object uses it's move method.</p>
         * @param e formal parameter for Mouse event inputed
         */
        public void mouseDragged(MouseEvent e) {
            System.out.println("Mouse dragged called");
            triangle.move(e.getPoint());
            repaint();
        }
        /**
         * <p>Method for when mouse moves into panel.</p>
         * @param e formal parameter for Mouse event inputed
         */
        public void mouseEntered(MouseEvent e) {  
        }
        /**
         * <p>Method for when mouse exits panel.</p>
         * @param e formal parameter for Mouse event inputed
         */
        public void mouseExited(MouseEvent e) {
        }
        /**
         * <p>Method for when mouse is clicked (down and up).</p>
         * @param e formal parameter for Mouse event inputed
         */
        public void mouseClicked(MouseEvent e) {

        }
        /**
         * <p>Method for when mouse is moved.</p>
         * @param e formal parameter for Mouse event inputed
         */
        public void mouseMoved(MouseEvent e) {
        }

    }

    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        new DrawTriangle();
    }
};
