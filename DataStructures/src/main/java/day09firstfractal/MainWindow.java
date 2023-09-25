package day09firstfractal;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;

public class MainWindow extends JFrame {

    public static void main(String[] args) {
        MainWindow mainWindowForDrawing = new MainWindow();

    }

    public MainWindow() {
        setLayout(new BorderLayout());
        setSize(500, 375);
        setTitle("First window to draw in");
        DrawingArea drawingArea = new DrawingArea();
        add("Center", drawingArea);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen
        setVisible(true);
    }

    private class DrawingArea extends Canvas {

        @Override
        public void paint(Graphics g) {
            // draw the first line
            g.drawLine(10, 10, getWidth() - 10, 10);
            // drawline method is used to draw a straight line from one point to another
            /**
             * g is the Graphics object that represents the drawing surface for
             * the GUI component. (x1, y1) represents the starting point of the
             * line, where (10, 10) is the x and y coordinates respectively.
             * (x2, y2) represents the ending point of the line. getWidth()
             * returns the width of x-coordinate, and getWidth()-10 reduces the
             * x-coordinate by 10 pixels from the right edge of the component.
             */
            int stepY = 25;
            drawFractal(g, 10, getWidth() - 10, 10 + stepY, stepY);
        }
    }

    /**
     * stepY: vertical step between each line levelY: the y-coordinate int
     * fromX, int toX: the x-coordinate of the starting point and the ending
     * point
     */
    private void drawFractal(Graphics g, int fromX, int toX, int levelY, int stepY) {

        int lineWidth = toX - fromX;
        // recursion must end
        if (lineWidth < 3) {
            return;
        }
        g.setColor(randomColor());

        // draw left and right 1/3rd of the width
        g.drawLine(fromX, levelY, fromX + lineWidth / 3, levelY);
        g.drawLine(toX - lineWidth / 3, levelY, toX, levelY);

        drawFractal(g, fromX, fromX + lineWidth / 3, levelY + stepY, stepY);
        drawFractal(g, toX - lineWidth / 3, toX, levelY + stepY, stepY);

    }

    private Color randomColor() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }

}
