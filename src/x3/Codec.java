/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x3;
import java.util.*;
/**
 *
 * @author jochen
 */
//297. Serialize and Deserialize Binary Tree
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {        
        String retstr = "";
        if(root == null) return "[]";
        retstr = "[" + root.val;
        //Queue<TreeNode> tq = new LinkedList();
        List<TreeNode> tlist = new ArrayList();
        tlist.add(root);
        while(!tlist.isEmpty()){
            List<TreeNode> tmpList = new ArrayList();
            for(int i = 0; i < tlist.size(); i++){
                TreeNode tmpNode = tlist.get(i);
                if(tmpNode.left == null){
                    retstr += ",null";
                }else{
                    retstr += "," + tmpNode.left.val;
                    tmpList.add(tmpNode.left);
                }
                if(tmpNode.right == null){
                    retstr += ",null";
                }else{
                    retstr += "," + tmpNode.right.val;
                    tmpList.add(tmpNode.right);
                }
            }
            tlist = tmpList;
        }
        retstr += "]";
        return retstr;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode retNode;
        data = data.substring(1, data.length() - 1);
        if(data.length() == 0) return null;
        String[] nodeval = data.split(",");
        retNode = new TreeNode(Integer.parseInt(nodeval[0]));
        List<TreeNode> nodeList = new ArrayList();
        for(int i = 1; i < nodeval.length;){
            List<TreeNode> tmpList = new ArrayList();
            for(int j = 0; j < nodeList.size(); j++){
                TreeNode cur = nodeList.get(i);
                String left = nodeval[i++];
                String right = nodeval[i++];
                if(!left.equals("null")){
                    TreeNode leftNode = new TreeNode(Integer.parseInt(left));
                    tmpList.add(leftNode);
                }
                if(!right.equals("null")){
                    TreeNode rightNode = new TreeNode(Integer.parseInt(right));
                    tmpList.add(rightNode);
                }
            }
            nodeList = tmpList;
        }        
        return retNode;
    }
}
