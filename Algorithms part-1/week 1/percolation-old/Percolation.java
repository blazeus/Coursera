import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[] grid;
    private boolean percolates = false;
    private final int temp;
    private int count = 0;
    private final WeightedQuickUnionUF uf;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n)
    {
        temp = n;
        n = (n*n) + 2;
        grid = new boolean[n];  // A grid that defines whether the site is open or not
        uf = new WeightedQuickUnionUF(n);
        for (int i = 0; i < n; i++)
        {
            grid[i] = false;
        }
    }
    
    // opens the site (row, col) if it is not open already
    public void open(int row, int col)
    {
        if ( row < 0 || col < 0 || row > temp || col > temp ) 
        {
            throw new IllegalArgumentException();
        }
        int position = ((row-1)*temp) + col;
        if (grid[position])
            return;
        else 
        {
            grid[position] = true;

            if (row == 1) // Checking for upper Row element
            {
                uf.union(position, 0);   // Joins the virtual upper parent 
                if (grid[position+temp])     // Checks if the element just below is open
                    uf.union(position, (position+temp)); // Joins the element below
            } 
            else if (row == temp) // Checking for bottom layer element
            {
                uf.union(position, (temp*temp+1)); // Joins the virtual bottom parent
                if (grid[position-temp])     // Checks if the element just above is open
                    uf.union(position, (position-temp)); // Joins the element above
            }
            else 
            {
                if (grid[position+temp])     // Checks if the element just below is open
                    uf.union(position, (position+temp)); // Joins the element below
                if (grid[position-temp])     // Checks if the element just above is open
                    uf.union(position, (position-temp)); //  Joins the element above
            }

            if (col == temp)  // Right-corner element
            {
                if (grid[position-1]) // Checks if left element is open
                    uf.union(position, position-1);  // joins the left element
                
            } 
            else if (col == 1) // Left-corner Element 
            {
                if (grid[position+1])    // Check if the right element is open
                    uf.union(position, position+1);  // Joins the right element 
            }
            else // centre element
            {
                if (grid[position-1]) // Check if left element is open
                    uf.union(position, position-1);  // joins the left element
                if (grid[position+1])    // Check if the right element is open
                    uf.union(position, position+1);  // Joins the right element
            }
            count++;
        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col)
    {
        if (row < 0 || col < 0 || row > temp || col > temp) 
        {
            throw new IllegalArgumentException();
        }
        int position = ((row-1)*temp) + col;
        if (uf.find(0) == uf.find((temp * temp)+1))
        {
            percolates = true;
        }
        return grid[position];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col)
    {
        if (row < 0 || col < 0 || row > temp || col > temp) 
        {
            throw new IllegalArgumentException();
        }
        int position = ((row-1)*temp) + col;
        return (uf.find(position) == uf.find(0));
    }

    // returns the number of open sites
    public int numberOfOpenSites()
    {
        return count;
    }

    // does the system percolate?
    public boolean percolates()
    {
        return percolates;
    }

}