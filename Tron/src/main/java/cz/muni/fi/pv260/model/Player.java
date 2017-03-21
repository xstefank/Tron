package cz.muni.fi.pv260.model;

import java.util.ArrayList;
import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.control.collision.TraveledPath;
import cz.muni.fi.pv260.control.collision.TraveledPathListImpl;
import cz.muni.fi.pv260.control.controller.KeyboardController;
import cz.muni.fi.pv260.control.direction.Direction;
import cz.muni.fi.pv260.control.direction.DirectionControl2D;

/**
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public class Player {

    private Point position;
    private DirectionControl2D directionControl;
    private KeyboardController keyboardController;
    private TraveledPath path;

    public Player(Point startingPoint, DirectionControl2D directionControl, KeyboardController keyboardController) {
        position = startingPoint;
        this.directionControl = directionControl;
        this.keyboardController = keyboardController;
        path = new TraveledPathListImpl();
    }

    public Point getPosition() {
        return position;
    }

    public DirectionControl2D getDirectionControl() {
        return directionControl;
    }

    public KeyboardController getKeyboardController(){
        return keyboardController;
    }

    public TraveledPath getPath() {
        return path;
    }

    public void setPath(TraveledPath path) {
        this.path = path;
    }

    public void appendCurrentPositionToPath(){
        path.addPointToPath(new Point(position.getCoordinateX(), position.getCoordinateY()));
    }

}
