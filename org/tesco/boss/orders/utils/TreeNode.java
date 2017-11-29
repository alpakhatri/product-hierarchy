package org.tesco.boss.orders.utils;


public class TreeNode<T> {
       T data;
       public TreeNode<T> left;
       public TreeNode<T> right;

      public TreeNode(T data, TreeNode<T> l, TreeNode<T> r)
      {
         this.left = l; this.right = r;
         this.data = data;
      }

      public TreeNode(T data)
      {
         this(data, null, null);
      }

      public String toString()
      {
         return data.toString();
      }
}
