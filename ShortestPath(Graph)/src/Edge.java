

public class Edge {
        private Point1 from;
        private Point1 to;
        private double weight;

        Edge(Point1 from, Point1 to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        Point1 getFrom() {
            return from;
        }

        Point1 getTo() {
            return to;
        }

        double getWeight() {
            return weight;
        }
        
        
    }
