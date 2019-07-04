package graphs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Transitive_closure_graph {
	
	ArrayList<Integer> arr[];
	int v;
	int[][] tcg;
	Transitive_closure_graph(int v)
	{
		this.v = v;
		arr = new ArrayList[v];
		tcg = new int[v][v];
		for(int i=0;i<v;i++)
		{
			arr[i] = new ArrayList<Integer>();
		}
	}
	public void addEdge(int u, int v)
	{
		arr[u].add(v);
	}
	public void closure(int u, int v)
	{
		System.out.println(u+","+v+"= 1");
		tcg[u][v]=1;
		for(int k : arr[v])
		{
			if(tcg[u][k]==0)
			{
				closure(u,k);
			}
		}
	}
	public void find_closure()
	{
		for(int i=0;i<v;i++)
		{				
			closure(i,i);
		}
		for(int i=0;i<v;i++)
		{
			System.out.print(i+" : ");
			for(int j: arr[i])
			{
				System.out.print(j+" ");
			}
			System.out.println();
		}
		for(int i=0;i<v;i++)
		{
			System.out.println(Arrays.toString(tcg[i]));
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Transitive_closure_graph g = new Transitive_closure_graph(4);
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
		g.find_closure();
	}

}
