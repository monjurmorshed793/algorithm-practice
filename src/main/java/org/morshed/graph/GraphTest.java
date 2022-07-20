package org.morshed.graph;

public class GraphTest {
  public static void main(String[] args) {
    var graph = new Graph();
    graph.addNode("A");
    graph.addNode("B");
    graph.addNode("C");
    graph.addEdge("A", "B");
    graph.addEdge("A", "C");
    graph.removeNode("A");
    graph.addEdge("B", "C");
    graph.print();

    System.out.println("Traversal");


    graph = new Graph();
    graph.addNode("A");
    graph.addNode("B");
    graph.addNode("C");
    graph.addNode("D");
    graph.addEdge("A", "B");
    graph.addEdge("B", "D");
    graph.addEdge("D", "C");
    graph.addEdge("A", "C");
    System.out.println("Recursive");
    graph.traverseDepthFirstRec("A");
    System.out.println("Iterative");
    graph = new Graph();
    graph.addNode("A");
    graph.addNode("B");
    graph.addNode("C");
    graph.addNode("D");
    graph.addEdge("A", "B");
    graph.addEdge("B", "D");
    graph.addEdge("D", "C");
    graph.addEdge("A", "C");
    graph.traverseDepthFirst("A");

    System.out.println("BFS");
    graph = new Graph();
    graph.addNode("A");
    graph.addNode("B");
    graph.addNode("C");
    graph.addNode("D");
    graph.addEdge("A", "B");
    graph.addEdge("B", "D");
    graph.addEdge("D", "C");
    graph.addEdge("A", "C");
    graph.traverseBreadthFirst("A");
  }
}
