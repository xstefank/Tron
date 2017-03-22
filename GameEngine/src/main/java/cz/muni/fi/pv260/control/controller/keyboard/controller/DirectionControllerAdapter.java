package cz.muni.fi.pv260.control.controller.keyboard.controller;

import cz.muni.fi.pv260.control.controller.keyboard.KeyboardAction;
import cz.muni.fi.pv260.control.controller.keyboard.KeyboardController;
import cz.muni.fi.pv260.control.controller.keyboard.KeyboardControllerBuilder;
import cz.muni.fi.pv260.control.direction.Direction;
import cz.muni.fi.pv260.control.direction.DirectionControl2D;
import cz.muni.fi.pv260.control.direction.DirectionControl2DImpl;

import java.awt.event.KeyEvent;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class DirectionControllerAdapter implements KeyboardController {

    private KeyboardController controller;
    private DirectionControl2D directionControl;

    public DirectionControllerAdapter(DirectionKeySet keySet, Direction startingDirection) {
        directionControl = new DirectionControl2DImpl(startingDirection);
        controller = new KeyboardControllerBuilder()
                .addKeyboardEvent(keySet.getUpKeyCode(), e -> directionControl.directUp())
                .addKeyboardEvent(keySet.getDownKeyCode(), e -> directionControl.directDown())
                .addKeyboardEvent(keySet.getLeftKeyCode(), e -> directionControl.directLeft())
                .addKeyboardEvent(keySet.getRightKeyCode(), e -> directionControl.directLeft())
                .build();
    }

    @Override
    public void processEvent(KeyEvent event) {
        controller.processEvent(event);
    }

    @Override
    public void registerKeyboardEvent(KeyEvent event, KeyboardAction action) {
        controller.registerKeyboardEvent(event, action);
    }

    public Direction getDirection() {
        return directionControl.getDirection();
    }
}
