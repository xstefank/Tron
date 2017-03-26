package cz.muni.fi.pv260.snake.listener;

import cz.muni.fi.pv260.snake.model.GameData;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class KeyboardListener implements KeyListener {

    private GameData gameData;

    public KeyboardListener(GameData gameData) {
        this.gameData = gameData;
    }

    @Override
    public void keyTyped(KeyEvent event) {

    }

    @Override
    public void keyPressed(KeyEvent event) {
        gameData.getSnakeController().processInputEvent(event);
    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
}
