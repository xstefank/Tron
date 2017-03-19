package cz.muni.fi.pv260;

import cz.muni.fi.pv260.control.collision.CollisionDetector;
import cz.muni.fi.pv260.control.collision.PathCollisionDetector;
import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.control.collision.TraveledPath;
import cz.muni.fi.pv260.control.collision.TraveledPathListImpl;
import cz.muni.fi.pv260.control.controller.KeyboardController;
import cz.muni.fi.pv260.control.controller.KeyboardControllerBuilder;
import cz.muni.fi.pv260.control.direction.Direction;
import cz.muni.fi.pv260.control.direction.DirectionControl2D;
import cz.muni.fi.pv260.control.direction.DirectionControl2DImpl;
import cz.muni.fi.pv260.engine.AbstractInfiniteLoopGameEngine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TronGameEngine extends AbstractInfiniteLoopGameEngine implements KeyListener, MouseListener, MouseMotionListener {

    private DirectionControl2D currentDirectionPlayer1 = new DirectionControl2DImpl(Direction.RIGHT);
    private DirectionControl2D currentDirectionPlayer2 = new DirectionControl2DImpl(Direction.LEFT);
    private KeyboardController controller1;
    private KeyboardController controller2;
    private TraveledPath pathPlayer1 = new TraveledPathListImpl();
    private TraveledPath pathPlayer2 = new TraveledPathListImpl();

    private PathCollisionDetector collisionDetector = new PathCollisionDetector();

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

        //register controllers
        controller1 = new KeyboardControllerBuilder()
                .addKeyboardEvent(KeyEvent.VK_UP, (e -> currentDirectionPlayer1.directUp()))
                .addKeyboardEvent(KeyEvent.VK_DOWN, (e -> currentDirectionPlayer1.directDown()))
                .addKeyboardEvent(KeyEvent.VK_RIGHT, (e -> currentDirectionPlayer1.directRight()))
                .addKeyboardEvent(KeyEvent.VK_LEFT, (e -> currentDirectionPlayer1.directLeft()))
                .build();

        controller2 = new KeyboardControllerBuilder()
                .addKeyboardEvent(KeyEvent.VK_W, (e -> currentDirectionPlayer2.directUp()))
                .addKeyboardEvent(KeyEvent.VK_S, (e -> currentDirectionPlayer2.directDown()))
                .addKeyboardEvent(KeyEvent.VK_D, (e -> currentDirectionPlayer2.directRight()))
                .addKeyboardEvent(KeyEvent.VK_A, (e -> currentDirectionPlayer2.directLeft()))
                .build();

        //setup starting positions
        pathPlayer1.addPointToPath(new Point(40, 40));
        pathPlayer2.addPointToPath(new Point(600, 440));
    }

    @Override
    public void draw(Graphics2D graphics) {
        int moveAmount = 5;
        int xPositionPlayer1 = pathPlayer1.getHeadPosition().getX();
        int yPositionPlayer1 = pathPlayer1.getHeadPosition().getY();
        int xPositionPlayer2 = pathPlayer2.getHeadPosition().getX();
        int yPositionPlayer2 = pathPlayer2.getHeadPosition().getY();

        switch (currentDirectionPlayer1.getDirection()) {
            case UP:
                if (yPositionPlayer1 > 0) {
                    yPositionPlayer1 -= moveAmount;
                } else {
                    yPositionPlayer1 = screenManager.getHeight();
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
                if (yPositionPlayer1 < screenManager.getHeight()) {
                    yPositionPlayer1 += moveAmount;
                } else {
                    yPositionPlayer1 = 0;
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


        pathPlayer1.addPointToPath(new Point(xPositionPlayer1, yPositionPlayer1));
        pathPlayer2.addPointToPath(new Point(xPositionPlayer2, yPositionPlayer2));

        if (collisionDetector.detectCollistionWithPoint(pathPlayer1, pathPlayer2.getHeadPosition()) ||
                collisionDetector.detectCollistionWithPoint(pathPlayer2, pathPlayer1.getHeadPosition())) {
            System.exit(0);
        }

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, screenManager.getWidth(), screenManager.getHeight());

        graphics.setColor(Color.green);
        pathPlayer1.getPoints().forEach(point ->
                graphics.fillRect(point.getX(), point.getY(), 10, 10));

        graphics.setColor(Color.red);
        pathPlayer2.getPoints().forEach(point ->
                graphics.fillRect(point.getX(), point.getY(), 10, 10));

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

        controller1.processKeyboardEvent(keyEvent);
        controller2.processKeyboardEvent(keyEvent);
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
