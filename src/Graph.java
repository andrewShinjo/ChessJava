package finalProject;

/**
 * Graph.java
 * @author Thinh Nguyen
 * @author Khoi Nguyen
 * CIS 22C, Lab 8
 */

import java.util.Vector;

public class Graph {
	private int vertices;
	private int edges;
	private Vector<List<Integer>> adj;
	private Vector<Character> color;
	private Vector<Integer> distance;
	private Vector<Integer> parent;
	
	private Vector<List<Integer>> rank;

	/** Constructors */

	/**
	 * initializes an empty graph, with n vertices and 0 edges
	 * 
	 * @param n
	 *            the number of vertices in the graph
	 */
	public Graph(int n) {
		this.vertices = n;
		this.edges = 0;
		rank = new Vector<List<Integer>>(n);
		adj = new Vector<List<Integer>>(n);
		color = new Vector<Character>(n);
		distance = new Vector<Integer>(n);
		parent = new Vector<Integer>(n);
		for (int i = 0; i < this.vertices; i++) {
			adj.add(new List<Integer>());
			rank.add(new List<Integer>());
			color.add('W');
			distance.add(-1);
			parent.add(0);
		}
	}

	/*** Accessors ***/

	/**
	 * Returns the number of edges in the graph
	 * 
	 * @return the number of edges
	 */
	public int getNumEdges() {
		return this.edges;
	}

	/**
	 * Returns the number of vertices in the graph
	 * 
	 * @return the number of vertices
	 */
	public int getNumVertices() {
		return this.vertices;
	}

	/**
	 * returns whether the graph is empty (no vertices)
	 * 
	 * @return whether the graph is empty
	 */
	public boolean isEmpty() {
		return adj.size() == 0;
	}

