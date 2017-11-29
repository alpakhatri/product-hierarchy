package org.tesco.boss.orders.utils;

import java.util.Comparator;

public class Tree<T extends Comparable<T>> {
	 
	private TreeNode<T> root;
	private Comparator<T> comparator;

	public Tree()
   {
      setRoot(null);
      comparator = null;
   }

   public Tree(Comparator<T> comp)
   {
      setRoot(null);
      comparator = comp;
   }
   
	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
    
   public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}

    protected int compare(T x, T y)
   {
     return comparator == null ? x.compareTo(y) : comparator.compare(x,y);
   }

   
   /////////////////////////////
   public void insert(T data)
   {
      setRoot(insert(getRoot(), data));
   }
   
   private TreeNode<T> insert(TreeNode<T> node, T dataToInsert)
   {
      if (node == null)
         return new TreeNode<T>(dataToInsert);

      if (compare(dataToInsert, node.data) == 0)
      	 return node;

      if (compare(dataToInsert, node.data) < 0)
         node.left = insert(node.left, dataToInsert);
      else
         node.right = insert(node.right, dataToInsert);

      return node;
   }
   
   
   ////////////////////////////
   
   public boolean search(T dataToSearch)
   {
      return search(getRoot(), dataToSearch);
   }
   
   private boolean search(TreeNode<T> node, T dataToSearch)
   {
      if (node == null)
         return false;
      else if (compare(dataToSearch, node.data) == 0)
      	return true;
      else if (compare(dataToSearch, node.data) < 0)
         return search(node.left, dataToSearch);
      else
         return search(node.right, dataToSearch);
   }
   
   /////////////////////////////
   
   public void delete(T dataToDelete)
   {
      setRoot(delete(getRoot(), dataToDelete));
   }
   
   private TreeNode<T> delete(TreeNode<T> node, T dataToDelete)
   {
      if (node == null)  
    	  throw new RuntimeException("cannot delete.");
      else if (compare(dataToDelete, node.data) < 0)
    	  node.left = delete (node.left, dataToDelete);
      else if (compare(dataToDelete, node.data)  > 0)
    	  node.right = delete (node.right, dataToDelete);
      else
      {
         if (node.left == null) 
        	 return node.right;
         else if (node.right == null) 
        	 return node.left;
         else
         {
            node.data = retrieveData(node.left);
            node.left =  delete(node.left, node.data) ;
         }
      }
      return node;
   }
   private T retrieveData(TreeNode<T> node)
   {
      while (node.right != null) 
    	  node = node.right;
      return node.data;
   }
   ///////////////////////////
   
   public void inOrderTraversal()
   {
      inOrderHelper(getRoot());
   }
   private void inOrderHelper(TreeNode<T> node)
   {
      if (node != null)
      {
         inOrderHelper(node.left);
         System.out.print(node+" ");
         inOrderHelper(node.right);
      }
   }

}
