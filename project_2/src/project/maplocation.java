/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.w3c.dom.Node;

/**
 *
 * @author nikne
 */
public class maplocation extends javax.swing.JFrame {

  String nachalna, destination;
  
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
       Node startNode = getNodeByLabel("Русе");
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
   public int shortestPathLengthFromATo(String destinationLabel) {
        Node startNode = getNodeByLabel("Русе");
        Node destinationNode = getNodeByLabel(destinationLabel);
        if (startNode == null || destinationNode == null) {
            throw new IllegalArgumentException("Invalid node!");
        }

 

        // Perform Dijkstra's algorithm to find the shortest path
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

 

        // Find the shortest path length
        return destinationNode.distance;
    }

   private class Node {
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

   private class Edge {
       private Node destination;
       private int weight;

       public Edge(Node destination, int weight) {
           this.destination = destination;
           this.weight = weight;
       }
   }
}

    /**
     * Creates new form maplocation
     */
    public maplocation() {
        initComponents();
        setLocationRelativeTo(null);
        destination = Destination.getDestination();
        nachalna = "Русе";
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/pictures/map(2).jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        jButton1.setText("Проследи");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(236, 6, 14));
        jButton2.setText("Х");

        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton2)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jButton3))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 233, Short.MAX_VALUE)
                    .addComponent(jButton2)
                    .addGap(0, 233, Short.MAX_VALUE)))
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
       graph.addNode("Стара Загора");
       graph.addNode("Хасково");
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
       graph.addEdge("София" , "Плевен", 132);
       graph.addEdge("Плевен" , "София", 132);
       graph.addEdge("Стара Загора", "Пловдив",102);
       graph.addEdge("Пловдив", "Стара Загора",102);
       graph.addEdge("Велико Търново", "Стара Загора",107);
       graph.addEdge("Стара Загора", "Велико Търново",107);
       graph.addEdge("Стара Загора", "Хасково",60);
       graph.addEdge("Хасково", "Стара Загора",60);
       graph.addEdge("Бургас", "Стара Загора",172);
       graph.addEdge("Стара Загора", "Бургас",172);
       graph.addEdge("Хасково", "Свиленград", 74);
       graph.addEdge("Свиленград", "Хасково",74);
               
       // Взимане на съседите
       /*List<Graph.Edge> neighbors = graph.getNeighbors("Велико Търново");
       System.out.println("Neighbors of Велико Търново: ");
       for (Graph.Edge edge : neighbors) {
           Graph.Node destination = edge.getDestination();
           int weight = edge.getWeight();
           System.out.println("Destination: " + destination.getLabel() + ", Weight: " + weight);
       }*/
       Scanner input = new Scanner(System.in);
        
        //nachalna = input.nextLine();
        
      
        List<String> shortestPath = graph.shortestPathFromATo(destination);
        int shortestPathLength = graph.shortestPathLengthFromATo(destination);
        
        System.out.println("Shortest path length from " + nachalna + " to " + destination + ": " + shortestPathLength);
        
       //JOptionPane.showMessageDialog(null,"Shortest path from " + nachalna + " to "  + destination + ":" + "\n" + cities);
       System.out.println("Shortest path from " + nachalna + "to " + destination + ": ");
       LinkedList<String> cities = new LinkedList<>();
       for (String node : shortestPath) {
           //System.out.print(node + " ");
           cities.add(node);
        }
       JOptionPane.showMessageDialog(null,"Shortest path from " + nachalna + " to "  + destination + ":" + "\n" + cities + 
           "\n" + "distance: " + shortestPathLength);
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
