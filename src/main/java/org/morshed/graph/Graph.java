package org.morshed.graph;

import java.util.*;

public class Graph {
  private class Node{
    private String label;

    public Node(String label) {
      this.label = label;
    }

    @Override
    public String toString() {
      return label;
    }
  }
  private Map<String, Node> nodes = new HashMap<>();
  private Map<Node, List<Node>> adjancencyList = new HashMap<>();

  public void addNode(String label){
    var node = new Node(label);
    nodes.putIfAbsent(label, node);
    adjancencyList.putIfAbsent(node, new ArrayList<>());
  }

  public void addEdge(String from, String to){
    var fromNode = nodes.get(from);
    if(fromNode == null)
      throw new IllegalArgumentException();

    var toNode = nodes.get(to);
    if(toNode == null)
      throw new IllegalArgumentException();

    adjancencyList.get(fromNode).add(toNode);
  }

  public void print(){
    for(var source: adjancencyList.keySet()){
      var targets = adjancencyList.get(source);
      if(!targets.isEmpty())
        System.out.println(source + " is connected to "+ targets);
    }
  }

  public void removeNode(String label){
    var node = nodes.get(label);
    if(node == null)
      return;

    for(var n: adjancencyList.keySet()){
      adjancencyList.get(n).remove(node);
    }

    adjancencyList.remove(node);
    nodes.remove(node);
  }


  public void removeEdge(String from, String to){
    var fromNode = nodes.get(from);
    var toNode = nodes.get(to);

    if(fromNode == null || toNode ==null)
      return;

    adjancencyList.get(fromNode).remove(toNode);
  }

  public void traverseDepthFirstRec(String root){
    var node = nodes.get(root);
    if(node == null)
      return;
    traverseDepthFirstRec(node, new HashSet<>());
  }

  public void traverseDepthFirstRec(Node root, Set<Node> visited){
    System.out.println(root);
    visited.add(root);

    for(var node: adjancencyList.get(root)){
      if(!visited.contains(node))
        traverseDepthFirstRec(node, visited);
    }
  }

  public void traverseDepthFirst(String root){
    var node = nodes.get(root);

    if(node ==null)
      return;

    Set<Node> visited = new HashSet<>();
    Stack<Node> stack = new Stack<>();

    stack.push(node);

    while(!stack.isEmpty()){
      var current = stack.pop();

      if(visited.contains(current))
        continue;

      System.out.println(current);
      visited.add(current);

      for(var neighbor: adjancencyList.get(current)){
        if(!visited.contains(neighbor))
          stack.push(neighbor);
      }
    }
  }

  public void traverseBreadthFirst(String root){
    var node = nodes.get(root);
    if(node == null)
      return;
    Set<Node> visited = new HashSet<>();

    Queue<Node> queue = new ArrayDeque<>();
    queue.add(node);

    while(!queue.isEmpty()){
      var current = queue.remove();

      if(visited.contains(current))
        continue;;
      System.out.println(current);
      visited.add(current);

      for(var neighbor: adjancencyList.get(current))
        if(!visited.contains(neighbor))
          queue.add(neighbor);
    }
  }

  public List<String> topologicalSort(){
    Stack<Node>  stack = new Stack<>();
    Set<Node> visited = new HashSet<>();
    for(var node: nodes.values())
      topologicalSort(node, visited, stack);

    List<String> sorted = new ArrayList<>();
    while(!stack.isEmpty())
      sorted.add(stack.pop().label);

    return sorted;
  }

  private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack){
    if(visited.contains(node))
      return;
    visited.add(node);

    for(var neighbor: adjancencyList.get(node)){
      topologicalSort(neighbor, visited, stack);
    }
    stack.push(node);
  }
}
