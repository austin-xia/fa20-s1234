package bearmaps;

import java.util.ArrayList;
import java.util.List;

public class NaivePointSet implements PointSet{

    public ArrayList<Point> root;

    public NaivePointSet(){
        root = new ArrayList<Point>();
    }

    public NaivePointSet(List input){
        root = new ArrayList<Point>();
        for (Object i : input){
            root.add((Point)i);
        }
    }

    public void add(Point added){
        root.add(added);
    }

    @Override
    public Point nearest(double x, double y){
        Point base = new Point(x, y);
        Point nearest = null;
        double nearest_distance = Double.POSITIVE_INFINITY;
        for (Object helper: root){
            double helper_distance = Point.distance((Point) helper, base);
            if (helper_distance < nearest_distance){
                nearest_distance = helper_distance;
                nearest = (Point) helper;
            }
        }
        return nearest;
    }

}
