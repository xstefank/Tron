package cz.muni.fi.pv260.controller.listener;

import cz.muni.fi.pv260.model.GameData;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class KeyboardInputListener implements KeyListener {

    private GameData gameData;

    public KeyboardInputListener(GameData gameData) {
        this.gameData = gameData;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        gameData.getKeyboardControllers().forEach(playerController -> playerController.processInputEvent(event));
    }

    @Override
    public void keyTyped(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
}
