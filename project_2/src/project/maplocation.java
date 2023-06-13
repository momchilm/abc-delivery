/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.w3c.dom.Node;

/**
 *
 * @author nikne
 */
public class maplocation extends javax.swing.JFrame {

   /* class Graph {
   private List<Node> nodes;

   public Graph() {
       nodes = new ArrayList<>();
   }

   public void addNode(String label) {
       Node node = new Node(label);
       nodes.add(node);
   }

   public void addEdge(String sourceLabel, String destinationLabel, int weight) {
       Node source = getNodeByLabel(sourceLabel);
       Node destination = getNodeByLabel(destinationLabel);
       if (source == null || destination == null) {
           throw new IllegalArgumentException("Invalid node!");
       }
       source.addEdge(destination, weight);
      
   }

   public List<Edge> getNeighbors(String label) {
       Node node = getNodeByLabel(label);
       if (node == null) {
           throw new IllegalArgumentException("Invalid node!");
       }
       return node.getEdges();
   }

   private Node getNodeByLabel(String label) {
       for (Node node : nodes) {
           if (node.getLabel().equals(label)) {
               return node;
           }
       }
       return null;
   }
   private  class Node {
       private String label;
       private List<Edge> edges;

       public Node(String label) {
           this.label = label;
           this.edges = new ArrayList<>();
       }

       public String getLabel() {
           return label;
       }

       public void addEdge(Node destination, int weight) {
           Edge edge = new Edge(destination, weight);
           edges.add(edge);
       }

       public List<Edge> getEdges() {
           return edges;
       }
   }

   private  class Edge {
       private Node destination;
       private int weight;

       public Edge(Node destination, int weight) {
           this.destination = destination;
           this.weight = weight;
       }

       public Node getDestination() {
           return destination;
       }

       public int getWeight() {
           return weight;
       }
   }
}*/
    class Graph {
   private List<Node> nodes;

   public Graph() {
       nodes = new ArrayList<>();
   }

   public void addNode(String label) {
       Node node = new Node(label);
       nodes.add(node);
   }

   public void addEdge(String sourceLabel, String destinationLabel, int weight) {
       Node source = getNodeByLabel(sourceLabel);
       Node destination = getNodeByLabel(destinationLabel);
       if (source == null || destination == null) {
           throw new IllegalArgumentException("Invalid node!");
       }
       source.addEdge(destination, weight);
       // Uncomment the following line for an undirected graph
       // destination.addEdge(source, weight);
   }

   public List<Edge> getNeighbors(String label) {
       Node node = getNodeByLabel(label);
       if (node == null) {
           throw new IllegalArgumentException("Invalid node!");
       }
       return node.getEdges();
   }

   public List<String> shortestPathFromATo(String destinationLabel) {
       Node startNode = getNodeByLabel("A");
       Node destinationNode = getNodeByLabel(destinationLabel);
       if (startNode == null || destinationNode == null) {
           throw new IllegalArgumentException("Invalid node!");
       }

       PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
       for (Node node : nodes) {
           if (node == startNode) {
               node.distance = 0;
           } else {
               node.distance = Integer.MAX_VALUE;
           }
           node.previous = null;
           priorityQueue.add(node);
       }

       while (!priorityQueue.isEmpty()) {
           Node currentNode = priorityQueue.poll();

           for (Edge edge : currentNode.edges) {
               Node neighborNode = edge.destination;
               int weight = edge.weight;
               int distance = currentNode.distance + weight;

               if (distance < neighborNode.distance) {
                   priorityQueue.remove(neighborNode);
                   neighborNode.distance = distance;
                   neighborNode.previous = currentNode;
                   priorityQueue.add(neighborNode);
               }
           }
       }

       // Build the shortest path
       List<String> shortestPath = new ArrayList<>();
       Node node = destinationNode;
       while (node != null) {
           shortestPath.add(0, node.label);
           node = node.previous;
       }
       return shortestPath;
   }

   private Node getNodeByLabel(String label) {
       for (Node node : nodes) {
           if (node.label.equals(label)) {
               return node;
           }
       }
       return null;
   }

   private  class Node {
       private String label;
       private List<Edge> edges;
       private int distance;
       private Node previous;

       public Node(String label) {
           this.label = label;
           this.edges = new ArrayList<>();
           this.distance = Integer.MAX_VALUE;
           this.previous = null;
       }

       public void addEdge(Node destination, int weight) {
           Edge edge = new Edge(destination, weight);
           edges.add(edge);
       }

       public List<Edge> getEdges() {
           return edges;
       }
   }

   private  class Edge {
       private Node destination;
       private int weight;

