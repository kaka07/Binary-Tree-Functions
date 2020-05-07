import java.util.*;
import java.io.*;
import java.lang.*;
class create{
	static class Node{
		int value;
		Node left,right;

		Node(int value){
			this.value=value;
			left=null;
			right=null;
		}
	}
		static void insert(Node node,int value){
			if(value<node.value){
				if(node.left!=null){
					insert(node.left,value);
				}
				else{
					System.out.println("Inserted "+ value+" to left of "+node.value);
					node.left=new Node(value);
				}
			}
			else
				if(value>node.value){
					if(node.right!=null){
						insert(node.right,value);
					}
					else{
						System.out.println("Inserted "+ value+" to right of "+node.value);
						node.right=new Node(value);
					}
				}
		}
		static void traverseInOrder(Node node){
			if(node!=null){
				traverseInOrder(node.left);
				System.out.print(node.value+" ");
				traverseInOrder(node.right);
			}
		}

		static void traversePreOrder(Node node){
			if(node!=null){
				System.out.print(node.value+" ");
				traversePreOrder(node.left);
				traversePreOrder(node.right);
			}
		}

		static void traversePostOrder(Node node){
			if(node!=null){
				traversePreOrder(node.left);
				traversePreOrder(node.right);
				System.out.print(node.value+" ");
			}
		}

		static void traverseLevelOrder(Node root){
			int h=heightOfTree(root);
			for(int i=1;i<=h;i++){
				printGivenLevel(root,i);
			}
		}

		static void traverseReverseLevelOrder(Node root){
			int h=heightOfTree(root);
			for(int i=h;i>=1;i--){
				printGivenLevel(root,i);
			}
		}

		static void printGivenLevel(Node root,int level){
			if(root==null)
				return;
			if(level==1)
				System.out.print(root.value+" ");
			else 
				if(level>1){
					printGivenLevel(root.left,level-1);
					printGivenLevel(root.right,level-1);
				}
		}

		static int heightOfTree(Node root){
			if(root==null) return 0;
			else{
				int lheight=heightOfTree(root.left);
				int rheight=heightOfTree(root.right);
				if(lheight>rheight) return (lheight+1);
				else return (rheight+1);
			}

		}
		static boolean isTrue=false;

		static void searchValue(Node root,int key){
			if(root==null) System.out.println("Tree is Empty");
			if(root.value==key){
				isTrue=true;
			}
			else{
				if(!isTrue&&root.left!=null){
					searchValue(root.left,key);
				}
				if(!isTrue&&root.right!=null){
					searchValue(root.right,key);
				}
			}

		}
		
		static Node mirrorOfTree(Node root){
			if(root==null) return root;
			else{
				Node l=mirrorOfTree(root.left);
				Node r=mirrorOfTree(root.right);
				root.left=r;
				root.right=l;
			}
			return root;
		}

		static boolean isBalanced(Node root){
			if(root==null)
				return true;
				int lheight=heightOfTree(root.left);
				int rheight=heightOfTree(root.right);
			if((Math.abs(lheight-rheight)<=1)&&isBalanced(root.left)&&isBalanced(root.right))
				return true;
			return false;
		}
		//static int max=Integer.MIN_VALUE;

		//static int min=Integer.MAX_VALUE;

		static int maxValue(Node root){
			if(root==null)
				return Integer.MIN_VALUE;
			int max=root.value;
			int l=maxValue(root.left);
			int r=maxValue(root.right);
			if(l>max)
				max=l;
			else if(r>max)
				max=r;
			return max;
		}
		static int minValue(Node root){
			if(root==null)
				return Integer.MAX_VALUE;
			int min=root.value;
			int l=minValue(root.left);
			int r=minValue(root.right);
			if(l<min)
				min=l;
			else if(r<min)
				min=r;
			return min;

		}

		public static void main(String[] args) {
			create cr=new create(); 
			 Node root = new Node(4);
                System.out.println("Binary Tree Example");
                System.out.println("Building tree with root value " + root.value);
                cr.insert(root, 2);
                cr.insert(root, 3);
                cr.insert(root, 1);
                cr.insert(root, 5);
                System.out.println("Traversing tree in order");
                cr.traverseInOrder(root);
                System.out.println();
                System.out.println("Traversing tree pre order");
                cr.traversePreOrder(root);
                System.out.println();
                System.out.println("Traversing tree post order");
                cr.traversePostOrder(root);
                System.out.println();
                System.out.println("Traversing tree level order");
                cr.traverseLevelOrder(root);
                System.out.println();
                System.out.println("Traversing tree reverse level order");
                cr.traverseReverseLevelOrder(root);
                System.out.println();
                Scanner in=new Scanner(System.in);
                int key=in.nextInt();
               
                searchValue(root,key);
                if(isTrue){
                	System.out.println("Yes, The element is present");
                }
                else{
                	System.out.println("No, The element is not present");
                }
                cr.mirrorOfTree(root);
                cr.traverseInOrder(root);
                System.out.println();
                if(cr.isBalanced(root)){
                	System.out.println("The tree is balanced");
                }
                else
                	System.out.println("The tree is not balanced");
               	System.out.println(cr.minValue(root));
               	System.out.println(cr.maxValue(root));
		}
	}
