package cz.muni.fi.pv260.control.controller.keyboard.controller;

import cz.muni.fi.pv260.control.controller.keyboard.KeyboardController;
import cz.muni.fi.pv260.control.direction.Direction;

import java.awt.event.KeyEvent;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class ControllerFactory {

    public static KeyboardController getWSADController(Direction startingDirection) {
        return new WSADController(startingDirection);
    }

    public static KeyboardController getArrowController(Direction startingDirection) {
        return new ArrowController(startingDirection);
    }

    private static final class WSADController extends DirectionControllerAdapter {

        WSADController(Direction startingDirection) {
            super(new DirectionKeySet(KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D), startingDirection);
        }
    }

    private static final class ArrowController extends DirectionControllerAdapter {

        public ArrowController(Direction startingDirection) {
            super(new DirectionKeySet(KeyEvent.VK_UP, KeyEvent.VK_DOWN,
                    KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT), startingDirection);
        }
    }
}
