package cz.muni.fi.pv260.collision;

import cz.muni.fi.pv260.control.collision.CollisionDetector;
import cz.muni.fi.pv260.control.collision.PathCollisionDetector;
import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.control.collision.TraveledPath;

import java.util.List;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class TronCollisionDetector implements CollisionDetector<TraveledPath> {

    @Override
    public boolean detectCollision(TraveledPath pathPlayer1, TraveledPath pathPlayer2) {

        List<Point> path1 = pathPlayer1.getPathTail();
        List<Point> path2 = pathPlayer2.getPathTail();

        Point headPosition1 = pathPlayer1.getHeadPosition();
        Point headPosition2 = pathPlayer2.getHeadPosition();

        for (int i = 0; i < path1.size(); i++) {
            if (headPosition1.equals(path1.get(i)) ||
                    headPosition1.equals(path2.get(i)) ||
                    headPosition2.equals(path1.get(i)) ||
                    headPosition2.equals(path2.get(i))) {
                return true;
            }
        }

        return false;
    }
}
