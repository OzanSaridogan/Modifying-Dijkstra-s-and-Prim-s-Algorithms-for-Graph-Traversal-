import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main implements Comparator<Edge> {

    public static void main(String[] args) throws IOException {
    	Scanner input = new Scanner(System.in);
    	String fileName =input.nextLine();
        //String fileName = "C:\\Users\\user\\Downloads\\input_q1.txt";
        Scanner scan = new Scanner(new File(fileName));
        List<Point1> vertexList = new ArrayList<>();
        Point1 point;
        Point1 point2 = new Point1();
        int vertexCount = 0;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String values[] = line.split(",");
            vertexCount++;
            point = new Point1(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]));
            vertexList.add(point);
        }

        
        
        Graph graph = new Graph(vertexCount);

        for (int i = 0; i < vertexList.size(); i++) {
            for (int w = i + 1; w < vertexList.size(); w++) {
                graph.addEdge(i, w, vertexList.get(i), vertexList.get(w));
            }
        }
            
            List<Edge> deneme = graph.primMST();
            deneme.sort(new Main());
            
            
            graph.printPaths();
       
}

	@Override
	public int compare(Edge o1, Edge o2) {
		
		return Double.compare(o1.getWeight(), o2.getWeight());
	}
    }
    

