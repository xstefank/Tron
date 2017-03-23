package cz.muni.fi.pv260.controller.listener;

import cz.muni.fi.pv260.control.controller.InputController;
import cz.muni.fi.pv260.control.controller.mouse.MouseController;
import cz.muni.fi.pv260.controller.GameController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public class MouseInputListener implements MouseListener {

    private GameController gameController;

    public MouseInputListener(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        gameController.getPlayers().forEach(player -> {
            InputController inputController = player.getInputController();
            // TODO: potential violation of some SOLID rules
            if (inputController instanceof MouseController) {
                inputController.processEvent(event);
            }
        });
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
