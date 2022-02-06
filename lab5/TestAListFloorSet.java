import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestAListFloorSet {
    public AListFloorSet items = new AListFloorSet();

    @Test
    public void Test_AlistFloorSet (){
        for (double i = 0; i < 20; i += 1){
            items.add(i);
        }
        items.add(10);
        items.add(12);
        assertEquals(15, items.floor(15.5), 0.000001);
    }


}
