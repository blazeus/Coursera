import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
public class PercolationStats {
    private static final double DIV = 1.96;
    private final double[] threshold;
    private final int t;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (trials <= 0 || n <= 0) throw new IllegalArgumentException(); 
        t = trials;
        threshold = new double[trials];
        Percolation per;
        int counter = 0;
        for (int i = 0; i < trials; i++) {
            per = new Percolation(n);
            while (!per.percolates()) {
                int col = StdRandom.uniform(1, (n + 1));
                int row = StdRandom.uniform(1, (n + 1));
                per.open(row, col);
            }
            threshold[counter++] = (double) per.numberOfOpenSites() / (double) (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(threshold);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(threshold);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        double result = StdStats.mean(threshold) - ((DIV * (StdStats.stddev(threshold)) / t));
        return result;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        double result = StdStats.mean(threshold) + ((DIV * (StdStats.stddev(threshold)) / t));
        return result;
    }

    // test client (see below)
    public static void main(String[] args) {
        int t, n;
        n = Integer.parseInt(args[0].trim());
        t = Integer.parseInt(args[1].trim());
        if (t < 0 || n < 0) {
            throw new IllegalArgumentException();
        }
        double[] threshold;
        threshold = new double[t];
        Percolation per;
        int counter = 0;
        for (int i = 0; i < t; i++) {
            per = new Percolation(n);
            while (!per.percolates()) {
                int col = StdRandom.uniform(1, (n + 1));
                int row = StdRandom.uniform(1, (n + 1));
                per.open(row, col);
            }
            threshold[counter++] = (double) per.numberOfOpenSites() / (double) (n * n);
        }
        double mean = StdStats.mean(threshold);
        double stddev = StdStats.stddev(threshold);
        double[] confidenceInterval = {
            StdStats.mean(threshold) - ((DIV*(StdStats.stddev(threshold))/(double) t)),
            StdStats.mean(threshold) + ((DIV*(StdStats.stddev(threshold))/(double) t))};
        StdOut.printf("%-30s %-30s \n", "mean", mean);
        StdOut.printf("%-30s %-30s \n", "stddev", stddev);
        StdOut.printf("%-30s [%s,%s] \n", "95% confidence interval", confidenceInterval[0], confidenceInterval[1]);
    }
}