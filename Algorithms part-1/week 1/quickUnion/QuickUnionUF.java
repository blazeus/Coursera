public class QuickUnionUF 
{
    private int[] id;
    private int[] sz; 

    public QuickUnionUF(int N)
    {
        id = new int[N];
        for (int i=0; i < N; i++) id[i] = i;
    }

    // chase parent pointers until reach root
    private int root(int i)
    {
        while (i != id[i]) 
        {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    //check fi p and q have same root 
    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }

    //change root of p to point to the root of q
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (sz[i] < sz[j]) 
        {
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
        id[i] = j;
    }
}