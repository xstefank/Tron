package cz.muni.fi.pv260;

import cz.muni.fi.pv260.control.Direction;
import cz.muni.fi.pv260.control.DirectionControl2D;
import cz.muni.fi.pv260.control.DirectionControl2DImpl;
import cz.muni.fi.pv260.engine.AbstractInfiniteLoopGameEngine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class TronGameEngine extends AbstractInfiniteLoopGameEngine implements KeyListener, MouseListener, MouseMotionListener {

    private int xPositionPlayer1 = 40;
    private int yPossitionPlayer1 = 40;
    private int xPositionPlayer2 = 600;
    private int yPositionPlayer2 = 440;
    private DirectionControl2D currentDirectionPlayer1 = new DirectionControl2DImpl(Direction.RIGHT);
    private DirectionControl2D currentDirectionPlayer2 = new DirectionControl2DImpl(Direction.LEFT);

    private List<Integer> xPathPlayer1 = new ArrayList<>();
    private List<Integer> yPathPlayer1 = new ArrayList<>();
    private List<Integer> xPathPlayer2 = new ArrayList<>();
    private List<Integer> yPathPlayer2 = new ArrayList<>();

    public static void main(String[] args) {
        new TronGameEngine().run();
    }

    @Override
    public void init() {
        super.init();

        Window fullScreenWindow = screenManager.getFullScreenWindow();
        fullScreenWindow.addKeyListener(this);
        fullScreenWindow.addMouseListener(this);
        fullScreenWindow.addMouseMotionListener(this);
    }

    @Override
    public void draw(Graphics2D graphics) {
        int moveAmount = 5;

        switch (currentDirectionPlayer1.getDirection()) {
            case UP:
                if (yPossitionPlayer1 > 0) {
                    yPossitionPlayer1 -= moveAmount;
                } else {
                    yPossitionPlayer1 = screenManager.getHeight();
                }
                break;
            case RIGHT:
                if (xPositionPlayer1 < screenManager.getWidth()) {
                    xPositionPlayer1 += moveAmount;
                } else {
                    xPositionPlayer1 = 0;
                }
                break;
            case DOWN:
                if (yPossitionPlayer1 < screenManager.getHeight()) {
                    yPossitionPlayer1 += moveAmount;
                } else {
                    yPossitionPlayer1 = 0;
                }
                break;
            case LEFT:
                if (xPositionPlayer1 > 0) {
                    xPositionPlayer1 -= moveAmount;
                } else {
                    xPositionPlayer1 = screenManager.getWidth();
                }
                break;
        }
        switch (currentDirectionPlayer2.getDirection()) {
            case UP:
                if (yPositionPlayer2 > 0) {
                    yPositionPlayer2 -= moveAmount;
                } else {
                    yPositionPlayer2 = screenManager.getHeight();
                }
                break;
            case RIGHT:
                if (xPositionPlayer2 < screenManager.getWidth()) {
                    xPositionPlayer2 += moveAmount;
                } else {
                    xPositionPlayer2 = 0;
                }
                break;
            case DOWN:
                if (yPositionPlayer2 < screenManager.getHeight()) {
                    yPositionPlayer2 += moveAmount;
                } else {
                    yPositionPlayer2 = 0;
                }
                break;
            case LEFT:
                if (xPositionPlayer2 > 0) {
                    xPositionPlayer2 -= moveAmount;
                } else {
                    xPositionPlayer2 = screenManager.getWidth();
                }
                break;
        }

        for (int x = 0; x < xPathPlayer1.size(); x++) {
            if (((xPositionPlayer1 == xPathPlayer1.get(x)) && (yPossitionPlayer1 == yPathPlayer1.get(x))) ||
                    ((xPositionPlayer2 == xPathPlayer2.get(x)) && (yPositionPlayer2 == yPathPlayer2.get(x))) ||
                    ((xPositionPlayer1 == xPathPlayer2.get(x)) && (yPossitionPlayer1 == yPathPlayer2.get(x))) ||
                    ((xPositionPlayer2 == xPathPlayer1.get(x)) && (yPositionPlayer2 == yPathPlayer1.get(x)))) {
                System.exit(0);
            }
        }

        xPathPlayer1.add(xPositionPlayer1);
        yPathPlayer1.add(yPossitionPlayer1);
        xPathPlayer2.add(xPositionPlayer2);
        yPathPlayer2.add(yPositionPlayer2);

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, screenManager.getWidth(), screenManager.getHeight());
        for (int x = 0; x < xPathPlayer1.size(); x++) {
            graphics.setColor(Color.green);
            graphics.fillRect(xPathPlayer1.get(x), yPathPlayer1.get(x), 10, 10);
            graphics.setColor(Color.red);
            graphics.fillRect(xPathPlayer2.get(x), yPathPlayer2.get(x), 10, 10);
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            currentDirectionPlayer1.directUp();
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            currentDirectionPlayer1.directDown();
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            currentDirectionPlayer1.directRight();
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            currentDirectionPlayer1.directLeft();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_W) {
            currentDirectionPlayer2.directUp();
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_S) {
            currentDirectionPlayer2.directDown();
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_D) {
            currentDirectionPlayer2.directRight();
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_A) {
            currentDirectionPlayer2.directLeft();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
