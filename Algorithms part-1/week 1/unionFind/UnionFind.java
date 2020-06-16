import java.util.Scanner;
class UnionFind{
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        UF uf = new UF(N);
        while(!in.nextLine().isEmpty())
        {
            int p = in.nextInt();
            int q = in.nextInt();
            if(!uf.connected(p,q))
            {
                uf.union(p,q);
                System.out.println(p+ " " + q);
            }
        }
        in.close();
    }

    public static class UF{
        UF(int N)
        {
            id = new int[N];
            //Set id of each object to itself
            for (int i=0; i<N; i++)
                id[i] = i;
        };

        private int[] id;

        // Check whether p and q are in the same component (2 array accesses)
        public boolean connected(int p, int q)
        {
            return id[p] == id[q];
        }

        //change all entries with id[p] to id[q] (at most 2N + 2 array accesses)
        public void union(int p, int q)
        {
            int pid = id[p];
            int qid = id[q];
            for ( int i =0; i<id.length; i++)
            {
                if (id[i] == pid) id[i] = qid;
            }
        }
    }
    
}