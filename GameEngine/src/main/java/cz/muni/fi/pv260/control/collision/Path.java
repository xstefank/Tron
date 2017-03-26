package cz.muni.fi.pv260.control.collision;

import java.util.List;

/**
 * Interface for the accessing, adding and removing point to paths.
 * Represents a continuous line of points.
 *
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public interface Path {

    /**
     * Adds a {@link Point} to the path. Boundaries
     * are not checked.
     * @param point to add
     */
    void addPointToPath(Point point);

    /**
     * Removes the last point from the path. It can be used
     * when the path as a whole is moving.
     */
    void removeLastPointFromPath();

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

    /**
     * Returns path points without first element
     * @return the path without first element
     */
    List<Point> getPathTail();
}
