package day09hardertriangle;

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
            int x1 = 5, y1 = getHeight() - 5;
            int x2 = getWidth() - 5, y2 = getHeight() - 5;
            int x3 = getWidth() / 2, y3 = 5;
            g.drawLine(getWidth() / 2, 5, 5, getHeight() - 5);
            g.drawLine(5, getHeight() - 5, getWidth() - 5, getHeight() - 5);
            g.drawLine(getWidth() / 2, 5, getWidth() - 5, getHeight() - 5);
            drawFractal(g, x1, y1, x2, y2, x3, y3);
        }
    }

    private void drawFractal(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3) {
        // recursion must end (base case)
        // if (Math.abs(x1 - x3) < 10) return;
        if (Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) < 10) {
            return;
        }
        // draw the first triangle
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x1, y1, x3, y3);

        // compute middle points of each edge
        int xA = (x1 + x3) / 2;
        int yA = (y1 + y3) / 2;
        int xB = (x3 + x2) / 2;
        int yB = (y3 + y2) / 2;
        int xC = (x1 + x2) / 2;
        int yC = (y1 + y2) / 2;
        // call to draw the next level
//        drawFractal(g, xA, yA, xB, yB, xC, yC);
        drawFractal(g, x1, y1, xA, yA, xC, yC);
        drawFractal(g, x2, y2, xB, yB, xC, yC);
        drawFractal(g, xA, yA, xB, yB, x3, y3);
        
    }    
}
