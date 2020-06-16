import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
public class PercolationStats {
    private static double[] threshold;
    private static int t, n;
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials)
    {
        int counter = 0;
        while (trials-- > 0)
        {
            Percolation per = new Percolation(n);
            while (!per.percolates())
            {
                int col = StdRandom.uniform(1, n);
                int row = StdRandom.uniform(1, n);
                per.open(row, col);
            }
            threshold[counter++] = (double) per.numberOfOpenSites()/(double) (n*n);
        }
    }

    // sample mean of percolation threshold
    public double mean()
    {
        return StdStats.mean(threshold);
    }

    // sample standard deviation of percolation threshold
    public double stddev()
    {
        return StdStats.stddev(threshold);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo()
    {
        double result = StdStats.mean(threshold) - ((1.96*(StdStats.stddev(threshold))/t));
        return result;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi()
    {
        double result = StdStats.mean(threshold) + ((1.96*(StdStats.stddev(threshold))/t));
        return result;
    }

   // test client (see below)
   public static void main(String[] args)
   {
        t = Integer.parseInt(args[0].trim());
        n = Integer.parseInt(args[1].trim());
        if ( t < 0 || n < 0)
        {
            throw new IllegalArgumentException();
        }
        threshold = new double[t];
        int counter = 0, tCounter = t;
        while (tCounter > 0)
        {
            Percolation per = new Percolation(n);
            while (!per.percolates())
            {
                int col = StdRandom.uniform(1, n+1);
                int row = StdRandom.uniform(1, n+1);
                per.open(row, col);
            }
            threshold[counter++] = (double) per.numberOfOpenSites()/(double) (n*n);
            tCounter--;
        }
        double mean = (StdStats.mean(threshold));
        double stddev = StdStats.stddev(threshold);
        double[] confidenceInterval = {
            StdStats.mean(threshold) - ((1.96*(StdStats.stddev(threshold))/(double) t)),
            StdStats.mean(threshold) + ((1.96*(StdStats.stddev(threshold))/(double) t))};
        System.out.printf("%-30s %-30s \n", "mean", mean);
        System.out.printf("%-30s %-30s \n", "stddev", stddev);
        System.out.printf("%-30s [%s,%s] \n", "95% confidence interval", confidenceInterval[0], confidenceInterval[1]);
   }
}