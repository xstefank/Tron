package cz.muni.fi.pv260.control.collision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class PathListImpl implements Path {

    private List<Point> traveledPoints = new ArrayList<>();

    public PathListImpl() {
    }

    public PathListImpl(Point startionPosition) {
        addPointToPath(startionPosition);
    }

    @Override
    public void addPointToPath(Point point) {
        traveledPoints.add(point);
    }

    @Override
    public void removeLastPointFromPath() {
        traveledPoints.remove(0);
    }

    @Override
    public List<Point> getPoints() {
        return Collections.unmodifiableList(traveledPoints);
    }

    @Override
    public Point getHeadPosition() {
        return traveledPoints.get(getLength() - 1);
    }

    @Override
    public int getLength() {
        return traveledPoints.size();
    }

    @Override
    public List<Point> getPathTail() {
        List<Point> tail = new ArrayList<>(traveledPoints);
        tail.remove(getLength() - 1);
        return Collections.unmodifiableList(tail);
    }
}
