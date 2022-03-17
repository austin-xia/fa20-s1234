package bearmaps;

import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;
import java.util.List;

public class Timetest {

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
        KDTree PS_K = new KDTree();
        NaivePointSet PS_N = new NaivePointSet();
        timeConstruction(PS_K);
        timeConstruction(PS_N);
        timeNearest(PS_K);
        timeNearest(PS_N);

    }

    public static void timeConstruction(PointSet test) {
        List <Integer> Ns = new ArrayList<>();
        List <Double> times = new ArrayList<>();
        List <Integer> opcounts = new ArrayList<>();
        int length = 100;

        for (int size = 1000; size <= 1000000; size *= 10){
            Stopwatch seer = new Stopwatch();
            for (int i = 0; i < size; i += 1){
                double x = Math.random() * length;
                double y = Math.random() * length;
                Point add = new Point(x, y);
                test.add(add);
            }
            double time_elapse = seer.elapsedTime();
            Ns.add(size);
            times.add(time_elapse);
            opcounts.add(size);
        }
        printTimingTable(Ns,times,opcounts);
    }

    public static void timeNearest(PointSet test) {
        List <Integer> Ns = new ArrayList<>();
        List <Double> times = new ArrayList<>();
        List <Integer> opcounts = new ArrayList<>();
        int length = 100;

        for (int size = 1000; size <= 1000; size *= 10){
            Stopwatch seer = new Stopwatch();
            for (int i = 0; i < size; i += 1){
                double x = Math.random() * length;
                double y = Math.random() * length;
                test.nearest(x,y);
            }
            double time_elapse = seer.elapsedTime();
            Ns.add(size);
            times.add(time_elapse);
            opcounts.add(size);
        }
        printTimingTable(Ns,times,opcounts);
    }

}
