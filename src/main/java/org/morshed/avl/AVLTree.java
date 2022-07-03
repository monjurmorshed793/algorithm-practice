package org.morshed.avl;

public class AVLTree {
  private class AVLNode{
    private int height;
    private int value;
    private AVLNode leftChild;
    private AVLNode rightChild;

    public AVLNode(int value){
      this.value = value;
    }

    @Override
    public String toString(){
      return "Value="+this.value;
    }
  }

  private AVLNode root;

  public void insert(int value){
    root =  insert(root, value);
  }

  private AVLNode insert(AVLNode root, int value){
    if(root==null)
      return new AVLNode(value);

    if(value < root.value)
      root.leftChild =  insert(root.leftChild, value);
    else
      root.rightChild = insert(root.rightChild, value);


    root.height = Math.max(height(root.leftChild), height(root.rightChild))+1;

    var balanceFactor= height(root.leftChild) - height(root.rightChild);
    if(balanceFactor>1)
      System.out.println(root.value+" is left heavy");
    else if(balanceFactor<-1)
      System.out.println(root.value+" is right heavy");
    return root;
  }

  private int height(AVLNode node){
    return node == null ? -1 : node.height;
  }
}
