package cz.muni.fi.pv260;

import cz.muni.fi.pv260.collision.TronCollisionDetector;
import cz.muni.fi.pv260.control.collision.CollisionDetector;
import cz.muni.fi.pv260.control.collision.TraveledPath;
import cz.muni.fi.pv260.controller.GameController;
import cz.muni.fi.pv260.controller.PlayerController;
import cz.muni.fi.pv260.controller.listener.KeyboardInputListener;
import cz.muni.fi.pv260.engine.AbstractInfiniteLoopGameEngine;
import cz.muni.fi.pv260.model.Player;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;
import java.util.List;

/**
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class TronGameEngine extends AbstractInfiniteLoopGameEngine {

    private CollisionDetector<TraveledPath> collisionDetector = new TronCollisionDetector();

    private GameController gameController = new GameController();
    private PlayerController playerController;

    public static void main(String[] args) {
        new TronGameEngine().run();
    }

    @Override
    public void init() {
        super.init();

        Window fullScreenWindow = customScreenManager.getFullScreenWindow();

        gameController = new GameController();
        playerController = new PlayerController(fullScreenWindow);
        fullScreenWindow.addKeyListener(new KeyboardInputListener(gameController));
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
        graphics.fillRect(0, 0, customScreenManager.getWidth(), customScreenManager.getHeight());

        players.forEach(player -> {
            graphics.setColor(player.getColor());
            player.getPath().getPoints().forEach(point ->
                    graphics.fillRect(point.getCoordinateX(), point.getCoordinateY(), 10, 10));
        });
    }

}
