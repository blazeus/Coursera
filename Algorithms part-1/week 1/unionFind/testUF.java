import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdIn;

/*
This creates a N by N grid and then the union methods define connection between the elements   
*/
public class testUF {
    public static void main(String[] args) {
        int n,temp,x,y;
        boolean condition = true;
        String quit = " ";
        n = StdIn.readInt();
        temp = n;
        n *=n;
        WeightedQuickUnionUF UF = new WeightedQuickUnionUF(n);
        while(condition)
        {
            System.out.print("Please enter two elements to connect: ");
            x = StdIn.readInt();
            y = StdIn.readInt();
            UF.union(x,y);
            for(int i=0; i<temp; i++){
                for(int j=0; j<temp; j++){
                    if(j<(temp-1) && (UF.find((temp*i)+j))==UF.find((temp*i)+(j+1)))
                        System.out.print("\t" + UF.find((temp*i)+j) +"  ---");
                    else
                        System.out.print("\t" + UF.find((temp*i)+j) + " ");
                }
                System.out.print("\n");
                for(int j=0; j<temp; j++){
                    if(i<(temp-1) && (UF.find((temp*i)+j))==(UF.find((temp*(i+1))+j)))
                        System.out.print("\t|");
                    else
                        System.out.print("\t");
                }
                System.out.println();
            }
            System.out.println("Enter 'quit' to exit!");
            quit = StdIn.readLine(); //flushing the input stream once
            quit = StdIn.readLine();
            condition = quit.equals("quit")?false:true;
        }
    }
}