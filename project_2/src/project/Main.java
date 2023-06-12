
import java.util.*;

class Graph {

        private List<List<Edge>> adjacencyList;

        public Graph(int size) {
               adjacencyList = new ArrayList<>(size);
               for (int i = 0; i < size; i++) {
                       adjacencyList.add(new ArrayList<>());
               }

    

    
    

       }

     public void addNode(char node) {
               adjacencyList.add(new ArrayList<>());
    

       }

     public void addEdge(int source, int destination, int weight) {
               if (source < 0 || source >= adjacencyList.size() ||
  {

        }               destination< 0 || destination >= adjacencyList.size()
        ) {

            
                       throw new IllegalArgumentException("Invalid node!");
               }

        
               adjacencyList.get(source).add(new Edge(destination, weight));
               adjacencyList.get(destination).add(new Edge(source, weight)); // Uncomment this line for an undirected graph

    

       }

     public List<Edge> getNeighbors(int node) {
               if (node < 0 || node >= adjacencyList.size()) {
                       throw new IllegalArgumentException("Invalid node!");
               }

        
               return adjacencyList.get(node);
    


   }
}

class Edge {

        private int destination;
        private int weight;

        public Edge(int destination, int weight) {
               this.destination = destination;
               this.weight = weight;
    

       }

     public int getDestination() {
               return destination;
    

       }

     public int getWeight() {
               return weight;
    


   }
}

public class Main {

        public static void main(String[] args) {
               int numNodes = 5;
               Graph graph = new Graph(numNodes);
               // Adding nodes
       graph.addNode('A');
               graph.addNode('B');
               graph.addNode('C');
               graph.addNode('D');
               graph.addNode('E');
               // Adding weighted edges
       graph.addEdge(0, 1, 2);
               graph.addEdge(1, 2, 3);
               graph.addEdge(2, 3, 4);
               graph.addEdge(3, 4, 5);
               // Getting neighbors of a node
       List<Edge> neighbors = graph.getNeighbors(2);
               System.out.println("Neighbors of C: ");
               for (Edge edge : neighbors) {
                       int destination = edge.getDestination();
                       int weight = edge.getWeight();
                       System.out.println("Destination: " + (char) ('A' + destination) + ", Weight: " + weight);
               }

    


    

   }
}
