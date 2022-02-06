/**
 * TODO: Fill in the add and floor methods.
 */
public class AListFloorSet implements Lab5FloorSet {
    AList<Double> items;

    public AListFloorSet() {
        items = new AList<>();
    }

    @Override
    public void add(double x) {
        for (int i = 0; i < items.size(); i += 1){
            if (x == items.get(i)){
                return;
            }
        }
        items.addLast(x);
    }

    @Override
    public double floor(double x) {
        double returned = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < items.size(); i += 1){
            if (items.get(i) <= x && items.get(i) > returned){
                returned = items.get(i);
            }
        }
        return returned;
    }
}
