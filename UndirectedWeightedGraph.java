import java.util.List;

public interface UndirectedWeightedGraph {

	public boolean isConnected();
	
	public int[] reachable(int vertex);
	
	public int[][] getMinimumSpanningTree();
	
	public int shortestPath(int source, int destination);
}