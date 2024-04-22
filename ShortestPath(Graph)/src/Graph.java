import java.util.*;

public class Graph {

    private int V;
    public List<List<Point1>> adj;
    private Map<Integer, Point1> IntToPoint;
    private Map<Point1, Integer> PointToint;
    private Map<Point1, Point1> parentMap;
    private List<Edge> result = new ArrayList<>();
    
    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        IntToPoint = new HashMap<>();
        PointToint = new HashMap<>();
        for (int v = 0; v < V; v++) {
            adj.add(new ArrayList<>());
        }
    }

    int size() {
        return this.V;
    }

    void addEdge(int v, int w, Point1 a, Point1 b) {
        adj.get(v).add(b);  // Add point b to vertex v
        adj.get(w).add(a);  // Add point a to vertex w

        IntToPoint.put(v, a);
        IntToPoint.put(w, b);

        PointToint.put(a, v);
        PointToint.put(b, w);

        // Ensure that there is only one edge between each pair of vertices
        if (!adj.get(v).contains(a)) {
            adj.get(v).add(a);
        }
        if (!adj.get(w).contains(b)) {
            adj.get(w).add(b);
        }
    }


    
    Point1 getPoint(int n) {
    	return IntToPoint.get(n);
    }
    
    List<Edge> primMST() {
        List<Edge> result = new ArrayList<>(); // To store the edges of the minimum spanning tree

        // Priority queue to store edges with their weights
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingDouble(Edge::getWeight));

        // Set to keep track of visited vertices
        Set<Point1> visited = new HashSet<>();

        // Start with the first vertex (you can choose any starting vertex)
        Point1 startVertex = getPoint(0);
        visited.add(startVertex);

        // Add all edges of the starting vertex to the priority queue
        for (Point1 neighbor : adj.get(PointToint.get(startVertex))) {
            double weight = startVertex.calculateDistance(startVertex, neighbor);
            Math.round((weight*10.0)/10.0);
            pq.add(new Edge(startVertex, neighbor, weight));
        }

        while (!pq.isEmpty()) {
            Edge minEdge = pq.poll();

            Point1 currentVertex = minEdge.getTo();
            if (visited.contains(currentVertex)) {
                continue; // Skip if the vertex is already visited
            }

            // Add the edge to the result only if it is not already in the result list
            if (!result.contains(minEdge)) {
                result.add(minEdge);
            }

            visited.add(currentVertex);

            // Add all edges of the current vertex to the priority queue
            for (Point1 neighbor : adj.get(PointToint.get(currentVertex))) {
                if (!visited.contains(neighbor)) {
                    double weight = currentVertex.calculateDistance(currentVertex, neighbor);
                    Math.round((weight*10.0)/10.0);
                    pq.add(new Edge(currentVertex, neighbor, weight));
                }
            }
        }

        this.result = result; // Update the class-level result variable
        return result;
    }


    void printPaths() {
    	System.out.println("Paths are:");
    	for (int i = 0; i < result.size(); i++) {
    	    Point1 from = result.get(i).getFrom();
    	    Point1 to = result.get(i).getTo();
    	    double weight = result.get(i).getWeight();
    	    weight =(double) Math.round(weight * 10.0) / 10.0; // Round the weight and assign it back
    	    System.out.println(from.getLetter() + "-" + to.getLetter() + ": " + weight);
    	}
    }


}
