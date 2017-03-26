package cz.muni.fi.pv260;

import cz.muni.fi.pv260.collision.TronCollisionDetector;
import cz.muni.fi.pv260.control.collision.CollisionDetector;
import cz.muni.fi.pv260.control.collision.Path;
import cz.muni.fi.pv260.controller.PlayerController;
import cz.muni.fi.pv260.model.GameData;
import cz.muni.fi.pv260.controller.listener.KeyboardInputListener;
import cz.muni.fi.pv260.controller.listener.MouseInputListener;
import cz.muni.fi.pv260.engine.AbstractInfiniteLoopGameEngine;
import cz.muni.fi.pv260.presentation.TronScreenManagerAdapter;

import java.awt.Window;
import java.util.List;

/**
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class TronGameEngine extends AbstractInfiniteLoopGameEngine {

    private CollisionDetector<Path, Path> collisionDetector = new TronCollisionDetector();

    private GameData gameData;

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

        gameData = new GameData(screenManager.getWindow());
        registerInputHandlers();
    }

    @Override
    public void update() {
        moveAndCheckPlayerCollisions(gameData.getPlayerControllers());
    }

    @Override
    public void redrawWindow() {
        screenManager.updateWindow(gameData.getPlayerControllers());
    }

    private void registerInputHandlers() {
        Window window = screenManager.getWindow();
        window.addKeyListener(new KeyboardInputListener(gameData));
        window.addMouseListener(new MouseInputListener(gameData));
    }

    private void moveAndCheckPlayerCollisions(List<PlayerController> playerControllers) {
        movePlayersOneStep(playerControllers);
        checkPlayersCollisions(playerControllers);
    }

    private void movePlayersOneStep(List<PlayerController> playerControllers) {
        playerControllers.forEach(PlayerController::move);
    }

    private void checkPlayersCollisions(List<PlayerController> playerControllers) {
        playerControllers.forEach(controller -> playerControllers.forEach(otherController -> {
            if (collisionDetector
                    .detectCollision(controller.getPlayer().getPath(), otherController.getPlayer().getPath())) {
                System.exit(0);
            }
        }));
    }
}
