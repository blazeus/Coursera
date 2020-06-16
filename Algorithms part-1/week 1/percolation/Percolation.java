import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final boolean[][] grid;
    private final WeightedQuickUnionUF ufGrid;
    private final WeightedQuickUnionUF ufFull;
    private final int gridSize;
    private final int virtualTop;
    private final int virtualBottom;
    private int openSites;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        final int gridSizeFlattened;
        gridSize = n;
        gridSizeFlattened = n * n;
        grid = new boolean[gridSize][gridSize];
        ufGrid = new WeightedQuickUnionUF(gridSizeFlattened + 2); // icluding virtual top and bottom
        ufFull = new WeightedQuickUnionUF(gridSizeFlattened + 1); // including virtual top
        virtualBottom = gridSizeFlattened + 1;
        virtualTop = gridSizeFlattened;
        openSites = 0;
    }

    // Helper functions
    private int flattenGrid(int row, int col) {
        return gridSize * (row - 1) + col;
    }

    private void validateSite(int row, int col) {
        if (!isOnGrid(row, col)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOnGrid(int row, int col) {
        int shiftRow = row - 1;
        int shiftCol = col - 1;
        return (shiftRow >= 0 && shiftCol >= 0 && shiftRow < gridSize && shiftCol < gridSize);
    }


    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validateSite(row, col);

        int shiftRow = row - 1;
        int shiftCol = col - 1;
        int flatIndex = flattenGrid(row, col) - 1;

        // Checking if already open
        if (isOpen(row, col)) {
            return;
        }

        // Opening the site

        grid[shiftRow][shiftCol] = true;
        openSites++;

        if (row == 1) {  // Top Row
            ufGrid.union(virtualTop, flatIndex);
            ufFull.union(virtualTop, flatIndex);
        }

        if (row == gridSize) {  // Bottom Row
            ufGrid.union(virtualBottom, flatIndex);
        }

        // Check and Open Left
        if (isOnGrid(row, col - 1) && isOpen(row, col - 1)) {
            ufGrid.union(flatIndex, flattenGrid(row, col - 1) - 1);
            ufFull.union(flatIndex, flattenGrid(row, col - 1) - 1);
        }

        // Check and Open Right
        if (isOnGrid(row, col + 1) && isOpen(row, col + 1)) {
            ufGrid.union(flatIndex, flattenGrid(row, col + 1) - 1);
            ufFull.union(flatIndex, flattenGrid(row, col + 1) - 1);
        }

        // Check and Open Up
        if (isOnGrid(row - 1, col) && isOpen(row - 1, col)) {
            ufGrid.union(flatIndex, flattenGrid(row - 1, col) - 1);
            ufFull.union(flatIndex, flattenGrid(row - 1, col) - 1);
        }

        // Check and Open Down
        if (isOnGrid(row + 1, col) && isOpen(row + 1, col)) {
            ufGrid.union(flatIndex, flattenGrid(row + 1, col) - 1);
            ufFull.union(flatIndex, flattenGrid(row + 1, col) - 1);
        }
 
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateSite(row, col);
        return grid[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validateSite(row, col);
        return (ufFull.find(virtualTop) == ufFull.find(flattenGrid(row, col) - 1));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return ufGrid.find(virtualTop) == ufGrid.find(virtualBottom);
    }

}