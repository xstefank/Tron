package cz.muni.fi.pv260;

import cz.muni.fi.pv260.collision.TronCollisionDetector;
import cz.muni.fi.pv260.control.collision.CollisionDetector;
import cz.muni.fi.pv260.control.collision.TraveledPath;
import cz.muni.fi.pv260.controller.GameController;
import cz.muni.fi.pv260.controller.PlayerController;
import cz.muni.fi.pv260.controller.listener.KeyboardInputListener;
import cz.muni.fi.pv260.engine.AbstractInfiniteLoopGameEngine;
import cz.muni.fi.pv260.model.Player;
import cz.muni.fi.pv260.presentation.TronScreenManagerAdapter;

import java.util.List;

/**
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class TronGameEngine extends AbstractInfiniteLoopGameEngine {

    private CollisionDetector<TraveledPath> collisionDetector = new TronCollisionDetector();

    private GameController gameController = new GameController();
    private PlayerController playerController;

    private TronScreenManagerAdapter screenManager = new TronScreenManagerAdapter();

    public static void main(String[] args) {
        new TronGameEngine().run();
    }

    @Override
    public void run() {
        try {
            super.run();
        } finally {
            screenManager.restoreUserEnvironment();
        }
    }

    @Override
    public void init() {
        super.init();

        gameController = new GameController();
        playerController = new PlayerController(screenManager.getWindow());
        registerInputHandlers();
    }

    @Override
    public void update() {
        updateActivePlayersAndRedrawWindow(gameController.getPlayers());
    }

    private void registerInputHandlers() {
        screenManager.getWindow().addKeyListener(new KeyboardInputListener(gameController));
    }

    private void updateActivePlayersAndRedrawWindow(List<Player> players) {
        moveAndCheckPlayerCollisions(players);
        screenManager.updateWindow(players);
    }

    private void moveAndCheckPlayerCollisions(List<Player> players) {
        movePlayersOneStep(players);
        checkPlayersCollisions(players);
    }

    private void movePlayersOneStep(List<Player> players) {
        players.forEach(player -> playerController.move(player));
    }

    private void checkPlayersCollisions(List<Player> players) {
        players.forEach(player -> players.forEach(otherPlayer -> {
            if (collisionDetector.detectCollision(player.getPath(), otherPlayer.getPath())) {
                System.exit(0);
            }
        }));
    }
}