       public Edge(Node destination, int weight) {
           this.destination = destination;
           this.weight = weight;
       }
   }
}
   /* public List<String> shortestPath(String startLabel, String endLabel) {
       Node startNode = getEdges(startLabel);
       Node endNode = getNodeByLabel(endLabel);
       if (startNode == null || endNode == null) {
           throw new IllegalArgumentException("Invalid node!");
       }

       Map<Node, Integer> distances = new HashMap<>();
       Map<Node, Node> previousNodes = new HashMap<>();
       PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

       // Initialize distances and previous nodes
       for (Node node : nodes) {
           if (node == startNode) {
               distances.put(node, 0);
           } else {
               distances.put(node, Integer.MAX_VALUE);
           }
           previousNodes.put(node, null);
       }

       // Enqueue the start node
       priorityQueue.add(startNode);

       while (!priorityQueue.isEmpty()) {
           Node currentNode = priorityQueue.poll();

           if (currentNode == endNode) {
               // Build the shortest path
               List<String> shortestPath = new ArrayList<>();
               Node node = endNode;
               while (node != null) {
                   shortestPath.add(0, node.getLabel());
                   node = previousNodes.get(node);
               }
               return shortestPath;
           }

           for (Edge edge : currentNode.getEdges()) {
               Node neighborNode = edge.getDestination();
               int weight = edge.getWeight();
               int distance = distances.get(currentNode) + weight;

               if (distance < distances.get(neighborNode)) {
                   distances.put(neighborNode, distance);
                   previousNodes.put(neighborNode, currentNode);
                   priorityQueue.remove(neighborNode);  // Update priority
                   priorityQueue.add(neighborNode);
               }
           }
       }

       // No path found
       return null;
   }
}*/
    /*public List<String> shortestPath(String startLabel, String endLabel) {
      Node startNode = getLabel(startLabel);
       Node endNode = getLabel(endLabel);
       if (startNode == null || endNode == null) {
           throw new IllegalArgumentException("Invalid node!");
       }

       Map<Node, Integer> distances = new HashMap<>();
       Map<Node, Node> previousNodes = new HashMap<>();
       PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

       // Initialize distances and previous nodes
       for (Node node : node) {
           if (node == startNode) {
               distances.put(node, 0);
           } else {
               distances.put(node, Integer.MAX_VALUE);
           }
           previousNodes.put(node, null);
       }

       // Enqueue the start node
       priorityQueue.add(startNode);

       while (!priorityQueue.isEmpty()) {
           Node currentNode = priorityQueue.poll();

           if (currentNode == endNode) {
               // Build the shortest path
               List<String> shortestPath = new ArrayList<>();
               Node node = endNode;
               while (node != null) {
                   shortestPath.add(0, node.getLabel());
                   node = previousNodes.get(node);
               }
               return shortestPath;
           }

           for (Edge edge : currentNode.getEdges()) {
               Node neighborNode = edge.getDestination();
               int weight = edge.getWeight();
               int distance = distances.get(currentNode) + weight;

               if (distance < distances.get(neighborNode)) {
                   distances.put(neighborNode, distance);
                   previousNodes.put(neighborNode, currentNode);
                   priorityQueue.remove(neighborNode);  // Update priority
                   priorityQueue.add(neighborNode);
               }
           }
       }

       // No path found
       return null;
   }
}*/

    /**
     * Creates new form maplocation
     */
    public maplocation() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/map(2).jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String Vidin, Sofia, Blagoevgrad, Pleven, Plovdiv, Svilengrad, Turnovo, Burgas, Varna, Ruse;

        int numNodes = 5;
         Graph graph = new Graph();

       // Добавяне на върхове
       graph.addNode("Русе");
       graph.addNode("Варна");
       graph.addNode("Велико Търново");
       graph.addNode("Бургас");
       graph.addNode("Свиленград");
       graph.addNode("Пловдив");
       graph.addNode("Плевен");
       graph.addNode("Благоевград");
       graph.addNode("София");
       graph.addNode("Видин");

       // Добавяне на претегленост
       graph.addEdge("Русе", "Варна", 192);
       graph.addEdge("Варна", "Русе", 192);
       graph.addEdge("Русе", "Велико Търново", 108);
       graph.addEdge("Велико Търново", "Русе", 108);
       graph.addEdge("Варна", "Бургас", 129);
       graph.addEdge("Бургас", "Варна", 129);
       graph.addEdge("Бургас", "Пловдив", 254);
       graph.addEdge("Пловдив", "Бургас", 254);
       graph.addEdge("Пловдив", "Свиленград", 151);
       graph.addEdge("Свиленград", "Пловдив", 151);
       graph.addEdge("Пловдив", "София", 144);
       graph.addEdge("София", "Пловдив", 144);
       graph.addEdge("Свиленград", "Благоевград", 374);
       graph.addEdge("Благоевград", "Свиленград", 374);
       graph.addEdge("София", "Благоевград", 102);
       graph.addEdge("Благоевград", "София", 102);
       graph.addEdge("София", "Видин", 204);
       graph.addEdge("Видин", "София", 204);
       graph.addEdge("Видин", "Плевен", 206);
       graph.addEdge("Плевен", "Видин", 206);
       graph.addEdge("Плевен", "Велико Търново", 121);
       graph.addEdge("Велико Търново", "Плевен", 121);

       // Взимане на съседите
       /*List<Graph.Edge> neighbors = graph.getNeighbors("Велико Търново");
       System.out.println("Neighbors of Велико Търново: ");
       for (Graph.Edge edge : neighbors) {
           Graph.Node destination = edge.getDestination();
           int weight = edge.getWeight();
           System.out.println("Destination: " + destination.getLabel() + ", Weight: " + weight);
       }*/
         // Find the shortest path from A to a manually inserted node
       /*String startLabel = "A";
       String endLabel = "E";
       List<String> shortestPath = graph.shortestPath(startLabel, endLabel);
*/
      /* if (shortestPath != null) {
           System.out.println("Shortest path from " + startLabel + " to " + endLabel + ": " + shortestPath);
       } else {
           System.out.println("No path found from " + startLabel + " to " + endLabel);
       }*/
         

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(maplocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(maplocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(maplocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(maplocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new maplocation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
