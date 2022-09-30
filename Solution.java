import java.util.*;

class Main{
    static class Node{
        int data;
        Node left;
        Node right;
        
        Node(int data){
            this.data= data;
        }
    }
    
    //insert function to insert elements in tree
    public static Node insert(int val, Node root){
        if(root== null){
            root= new Node(val);
            return root;
        }
        if(root.data>val){
            root.left= insert(val, root.left);
        }
        else{
            root.right= insert(val, root.right);
        }
        return root;
    }
    
    //inorder function to check if elements have inserted properly
    public static void inorder(Node root){
        if(root== null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
    //function to print the path
    public static void printpath(ArrayList<Integer> path){
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i)+"-> ");
        }
        System.out.println();
    }
    
    //functon to get path from root to leaf
    public static void printroot2lef(Node root, ArrayList<Integer> path){
        if(root== null){
            return;
        }
        path.add(root.data);
        
        if(root.left==null && root.right==null){
            printpath(path);
        }else{
            printroot2lef(root.left, path);
            printroot2lef(root.right, path);
        }
        
        path.remove(path.size()-1);
        
    }
    
    //main function
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int val[]= {8,5,3,1,4,6,10,11,14};
        Node root= null;
        
        for(int i=0; i<val.length; i++){
            root= insert(val[i], root);
        }
        
        inorder(root);
        System.out.println();
        
        printroot2lef(root, new ArrayList<>());
        
    }
}
