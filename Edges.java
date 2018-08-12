
public class Edges {

	private int startVertex;
	private int endVertex;
	private int edgeWeight;
	
	Edges(int vertex1, int vertex2, int edgeWeight){
		this.startVertex = vertex1;
		this.endVertex = vertex2;
		this.edgeWeight = edgeWeight;
	}
	
	/**
	 * 
	 * @returns the start vertex of edge
	 */
	public int getStartVertex() {
		return this.startVertex;
	}
	
	/**
	 * 
	 * @returns the end vertex of edge
	 */
	public int getEndVertex() {
		return this.endVertex;
	}
	
	/**
	 * 
	 * @returns the Weight of edge
	 */
	public int getEdgeWeight() {
		return this.edgeWeight;
	}
}