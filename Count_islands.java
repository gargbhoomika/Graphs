package graphs;
import java.util.Scanner;
public class Count_islands {
	public static boolean isSafe(int[][] a, int r, int c, boolean visited[][])
	{
		return ((r>=0 && r<a.length)&&(c>=0 && c<a.length) && (a[r][c]==1 && !visited[r][c]));
	}
	public static void DFS(int[][] a, int r, int c, boolean visited[][])
	{
		int row = a.length;
		int col = row;
		int[] rowcal = new int[] {-1,0,1,1,-1,0,-1,-1};
		int[] colcal = new int[] {-1,-1,-1,0,-1,1,1,0};
		visited[r][c] = true;
		for(int k=0;k<8;k++)
		{
			if(isSafe(a,r+rowcal[k],c+colcal[k],visited))
			{
				DFS(a,r+rowcal[k],c+colcal[k],visited);
			}
		}
	}
	public static int countIslands(int[][] a)
	{
		int count = 0;
		int row = a.length;
		int col = row;
		boolean[][] visited = new boolean[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(a[i][j]==1 && !visited[i][j])
				{
					DFS(a,i,j,visited);
					count++;
				}
			}
		}
		
		return count;
	}
	public static void main(String[] args) 
	{
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Number of rows or columns: ");
		n = sc.nextInt();
		int[][] a = new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				a[i][j] = sc.nextInt();
			}
		}
		int count = countIslands(a);
		System.out.println("Number of Islands are: "+count);
	}

}
