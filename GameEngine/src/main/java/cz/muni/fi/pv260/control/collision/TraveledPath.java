package cz.muni.fi.pv260.control.collision;

import java.util.List;

/**
 * Interface for the accessing and adding point to paths.
 * Can be used in snake like games when collisions with
 * the traveled path needs to be detected
 *
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public interface TraveledPath {

    /**
     * Adds a {@link Point} to the path. Boundaries
     * are not checked.
     * @param point to add
     */
    void addPointToPath(Point point);

    /**
     * Returns individual points in the path
     * @return {@link List} representation of the path
     */
    List<Point> getPoints();

    /**
     * Returns the last {@link Point} that had been added
     * to the path
     * @return {@link} last added point
     */
    Point getHeadPosition();

    /**
     * Return the path length in points
     * @return the number of points
     */
    int getLength();
}
