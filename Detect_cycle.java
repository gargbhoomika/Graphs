package graphs;

import java.util.ArrayList;
import java.util.Iterator;

public class Detect_cycle 
{
	int v;
	ArrayList<Integer> arr[] ;
	Detect_cycle(int v)
	{
		this.v = v;
		arr = new ArrayList[v];
		for(int i=0;i<v;i++)
		{
			arr[i] = new ArrayList();
		}
	}
	public void addEdge(int u, int w)
	{
		arr[u].add(w);
		arr[w].add(u);
	}
	public boolean DFS(int v, boolean[] visited, int parent)
	{
		visited[v] = true;
		Integer i;
		Iterator<Integer> it = arr[v].iterator();
		
		while(it.hasNext())
		{
			i = it.next();
			if(!visited[i])
			{
				if(DFS(i,visited,v))
				{
					return true;
				}
			}
			else if(i!=parent)
			{
				return true;
			}
		}
		return false;
	}
	public boolean cycle()
	{
		boolean[] visited = new boolean[v];
		for(int i=0;i<v;i++)
		{
			if(!visited[i])
			{
				if(DFS(i,visited,-1))
				{
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String args[])
	{
		Detect_cycle g1 = new Detect_cycle(5); 
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 0); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
        if (g1.cycle()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't contains cycle"); 
	}
}
