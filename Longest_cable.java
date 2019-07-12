package graphs;

public class Longest_cable {
	int v;
	int arr[][];
	Longest_cable(int v)
	{
		this.v = v;
		arr = new int[v][v];
	}
	public void DFS(int v, boolean visited[],int len)
	{
		visited[v] = true;
		int [] temp = arr[v];
		for(int i=0;i<temp.length;i++)
		{
			if(!visited[i])
			{
				len += arr[v][i];
				DFS(i,visited,len);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
