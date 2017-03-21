package cz.muni.fi.pv260.control.collision;

import java.util.List;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class PathCollisionDetector implements CollisionDetector<TraveledPath> {

    @Override
    public boolean detectCollision(TraveledPath path1, TraveledPath path2) {

        List<Point> pathPonts1 = path1.getPoints();
        List<Point> pathPonts2 = path2.getPoints();

        for (Point point1 : pathPonts1) {
            for (Point point2 : pathPonts2) {
                if (point1.equals(point2)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean detectCollistionWithPoint(TraveledPath path, Point point) {
        for (Point pathPoint : path.getPoints()) {
            if (pathPoint.equals(point)) {
                return true;
            }
        }

        return false;
    }
}
