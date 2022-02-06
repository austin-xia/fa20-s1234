import java.util.ArrayList;
import java.util.List;

/**
 * Class that collects timing information about AList construction.
 */
public class TimeAList {
    private static void printTimingTable(List<Integer> Ns, List<Double> times, List<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        List <Integer> Ns = new ArrayList<>();
        List <Double> times = new ArrayList<>();
        List <Integer> opcounts = new ArrayList<>();
        AList <Integer> demo = new AList<>();
        for (int size = 1000; size < 129000; size *= 2){
            Stopwatch seer = new Stopwatch();
            for (int i = 0; i < size; i += 1){
                demo.addLast(i);
            }
            double time_elapse = seer.elapsedTime();
            Ns.add(size);
            times.add(time_elapse);
            opcounts.add(size);
        }
        printTimingTable(Ns,times,opcounts);
    }


}
