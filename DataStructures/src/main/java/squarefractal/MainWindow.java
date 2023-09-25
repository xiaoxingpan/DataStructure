package squarefractal;

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
        setSize(500, 550);
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
            int length = 250;
            int n = (getWidth() - length) / 2;
            int x1 = n, y1 = n;
            int x2 = length + n, y2 = y1;
            int x3 = x1, y3 = length + n;
            int x4 = x2, y4 = y3;
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

        // compute de length of the new square
        int eachSide = (x2 - x1) / 3;

        // draw the top square 
        int xA = x1 + eachSide;
        int yA = y1 - eachSide;
        int xB = x1 + 2 * eachSide;
        int yB = yA;
        int xC = xA;
        int yC = y1;
        int xD = xB;
        int yD = yC;

        // draw the down square
        int xE = xA;
        int yE = y3;
        int xF = xB;
        int yF = yE;
        int xG = xE;
        int yG = y3 + eachSide;
        int xH = xF;
        int yH = yG;

        // draw the left square
        int xI = x1 - eachSide;
        int yI = y1 + eachSide;
        int xJ = x1;
        int yJ = y1 + eachSide;
        int xK = xI;
        int yK = y1 + 2 * eachSide;
        int xL = xJ;
        int yL = yK;

        // draw the right square
        int xM = x2;
        int yM = y2 + eachSide;
        int xN = x2 + eachSide;
        int yN = yM;
        int xO = xM;
        int yO = y2 + 2 * eachSide;
        int xP = xN;
        int yP = yO;

        g.drawLine(xA, yA, xB, yB);
        g.drawLine(xA, yA, xC, yC);
        g.drawLine(xB, yB, xD, yD);
        g.drawLine(xC, yC, xD, yD);

        g.drawLine(xE, yE, xF, yF);
        g.drawLine(xG, yG, xH, yH);
        g.drawLine(xE, yE, xG, yG);
        g.drawLine(xF, yF, xH, yH);

        g.drawLine(xI, yI, xJ, yJ);
        g.drawLine(xI, yI, xK, yK);
        g.drawLine(xK, yK, xL, yL);
        g.drawLine(xJ, yJ, xL, yL);

        g.drawLine(xM, yM, xN, yN);
        g.drawLine(xM, yM, xO, yO);
        g.drawLine(xO, yO, xP, yP);
        g.drawLine(xN, yN, xP, yP);

        // call to draw the next level
        drawFractal(g, xA, yA, xB, yB, xC, yC, xD, yD);
        drawFractal(g, xE, yE, xF, yF, xG, yG, xH, yH);
        drawFractal(g, xI, yI, xJ, yJ, xK, yK, xL, yL);
        drawFractal(g, xM, yM, xN, yN, xO, yO, xP, yP);
    }
}