	/**
	 * Returns the value of the distance[v]
	 * 
	 * @param v
	 *            a vertex in the graph
	 * @precondition 0 < v <= vertices
	 * @return the distance of vertex v
	 * @throws IndexOutOfBoundsException
	 *             when the precondition is violated
	 */
	public Integer getDistance(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > this.vertices)
			throw new IndexOutOfBoundsException("getDistance() fails. The index is out of bound.");
		return this.distance.get(v - 1);
	}

	/**
	 * Returns the value of the parent[v]
	 * 
	 * @param v
	 *            a vertex in the graph
	 * @precondition v <= vertices
	 * @return the parent of vertex v
	 * @throws IndexOutOfBoundsException
	 *             when the precondition is violated
	 */
	public Integer getParent(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > this.vertices)
			throw new IndexOutOfBoundsException("getParent() fails. The index is out of bound.");
		return this.parent.get(v - 1);
	}

	/**
	 * Returns the value of the color[v]
	 * 
	 * @param v
	 *            a vertex in the graph
	 * @precondition 0< v <= vertices
	 * @return the color of vertex v
	 * @throws IndexOutOfBoundsException
	 *             when the precondition is violated
	 */
	public Character getColor(Integer v) throws IndexOutOfBoundsException {
		if (v <= 0 || v > this.vertices)
			throw new IndexOutOfBoundsException("getColor() fails. The index is out of bound.");
		return this.color.get(v - 1);
	}

	/*** Manipulation Procedures ***/

	/**
	 * Inserts vertex v into the adjacency list of vertex u (i.e. inserts v into
	 * the list at index u) @precondition, 0 < u, v <= vertices
	 * 
	 * @throws IndexOutOfBounds
	 *             exception when the precondition is violated
	 */
	void addDirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {
		if (v > this.vertices || u < 0)
			throw new IndexOutOfBoundsException("addDirectedEdge() fails. It's out of bound.");
		this.adj.get(u - 1).addLast(v);
		this.edges++;
	}

	/**
	 * Inserts vertex v into the adjacency list of vertex u (i.e. inserts v into
	 * the list at index u) and inserts u into the adjacent vertex list of
	 * v @precondition, 0 < u, v <= vertices
	 * 
	 * @postcondition when precondition is violated
	 */
	void addUndirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {
		if (v > this.vertices || u < 0 || v < 0 || u > this.vertices)
			throw new IndexOutOfBoundsException("addUnDirectedEdge() fails. It's out of bound.");
		this.adj.get(u - 1).addLast(v);
		this.adj.get(v - 1).addLast(u);
		this.edges++;
	}
	
	//should be run after using BFS() to rank by both distance and interest
	private void rank() {
		for(int i=1;i<getNumVertices();i++) {
			rank.get(getDistance(i)).addLast(i);
        }
	}

	/*** Additional Operations ***/

	/**
	 * Creates a String representation of the Graph Prints the adjacency list of
	 * each vertex in the graph, vertex: <space separated list of adjacent
	 * vertices>
	 */
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < this.vertices; i++) {
			result += i + 1 + ":";
			adj.get(i).pointIterator();
			for (int k = 0; k < adj.get(i).getLength(); k++) {
				result += " " + adj.get(i).getIterator();
				adj.get(i).advanceIterator();
			}
			result += "\n";
		}
		return result;
	}

	/**
	 * Prints the current values in the parallel ArrayLists after executing BFS.
	 * First prints the heading: v <tab> c <tab> p <tab> d Then, prints out this
	 * information for each vertex in the graph Note that this method is
	 * intended purely to help you debug your code
	 */
	public void printBFS() {
		System.out.println("v\tc\tp\td");
		for (int i = 0; i < this.vertices; i++) {
			System.out.println((i + 1) + "\t" + color.get(i) + "\t" + parent.get(i) + "\t" + distance.get(i));
		}

	}
	
	public String rankString() {
		rank();
		String rankList="";
		for(int i=1;i<getNumVertices();i++) {
			if(!rank.get(i).isEmpty()) {
				
				rank.get(i).pointIterator();
				
			for(int k=0;k<rank.get(i).getLength();k++) {
				rankList+=" "+rank.get(i).getIterator();
				rank.get(i).advanceIterator();
			}

			rankList+="\n";
			}
		}
		return rankList;
	}

	/**
	 * Performs breath first search on this Graph give a source vertex
	 * 
	 * @param source
	 * @precondition graph must not be empty
	 * @precondition source is a vertex in the graph
	 * @throws IllegalStateException
	 *             if the graph is empty
	 * @throws IndexOutOfBoundsException
	 *             when the source vertex
	 */

	public void BFS(Integer source) throws IllegalStateException, IllegalArgumentException {
		List<Integer> queue = new List<Integer>();
		if (isEmpty())
			throw new IllegalStateException("BFS() fails. The graph is empty.");
		if (source > this.vertices)
			throw new IllegalArgumentException("BFS() fails. The input is not in the graph.");
		for (int i = 0; i < this.vertices; i++) {
			color.set(i, 'W');
			distance.set(i, -1);
			parent.set(i, 0);
		}
		color.set(source - 1, 'G');
		distance.set(source - 1, 0);
		queue.addLast(source);
		while (!queue.isEmpty()) {
			int x = queue.getFirst() - 1;
			queue.removeFirst();
			adj.get(x).pointIterator();
			for (int i = 0; i < adj.get(x).getLength(); i++) {
				int y = adj.get(x).getIterator() - 1;
				if (color.get(y) == 'W') {
					color.set(y, 'G');
					distance.set(y, distance.get(x) + 1);
					parent.set(y, x + 1);
					queue.addLast(y + 1);
				}
				adj.get(x).advanceIterator();
			}
			color.set(x, 'B');
		}

	}

	/**
	 * Recursive method to make a String containing the path from the source to
	 * the destination vertex
	 * 
	 * @param source
	 *            the source vertex when performing BFS
	 * @param destination
	 *            the destination vertex
	 * @param a
	 *            String containing the path
	 * @return a String containing the path
	 */
	// Prints to the console or to an output file given the ostream parameter
	public String printPath(Integer source, Integer destination, String path) {
		if (destination.equals(source))
			return source + " " + path;
		else if (parent.get(destination - 1) == 0)
			return "No path from " + source + " to " + destination + " exists";
		else
			return printPath(source, parent.get(destination - 1), destination + " " + path);

	}

}
