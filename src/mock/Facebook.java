/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

/**
 *
 * @author jochen
 */
public class Facebook {
    public static void main(String[] args){
        //subsets(new int[]{1,2,3});
        //lenghtOfLongestAP(new int[]{0,5,7,10,14,15},6);
        
        TreeNode root = new TreeNode(10);
  
        // Let us create the tree shown in above diagram

        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
  
        // Convert to DLL
        TreeNode head = bintree2list(root);
  
        // Print the converted list
        printList(head);
    }
    
    public static void printList(TreeNode head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.right;
        }
    }
    
    public static TreeNode bintree2list(TreeNode root){
        if(root == null) return null;
        
        if(root.left != null){
            TreeNode lnode = bintree2list(root.left);
            while(lnode.right != null){
                lnode = lnode.right;
            }
            lnode.right = root;
            root.left = lnode;
        }
        
        if(root.right != null){
            TreeNode rnode = bintree2list(root.right);
            while(rnode.left != null){
                rnode = rnode.left;
            }
            rnode.left = root;
            root.right = rnode;
        }
        
        while(root.left != null){
            root = root.left;
        }
        
        return root;
    }
    
    public static int lenghtOfLongestAP(int set[], int n)
    {
        if (n <= 2)  return n;

        // Create a table and initialize all values as 2. The value of
        // L[i][j] stores LLAP with set[i] and set[j] as first two
        // elements of AP. Only valid entries are the entries where j>i
        int[][] L = new int[n][n];
        int llap = 2;  // Initialize the result

        // Fill entries in last column as 2. There will always be
        // two elements in AP with last number of set as second
        // element in AP
        for (int i = 0; i < n; i++)
            L[i][n-1] = 2;

        // Consider every element as second element of AP
        for (int j=n-2; j>=1; j--)
        {
            // Search for i and k for j
            int i = j-1, k = j+1;
            while (i >= 0 && k <= n-1)
            { print(L);
                
               if (set[i] + set[k] < 2*set[j])
                   k++;

               // Before changing i, set L[i][j] as 2
               else if (set[i] + set[k] > 2*set[j])
               {   L[i][j] = 2; i--;   }

               else
               {
                   // Found i and k for j, LLAP with i and j as first two
                   // elements is equal to LLAP with j and k as first two
                   // elements plus 1. L[j][k] must have been filled
                   // before as we run the loop from right side
                   L[i][j] = L[j][k] + 1;

                   // Update overall LLAP, if needed
                   llap = Math.max(llap, L[i][j]);

                   // Change i and k to fill more L[i][j] values for
                   // current j
                   i--; k++;
               }
            }

            // If the loop was stopped due to k becoming more than
            // n-1, set the remaining entties in column j as 2
            while (i >= 0)
            {
                L[i][j] = 2;
                i--;
            }
            //print(L);
        }
        return llap;
    }
    
    public static void print(int[][] input){
        for(int[] ai : input){
            for(int i : ai){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("--------------");
    }
    
    //572. Subtree of Another Tree
    public boolean isSubtree(TreeNode s, TreeNode t) {               
        if(s == null && t != null) return false;
        if(isSametree(s,t)) return true;
        if(isSametree(s.left,t) || isSametree(s.right,t)) return true;        
        return false;
    }
    
    public boolean isSametree(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val != t.val) return false;        
        return isSametree(s.left, t.left) && isSametree(s.right, t.left);
    }
}
