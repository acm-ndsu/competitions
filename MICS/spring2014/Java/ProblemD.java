import java.util.ArrayList;
import java.util.Scanner;


public class ProblemD {
	
	public static class BST{
		ArrayList<Node> searchQueue = new ArrayList<Node>();
		Node root;
		public BST(){
			 root = null;
		}
		public int insert(Node insertNode){
			if(root == null){
				insertNode.index = 0;
				root = insertNode;
				
			} else {
				insertAfter(insertNode, root);
			}
			return insertNode.index;
		}
		
		public void insertAfter(Node insertNode, Node afterNode){
			if(insertNode.value < afterNode.value){
				if(afterNode.leftChild == null){
					afterNode.leftChild = insertNode;
					insertNode.index = 2*afterNode.index +1;
				} else {
					insertAfter(insertNode, afterNode.leftChild);
				}
			} else if(insertNode.value > afterNode.value){
				if(afterNode.rightChild == null){
					afterNode.rightChild = insertNode;
					insertNode.index = 2*afterNode.index +2;
				} else {
					insertAfter(insertNode, afterNode.rightChild);
				}
			}
		}
		
		public void print(){
			print(root);
		}
		
		public void initBFS(){
			searchQueue.add(root);
			BFS();
		}
		
		private void BFS(){
			if(searchQueue.isEmpty()){
				return;
			} else {
				Node node = searchQueue.get(0);
				if(node.leftChild != null){
					searchQueue.add(node.leftChild);
				} 
				
				if(node.rightChild != null){
					searchQueue.add(node.rightChild);
				}
				
				// Process current node
				System.out.println(node);
				searchQueue.remove(node); // processed
				BFS();
			}
		}
		public void print(Node node){
			if(node.leftChild == null){
				
			}
		}
		
	}
	public static class Node{
		public Node(int value){
			this.value = value;
			leftChild = rightChild = null;
		}
		int value;
		int index;
		Node leftChild;
		Node rightChild;
		
		public String toString(){
			return this.index + " " + this.value;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		BST bst = new BST();
		int max = -1;
		int count = 0;
		while(scan.hasNext()){
			int num = scan.nextInt();
			if(num == 0){
				count++;
				// bst.initBFS(); // prints the list out
				System.out.println("BST " + count + " has a maximum index of " + max);
				
				if(scan.hasNext("0")){
					break;
				}
				max = -1;
				bst = new BST();
			} else{
				Node newNode = new Node(num);
				if(max < bst.insert(newNode)){
					max = bst.insert(newNode);
				}
			}
		}
		
	}

}
