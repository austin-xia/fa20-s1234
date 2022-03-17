package bearmaps;

public class CompareX implements CompareOP{

    @Override
    public boolean Compare(Point base, Point added){
        return added.getX() >= base.getX();
    }

    @Override
    public double Delta (Point base, Point target){
        return Math.pow(target.getX() - base.getX(), 2);
    }

    @Override
    public CompareOP Next(){
        CompareY next = new CompareY();
        return next;
    }
}
