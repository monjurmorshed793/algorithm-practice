package org.morshed.tries;

public class TrieTest {
  public static void main(String[] args) {
    var trie = new Trie();
    trie.insert("cat");
    trie.insert("can");
    System.out.println(trie.contains("can"));
    trie.insert("canada");
    System.out.println(trie.contains("canada"));

    trie.remove("can");

    System.out.println(trie.contains("can"));

  }
}
