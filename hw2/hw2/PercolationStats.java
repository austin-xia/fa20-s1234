package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private double[] root;
    private Percolation A;
    private StdRandom random;
    private StdStats Stats;
    private double mean;
    private double sd;
    private int length;
    private int try_time;

    /* perform T independent experiments on an N-by-N grid **/
    public PercolationStats(int N, int T, PercolationFactory pf){
        if (N <= 0 || T <= 0){
            throw new IllegalArgumentException("input must be a positive number");
        }
        root = new double [T];
        A = pf.make(N);
        length = N;
        try_time = T;
        for (int i = 0; i < T; i += 1){
            int x = 0;
            while (! A.percolates()){
                A.open(random.uniform(N), random.uniform(N));
                x += 1;
            }
            root[i] = x/(N*N);
        }
    }

    /* sample mean of percolation threshold **/
    public double mean(){
        mean = Stats.mean(root);
        return mean;
    }

    /* sample standard deviation of percolation threshold **/
    public double stddev(){
        sd = Stats.stddev(root);
        return sd;
    }

    /* low endpoint of 95% confidence interval **/
    public double confidenceLow(){
        return mean - 1.96 * sd / Math.sqrt(try_time);
    }

    /* high endpoint of 95% confidence interval **/
    public double confidenceHigh() {
        return mean + 1.96 * sd / Math.sqrt(try_time);
    }


}
