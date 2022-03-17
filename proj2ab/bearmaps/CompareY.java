package bearmaps;

public class CompareY implements CompareOP{

    @Override
    public boolean Compare(Point base, Point added){
        return added.getY() >= base.getY();
    }

    @Override
    public double Delta (Point base, Point target){
        return Math.pow(target.getY() - base.getY(), 2);
    }

    @Override
    public CompareOP Next(){
        CompareX next = new CompareX();
        return next;
    }
}
