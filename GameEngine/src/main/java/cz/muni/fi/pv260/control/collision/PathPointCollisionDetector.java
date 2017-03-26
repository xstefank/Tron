package cz.muni.fi.pv260.control.collision;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class PathPointCollisionDetector implements CollisionDetector<Path, Point> {

    @Override
    public boolean detectCollision(Path path, Point point) {
        for (Point pathPoint : path.getPoints()) {
            if (pathPoint.equals(point)) {
                return true;
            }
        }

        return false;
    }
}
