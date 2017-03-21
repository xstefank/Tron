package cz.muni.fi.pv260.control.collision;

/**
 * Interface detecting collisions between two objects
 *
 * @param <T> collision object type
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public interface CollisionDetector<T> {

    /**
     * Detects the collision between 2 objects
     * @param object1 first object
     * @param object2 second object
     * @return true if objects are in collision, false otherwise
     */
    boolean detectCollision(T object1, T object2);
}
