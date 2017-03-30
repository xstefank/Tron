package cz.muni.fi.pv260.control.collision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class PathListImpl implements Path {

    private LinkedList<Point> traveledPoints = new LinkedList<>();

    public PathListImpl() {
    }

    public PathListImpl(Point startingPosition) {
        addPointToPath(startingPosition);
    }

    public PathListImpl(List<Point> list){
        list.forEach(point -> traveledPoints.add(point));
    }

    @Override
    public void addPointToPath(Point point) {
        traveledPoints.addFirst(point);
    }

    @Override
    public void removeLastPointFromPath() {
        traveledPoints.removeLast();
    }

    @Override
    public List<Point> getPoints() {
        return Collections.unmodifiableList(traveledPoints);
    }

    @Override
    public Point getHeadPosition() {
        return traveledPoints.getFirst();
    }

    @Override
    public Path getTailPath() {
        List<Point> tail = new ArrayList<>(traveledPoints);
        tail.remove(getHeadPosition());
        return new PathListImpl(tail);
    }
}
