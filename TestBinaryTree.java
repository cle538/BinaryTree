
/*
  File: TestBinaryTree.java

  Description: Makes binary trees and gets their height, prints out their levels, and tests if they are similar.

  Student Name: Catherine Evans

  Student UT EID: cle538

  Course Name: CS 313E

*/

import java.util.*;

class Node
{
  public int iData;
  public Node lChild;
  public Node rChild;

  public Node ()
  {  
     iData = 0;
     lChild = null;
     rChild = null;
  }

  public Node (int val)
  {  
     iData = val;
     lChild = null;
     rChild = null;
  }
}

class Tree
{
  public Node root;

  public Tree ()
  {
     root = null;
   }

  // Search for a node with a given key
  public Node search (int key)
  {
     Node current = root;

     while ((current != null) && (current.iData != key))
     {
        if (key < current.iData)
          current = current.lChild;
        else
        	current = current.rChild;
      }
      return current;
  }

  // Insert a node in a tree with a given value
  public void insert (int val)
  {
	 Node newNode = new Node (val);
	 if (root == null)
	 {
	    root = newNode;
	 }
	 else
	 {
	    Node current = root;
	    Node parent = root;
	    while (current != null)
	    {
	    	parent = current;
	  	    if (val < current.iData)
	  	    	current = current.lChild;
	        else
	        	current = current.rChild;
	     }
	     if (val < parent.iData)
	    	 parent.lChild = newNode;
	     else
	    	 parent.rChild = newNode;
	    }
	}

  // Returns true if two binary trees are similar
  public boolean isSimilar (Tree aTree, Node node1, Node node2)
  {
	  if(getHeight(root, 0) != aTree.getHeight(aTree.root, 0))
	  {
		  return false;
	  }
	  if(node1 != null && node2 != null)
	  {
		  if (node1.iData == node2.iData)
		  {
				  if(isSimilar (aTree, node1.lChild, node2.lChild) == false)
					  return false;
				  if(isSimilar (aTree, node1.rChild, node2.rChild) == false)
					  return false;
		  }

	  }  
	  else if((node1 == null && node2 != null) || (node1 != null && node2 == null))
		  return false;
	  return true;
  }


  // Prints out all nodes at the given level
  
  public void printLevel(Node aNode, int level, int levelToPrint)
  {
	  if(aNode == null)
	  {
		  return;
	  }
	  else if(level == levelToPrint)
	  {
		  System.out.print(aNode.iData + " ");
	  }
	  else
	  {
		  printLevel(aNode.lChild, level + 1, levelToPrint);
		  printLevel(aNode.rChild, level + 1, levelToPrint);
	  }
  }
  // Returns the height of the tree
  public int getHeight (Node aNode, int level) 
  {
	  if(aNode == null)
	  {
		  return level - 1;
	  }
	  else
	  {
		  int lHeight = getHeight(aNode.lChild, level + 1);
		  int rHeight = getHeight(aNode.rChild, level + 1);
		  return Math.max(lHeight, rHeight);
	  }
  }
}

public class TestBinaryTree
{
  public static void main (String[] args)
  {
    // Create three trees - two are the same and the third is different
	  Tree tree1 = new Tree();
	  tree1.insert(50);
	  tree1.insert(48);
	  tree1.insert(65);
	  tree1.insert(37);
	  tree1.insert(89);

	  
	  Tree tree2 = new Tree();
	  tree2.insert(50);
	  tree2.insert(48);
	  tree2.insert(65);
	  tree2.insert(37);
	  tree2.insert(89);
	  
	  Tree tree3 = new Tree();
	  tree3.insert(40);
	  tree3.insert(35);
	  tree3.insert(9);
	  tree3.insert(15);
	  tree3.insert(56);
	  tree3.insert(74);
	  
	  
    // Test your method isSimilar()
	  System.out.println("isSimilar test:");
	  System.out.println(tree1.isSimilar(tree3, tree3.root, tree1.root));
	  System.out.println(tree1.isSimilar(tree2, tree2.root, tree1.root));
	  System.out.println();

    // Print the various levels of two of the trees that are different
	  System.out.println("tree1 levels:");
	  for(int i = 0; i < 3; i++)
	  {
		  tree1.printLevel(tree1.root, 0, i);
		  System.out.println();
	  }
	  System.out.println();
	  System.out.println("tree3 levels:");
	  for(int i = 0; i < 4; i ++)
	  {
		  tree3.printLevel(tree3.root, 0, i);
		  System.out.println();
	  }
	  System.out.println();
	  
    // Get the height of the two trees that are different
	  System.out.print("tree1 height: ");
	  System.out.println(tree1.getHeight(tree1.root, 0));
	  System.out.println();
	  System.out.print("tree3 height: ");
	  System.out.println(tree3.getHeight(tree3.root, 0));

  }
}
