package cz.muni.fi.pv260.control.collision;

/**
 * Interface detecting collisions between two objects
 *
 * @param <T> first collision object type
 * @param <U> second collision object type
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public interface CollisionDetector<T, U> {

    /**
     * Detects the collision between 2 objects
     * @param object1 first object
     * @param object2 second object
     * @return true if objects are in collision, false otherwise
     */
    boolean detectCollision(T object1, U object2);
}
