package org.morshed.heap;

public class Heap {
  private int[] items = new int[10];
  private int size;

  public void insert(int value){
    if(iszFull())
      throw new IllegalStateException();
    items[size++] = value;
    bubbleUp();
  }

  public void remove(){
    if(isEmpty())
      throw new IllegalStateException();
    items[0] = items[--size];
    var index = 0;
    while(index<=size &&  isValidParent(index)){
      var largetChildIndex = largerChildIndex(index);
      swap(index, largetChildIndex);
      index = largetChildIndex;
    }
  }

  public boolean isEmpty(){
    return size ==0;
  }

  private int largerChildIndex(int index){
    return (leftChild(index) > rightChild(index))?
      leftChildIndex(index):
      rightChildIndex(index);
  }

  private boolean isValidParent(int index){
    return items[index] >= leftChild(index) &&
      items[index] >= rightChild(index);
  }

  private int leftChild(int index){
    return leftChildIndex(index);
  }

  private int rightChild(int index){
    return rightChildIndex(index);
  }

  private int leftChildIndex(int index){
    return index * 2 + 1;
  }

  private int rightChildIndex(int index){
    return index * 2 + 2;
  }
  public boolean iszFull(){
    return size == items.length;
  }

  private void bubbleUp(){
    var index = size -1;
    while(index>0
      && items[index] > items[parent(index)]){
      swap(index, parent(index));
      index = parent(index);
    }
  }

  private int parent(int index){
    return (index-1)/2;
  }

  private void swap(int first, int second){
    var temp = items[first];
    items[first] = items[second];
    items[second] = temp;
  }
}