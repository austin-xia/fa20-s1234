import java.util.ArrayList;
import java.util.List;

/**
 * Class that collects timing information about SLList getLast method.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        List <Integer> Ns = new ArrayList<>();
        List <Double> times = new ArrayList<>();
        List <Integer> opcounts = new ArrayList<>();
        int op_count = 10000;
        SLList <Integer> demo = new SLList<>();
        for (int size = 1000; size < 129000; size *= 2){
            /* construct the list with the correct size, not yet counting the time */
            for (int i = 0; i < size; i += 1){
                demo.addLast(i);
            }

            /* start the StopWatch counting */
            Stopwatch seer = new Stopwatch();

            /* getlasts operate for 10000 times */
            for (int i = 0; i < op_count; i += 1){
                demo.getLast();
            }

            double time_elapse = seer.elapsedTime();

            /* reset the demo list */
            demo.clear();

            Ns.add(size);
            times.add(time_elapse);
            opcounts.add(op_count);
        }
        printTimingTable(Ns,times,opcounts);
    }

}
