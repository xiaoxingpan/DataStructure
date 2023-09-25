package day09sqaureCrossFractal;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

public class MainWindow extends JFrame {

    public static void main(String[] args) {
        MainWindow mainWindowForDrawing = new MainWindow();

    }

    public MainWindow() {
        setLayout(new BorderLayout());
        setSize(500, 500);
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
            int x1 = 5, y1 = 5;
            int x2 = getWidth() - 5, y2 = 5;
            int x3 = 5, y3 = getHeight() - 5;
            int x4 = getWidth() - 5, y4 = getHeight() - 5;
            g.drawLine(x1, y1, x2, y2);
            g.drawLine(x1, y1, x3, y3);
            g.drawLine(x2, y2, x4, y4);
            g.drawLine(x3, y3, x4, y4);
            drawFractal(g, x1, y1, x2, y2, x3, y3, x4, y4);

        }
    }

    private void drawFractal(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // recursion must end (base case)
        // if (Math.abs(x1 - x3) < 10) return;
        if (Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) < 10) {
            return;
        }
        // draw the first square up-left
        int xA = (2 * x1 + x2) / 3;
        int yA = y1;
        int xB = (2 * x1 + x2) / 3;
        int yB = (2 * y1 + y3) / 3;
        int xC = x1;
        int yC = (2 * y1 + y3) / 3;

        // draw the first square up-right
        int xD = (2 * x2 + x1) / 3;
        int yD = y1;
        int xE = (2 * x2 + x1) / 3;
        int yE = (2 * y1 + y3) / 3;
        int xF = x2;
        int yF = (2 * y1 + y3) / 3;

        // draw the first square down-left
        int xG = x1;
        int yG = (2 * y3 + y1) / 3;
        int xH = (2 * x1 + x2) / 3;
        int yH = (2 * y3 + y1) / 3;
        int xI = (2 * x1 + x2) / 3;;
        int yI = y3;

        // draw the first square down-right
        int xJ = (2 * x2 + x1) / 3;
        int yJ = (2 * y3 + y1) / 3;
        int xK = x2;
        int yK = (2 * y3 + y1) / 3;
        int xL = (2 * x2 + x1) / 3;
        int yL = y3;

        g.drawLine(xA, yA, xB, yB);
        g.drawLine(xC, yC, xB, yB);

        g.drawLine(xD, yD, xE, yE);
        g.drawLine(xE, yE, xF, yF);

        g.drawLine(xG, yG, xH, yH);
        g.drawLine(xH, yH, xI, yI);

        g.drawLine(xJ, yJ, xK, yK);
        g.drawLine(xJ, yJ, xL, yL);

        // call to draw the next level
        drawFractal(g, x1, y1, xA, yA, xC, yC, xB, yB);
        drawFractal(g, xD, yD, x2, y2, xE, yE, xF, yF);
        drawFractal(g, xG, yG, xH, yH, x3, y3, xI, yI);
        drawFractal(g, xJ, yJ, xK, yK, xL, yL, x4, y4);

    }
}
