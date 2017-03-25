package cz.muni.fi.pv260.control.controller.awt;

import cz.muni.fi.pv260.control.controller.InputController;
import cz.muni.fi.pv260.control.controller.awt.keyboard.KeyboardControllerBuilder;
import cz.muni.fi.pv260.control.controller.awt.mouse.MouseControllerBuilder;
import cz.muni.fi.pv260.control.direction.DirectionControl2D;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class AWTControllerFactory {

    public static InputController<KeyEvent> newArrows2DController(DirectionControl2D directionControl) {
        return new KeyboardControllerBuilder()
                .addEvent(KeyEvent.VK_UP, (e -> directionControl.directUp()))
                .addEvent(KeyEvent.VK_DOWN, (e -> directionControl.directDown()))
                .addEvent(KeyEvent.VK_LEFT, (e -> directionControl.directLeft()))
                .addEvent(KeyEvent.VK_RIGHT, (e -> directionControl.directRight()))
                .build();
    }


    public static InputController<KeyEvent> newWSAD2DController(DirectionControl2D directionControl) {
        return new KeyboardControllerBuilder()
                .addEvent(KeyEvent.VK_W, (e -> directionControl.directUp()))
                .addEvent(KeyEvent.VK_S, (e -> directionControl.directDown()))
                .addEvent(KeyEvent.VK_A, (e -> directionControl.directLeft()))
                .addEvent(KeyEvent.VK_D, (e -> directionControl.directRight()))
                .build();
    }

    public static InputController<MouseEvent> newMouseButtonController(DirectionControl2D directionControl) {
        return new MouseControllerBuilder()
                .addEvent(MouseEvent.BUTTON1, (e -> directionControl.directTurnLeft()))
                .addEvent(MouseEvent.BUTTON3, (e -> directionControl.directTurnRight()))
                .build();
    }
}
