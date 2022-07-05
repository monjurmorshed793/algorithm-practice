package org.morshed.heap;

public class HeapTest {
  public static void main(String[] args) {
    var heap = new Heap();
    heap.insert(10);
    heap.insert(5);
    heap.insert(17);
    heap.insert(4);
    heap.insert(22);

    heap.remove();

    heap.insert(23);

    System.out.println(heap);
  }
}
