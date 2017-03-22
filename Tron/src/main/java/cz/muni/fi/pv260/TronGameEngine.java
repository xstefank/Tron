package cz.muni.fi.pv260;

import cz.muni.fi.pv260.collision.TronCollisionDetector;
import cz.muni.fi.pv260.control.collision.CollisionDetector;
import cz.muni.fi.pv260.control.collision.TraveledPath;
import cz.muni.fi.pv260.controller.GameController;
import cz.muni.fi.pv260.controller.PlayerController;
import cz.muni.fi.pv260.engine.AbstractInfiniteLoopGameEngine;
import cz.muni.fi.pv260.model.Player;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

/**
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class TronGameEngine extends AbstractInfiniteLoopGameEngine implements KeyListener, MouseListener, MouseMotionListener {

    private CollisionDetector<TraveledPath> collisionDetector = new TronCollisionDetector();

    private GameController gameController = new GameController();
    private PlayerController playerController;

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

        gameController = new GameController();
        playerController = new PlayerController(fullScreenWindow);
    }

    @Override
    public void draw(Graphics2D graphics) {
        List<Player> players = gameController.getPlayers();

        players.forEach(player -> playerController.move(player));

        players.forEach(player -> players.forEach(otherPlayer -> {
            if (collisionDetector.detectCollision(player.getPath(), otherPlayer.getPath())) {
                System.exit(0);
            }
        }));

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, screenManager.getWidth(), screenManager.getHeight());

        players.forEach(player -> {
            graphics.setColor(player.getColor());
            player.getPath().getPoints().forEach(point ->
                    graphics.fillRect(point.getCoordinateX(), point.getCoordinateY(), 10, 10));
        });
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        gameController.getPlayers().forEach(player -> player.getKeyboardController().processEvent(keyEvent));
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
