import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation1 {
    private final boolean[] grid;
    private final int temp;
    private int count = 0;
    private final WeightedQuickUnionUF uf;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation1(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        temp = n;
        n = (n * n) + 2;
        grid = new boolean[n]; // A grid that defines whether the site is open or not
        uf = new WeightedQuickUnionUF(n);
    }

    // helper function for validation
    private static boolean validate(final int n, final int t) {
        return (n <= 0 || t <= 0);
    }

    // opens the site (row, col) if it is not open already
    public void open(final int row, final int col) {
        if (validate(row, col) || row > temp || col > temp) {
            throw new IllegalArgumentException();
        }
        final int position = ((row - 1) * temp) + col;
        if (grid[position])
            return;
        else {
            grid[position] = true;
            if (row == 1 && temp == 1) {
                uf.union(position, 0);
                uf.union(position, 2);
                count++;
                return;
            }
            if (row == 1) // Checking for upper Row element
            {
                uf.union(position, 0); // Joins the virtual upper parent
                if (grid[position + temp]) // Checks if the element just below is open
                    uf.union(position, (position + temp)); // Joins the element below
            } else if (row == temp) // Checking for bottom layer element
            {
                uf.union(position, (temp * temp + 1)); // Joins the virtual bottom parent
                if (grid[position - temp]) // Checks if the element just above is open
                    uf.union(position, (position - temp)); // Joins the element above
            } else {
                if (grid[position + temp]) // Checks if the element just below is open
                    uf.union(position, (position + temp)); // Joins the element below
                if (grid[position - temp]) // Checks if the element just above is open
                    uf.union(position, (position - temp)); // Joins the element above
            }

            if (col == temp) // Right-corner element
            {
                if (grid[position - 1]) // Checks if left element is open
                    uf.union(position, position - 1); // joins the left element

            } else if (col == 1) // Left-corner Element
            {
                if (grid[position + 1]) // Check if the right element is open
                    uf.union(position, position + 1); // Joins the right element
            } else // centre element
            {
                if (grid[position - 1]) // Check if left element is open
                    uf.union(position, position - 1); // joins the left element
                if (grid[position + 1]) // Check if the right element is open
                    uf.union(position, position + 1); // Joins the right element
            }
            count++;
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(final int row, final int col) {
        if (validate(row, col) || row > temp || col > temp) {
            throw new IllegalArgumentException();
        }
        final int position = ((row - 1) * temp) + col;
        return (grid[position]);
    }

    // is the site (row, col) full?
    public boolean isFull(final int row, final int col) {
        if (validate(row, col) || row > temp || col > temp) {
            throw new IllegalArgumentException();
        }
        final int position = ((row - 1) * temp) + col;
        final int posRoot = uf.find(position);
        for (int i = 1; i <= temp; i++)
        {
            if (isOpen(row, col) && posRoot == uf.find(i))
                return true;
        }
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites()
    {
        return count;
    }

    // does the system percolate?
    public boolean percolates()
    {   
        if (uf.find(0) == uf.find((temp * temp)+1))
        {
            grid[0] = true;
        }
        return grid[0];
    }
}