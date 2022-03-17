package bearmaps;

import java.util.List;

public class KDTree implements PointSet{

    private Point Point;
    private KDTree Left;
    private KDTree Right;


    public KDTree() {
        Point = null;
        Left = null;
        Right = null;
    }

    public KDTree(Point added) {
        Point = added;
        Left = null;
        Right = null;
    }

    public KDTree(List<Point> input) {
        for (Point i : input){
            this.add(i);
        }
    }

    public void add(Point added){
        KDTree add = new KDTree (added);
        if (this.Point == null){
            this.Point = added;
        } else if (CompareX(this.Point, added)){
            if (this.Right == null){
                this.Right = add;
            } else if (CompareY(this.Right.Point, added)){
                if (this.Right.Right == null){
                    this.Right.Right = add;
                } else {
                    this.Right.Right.add(added);
                }
            } else {
                if (this.Right.Left == null){
                    this.Right.Left = add;
                } else {
                    this.Right.Left.add(added);
                }
            }
        } else {
            if (this.Left == null){
                this.Left = add;
            } else if (CompareY(this.Left.Point, added)){
                if (this.Left.Right == null){
                    this.Left.Right = add;
                } else {
                    this.Left.Right.add(added);
                }
            } else {
                if (this.Left.Left == null){
                    this.Left.Left = add;
                } else {
                    this.Left.Left.add(added);
                }
            }
        }
    }

    private boolean CompareX(Point base, Point added){
        return added.getX() >= base.getX();
    }

    private boolean CompareY(Point base, Point added){
        return added.getY() >= base.getY();
    }

    @Override
    public Point nearest(double x, double y){
        Point best;
        Point target = new Point (x,y);
        CompareX OP = new CompareX();
        best = Find_nearest(target, this, null, Double.POSITIVE_INFINITY, OP);
        return best;
    }

    public Point Find_nearest (Point target, KDTree N, Point best, double b_distance, CompareOP OP){
        double dis = Point.distance(target, N.Point);
        KDTree goodside;
        KDTree badside;
        if (dis < b_distance){
            best = N.Point;
            b_distance = dis;
        }
        if (OP.Compare(N.Point, target)){
            goodside = N.Right;
            badside = N.Left;
        } else {
            goodside = N.Left;
            badside = N.Right;
        }
        if (goodside != null){
            best = Find_nearest(target, goodside, best, b_distance, OP.Next());
            b_distance = Point.distance(target, best);
        }
        if (badside != null && OP.Delta(N.Point, target) < b_distance){
            best = Find_nearest(target, badside, best, b_distance, OP.Next());
            b_distance = Point.distance(target, best);
        }
        return best;
    }




}
