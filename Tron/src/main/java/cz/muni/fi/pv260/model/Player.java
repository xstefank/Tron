package cz.muni.fi.pv260.model;

import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.control.collision.TraveledPath;
import cz.muni.fi.pv260.control.collision.TraveledPathListImpl;
import cz.muni.fi.pv260.control.controller.KeyboardController;
import cz.muni.fi.pv260.control.direction.DirectionControl2D;
import java.awt.*;

/**
 * Class representing a player in the game.
 *
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public class Player {

    private DirectionControl2D directionControl;
    private KeyboardController keyboardController;
    private TraveledPath path;
    private Color color;

    public Player(Point startingPoint, DirectionControl2D directionControl, KeyboardController keyboardController, Color color) {
        this.directionControl = directionControl;
        this.keyboardController = keyboardController;
        this.path = new TraveledPathListImpl(startingPoint);
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    public Point getPosition() {
        return this.path.getHeadPosition();
    }

    public DirectionControl2D getDirectionControl() {
        return this.directionControl;
    }

    public KeyboardController getKeyboardController() {
        return this.keyboardController;
    }

    public TraveledPath getPath() {
        return this.path;
    }

}
