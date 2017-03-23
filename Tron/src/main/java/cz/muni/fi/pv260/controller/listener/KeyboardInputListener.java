package cz.muni.fi.pv260.controller.listener;

import cz.muni.fi.pv260.controller.GameController;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class KeyboardInputListener implements KeyListener {

    private GameController gameController;

    public KeyboardInputListener(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        gameController.getPlayers().forEach(player -> player.getKeyboardController().processEvent(event));
    }

    @Override
    public void keyTyped(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
}
