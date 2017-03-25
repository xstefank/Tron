package cz.muni.fi.pv260.controller.listener;

import cz.muni.fi.pv260.control.controller.InputController;
import cz.muni.fi.pv260.control.controller.mouse.MouseControllerImpl;
import cz.muni.fi.pv260.model.GameData;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public class MouseInputListener implements MouseListener {

    private GameData gameData;

    public MouseInputListener(GameData gameData) {
        this.gameData = gameData;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        gameData.getMouseControllers().forEach(playerController -> playerController.processInputEvent(event));
    }

    @Override
    public void mousePressed(MouseEvent event) {

    }

    @Override
    public void mouseReleased(MouseEvent event) {

    }

    @Override
    public void mouseEntered(MouseEvent event) {

    }

    @Override
    public void mouseExited(MouseEvent event) {

    }
}
