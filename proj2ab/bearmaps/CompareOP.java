package bearmaps;

public interface CompareOP {

    CompareOP Next ();
    boolean Compare (Point base, Point added);
    double Delta (Point base, Point target);
}
