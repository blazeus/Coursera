import edu.princeton.cs.algs4.StdRandom;
public class percolation_test{
    // test client (optional)
    public static void main(String[] args)
    {
        Percolation per = new Percolation(20);
        while(!per.percolates())
        {
            int x = StdRandom.uniform(1,21);
            int y = StdRandom.uniform(1,21);
            per.open(x,y);
        }
        System.out.println(per.count);
        System.out.println("Percolation threshold is : " + (double)per.count/400);
    }
}


//Dump

    // // Prints a map of the current grid
    // public void display()
    // {
    //     int total = (temp * temp) + 2;
    //     for (int i=0; i<total; i++)
    //     {
    //         bool = (grid[i])?1:0;
    //         if(i==0 || i==total-1)
    //         {
    //             System.out.println("\n" + bool+ " " +UF.find(i) + "\n");
    //             continue;
    //         }
    //         System.out.print(bool + " " + UF.find(i) + "\t");
    //         if(i%temp==0)
    //         {
    //             System.out.println("\n");
    //         }
    //     }

    //     //Grid Display 
    //     // for (int i=0; i<total; i++)
    //     // {
    //     //     bool = (grid[i])?1:0;
    //     //     if(i==0 || i==total-1)
    //     //     {
    //     //         System.out.println("\n" + bool + "\n");
    //     //         continue;
    //     //     }
    //     //     System.out.print(bool + "\t");
    //     //     if(i%temp==0)
    //     //     {
    //     //         System.out.println("\n");
    //     //     }
    //     // }
    // }


