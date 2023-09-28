import java.util.Scanner;
import java.io.*;
public class Heap {

	//data
	
	HeapNode[] data;
	HeapNode head;
	int manyNodes = 0;
	
	// constructor
	
	Heap (int size) {
		
		data = new HeapNode[size];
	}
	
	// balances node that is added to heap
	
	public void balanceChildNode(HeapNode node) {
		
		//finds index of node and parent node
		// also returns if node is head
		
		int index = -1;
		int parentIndex = -1;
		for (int i = 0; i > data.length; i++) {
			
			if (data[i] == null) {
				
				i = data.length;
			} else if (data[i].equals(node)) {
				
				index = i;
				i = data.length;
			}
			if (index == -1) {
				
				System.out.println("node not found");
				return;
			} else if (index != 0) {
				
				parentIndex = ((index - 1)/2);
			} if (parentIndex == -1) {
				
				return;
			}
			
			// checks if node is balanced and if not balances node
			
			if (data[index].greaterThan(data[parentIndex])) {
				
				boolean left = false;
				if (data[(parentIndex*2)+1].data == data[index].data) {
					
					left = true;
				}
				if (parentIndex == 0) {
					
					head = node;
					HeapNode tempLeft = node.leftChild;
					HeapNode tempRight = node.rightChild;
					if (left) {
						
						node.setLeft(data[parentIndex]);
						node.setRight(data[parentIndex].rightChild);
					} else {
						
						node.setLeft(data[parentIndex].leftChild);
						node.setRight(data[parentIndex]);
					}
					data[parentIndex].setLeft(tempLeft);
					data[parentIndex].setRight(tempRight);
					data[index] = data[parentIndex];
					data[parentIndex] = node;
					return;
				}
				
				int grandparentIndex = (parentIndex-1)/2;
				boolean left2 = false;
				if (data[(2*grandparentIndex)+1].data == data[parentIndex].data) {
					
					left2 = true;
				}
				
				if (left2) {
					
					data[grandparentIndex].setLeft(node);
				} else {
					
					data[grandparentIndex].setRight(node);
				}
				HeapNode tempLeft = node.leftChild;
				HeapNode tempRight = node.rightChild;
				if (left) {
					
					node.setLeft(data[parentIndex]);
					node.setRight(data[parentIndex].rightChild);
				} else {
					
					node.setLeft(data[parentIndex].leftChild);
					node.setRight(data[parentIndex]);
				}
				data[parentIndex].setLeft(tempLeft);
				data[parentIndex].setRight(tempRight);
				data[index] = data[parentIndex];
				data[parentIndex] = node;
				this.balanceChildNode(data[parentIndex]);
			}
		}
	}
	
	//adds node to heap
	
	public void addNode(HeapNode node) {
		
		if (head == null) {
			
			head = node;
			data[manyNodes] = head;
			manyNodes++;
		} else {
			
			data[manyNodes] = node;
			int index = (manyNodes - 1)/2;
			HeapNode parent = data[index];
			if (data[(index*2)+1] == null) {
				
				parent.setLeft(node);
			} else {
				
				parent.setRight(node);
			}
			manyNodes++;
			this.balanceChildNode(node);
		}
	}
	
	// balances node for removal
	
	public void balanceParentNode(HeapNode node) {
		
		int leftData;
		int rightData;
		if (manyNodes <= 1) {
			
			return;
		}
		if (node.leftChild != null) {
			leftData = node.leftChild.data;
		} else {
			leftData = -1;
		}
		if (node.rightChild != null) {
			rightData = node.rightChild.data;
		} else {
			rightData = -1;
		}
		if (leftData > rightData) {
			
			if (leftData > node.data) {
				
				int index = -1;
				HeapNode tempLeft = node.leftChild.leftChild;
				HeapNode tempRight = node.leftChild.rightChild;
				for (int i = 0; i < data.length; i ++) {
					
					if (data[i] == node) {
						
						index = i;
						i = data.length;
					} else if (data[i] == null) {
						
						i = data.length;
					}
					if (index == -1){
						
						System.out.println("node not found");
						return;
					} else if (index == 0) {
						
						head = node.leftChild;
						head.setLeft(node);
						head.setRight(node.rightChild);
					} else {
						
						int parentIndex = (index-1)/2;
						boolean left = false;
						if (data[(parentIndex*2)+1] == node) {
							
							left = true;
						}
						if (left) {
							
							data[parentIndex].setLeft(node.leftChild);
							node.leftChild.setLeft(node);
							node.leftChild.setRight(node.rightChild);
						} else {
							
							data[parentIndex].setRight(node.leftChild);
							node.leftChild.setLeft(node);
							node.leftChild.setRight(node.rightChild);
						}
					}
				}
				node.setLeft(tempLeft);
				node.setRight(tempRight);
				data[index] = data[(index*2)+1];
				data[(index*2)+1] = node;
				this.balanceParentNode(node);
				return;
			}
		} else if (leftData <= rightData) {
			
			if (rightData == -1) {
				return;
			}
			int index = -1;
			HeapNode tempLeft = node.rightChild.leftChild;
			HeapNode tempRight = node.rightChild.rightChild;
			for (int i = 0; i < data.length; i ++) {
				
				if (data[i] == node) {
					
					index = i;
					i = data.length;
				} else if (data[i] == null) {
					
					i = data.length;
				}
				if (index == -1){
					
					System.out.println("node not found");
					return;
				} else if (index == 0) {
					
					head = node.leftChild;
					head.setLeft(node.leftChild);
					head.setRight(node);
				} else {
					
					int parentIndex = (index-1)/2;
					boolean left = false;
					if (data[(parentIndex*2)+1] == node) {
						
						left = true;
					}
					if (left) {
						
						data[parentIndex].setLeft(node.rightChild);
						node.rightChild.setLeft(node.leftChild);
						node.rightChild.setRight(node);
					} else {
						
						data[parentIndex].setRight(node.rightChild);
						node.rightChild.setLeft(node.leftChild);
						node.rightChild.setRight(node);
					}
				}
			}
			node.setLeft(tempLeft);
			node.setRight(tempRight);
			data[index] = data[(index*2)+2];
			data[(index*2)+2] = node;
			this.balanceParentNode(node);
			return;
			
		}
	}
	
	// removes the largest node from heap
	
	public HeapNode removeGreatest() {
		
		if (manyNodes == 0) {
			
			System.out.println("Heap is empty");
			return null;
		} else if (manyNodes == 1) {
			
			HeapNode node = head;
			head = null;
			manyNodes--;
			return node;
		}
		HeapNode node = head;
		HeapNode tempLeft = head.leftChild;
		HeapNode tempRight = head.rightChild;
		head = data[manyNodes - 1];
		head.setLeft(tempLeft);
		head.setRight(tempRight);
		boolean left = false;
		HeapNode parent = data[((manyNodes-1)-1)/2];
		if (parent.leftChild == data[manyNodes-1]) {
			
			left = true;
		}
		if (left) {
			
			parent.setLeft(null);
		} else {
			
			parent.setRight(null);
		}
		manyNodes--;
		this.balanceParentNode(head);
		return node;
	}
	
	// constructs Heap from numbers in text file
	
	public void buildHeap() throws FileNotFoundException {
		
		File file = new File ("src/Data.txt");
		Scanner read = new Scanner(file);
		head = null;
		manyNodes = 0;
		data = new HeapNode[read.nextInt()];
		for (int i = 0; i < data.length; i++) {
			
			data[i] = new HeapNode(read.nextInt());
			if (i == 0) {
				
				head = data[i];
				manyNodes++;
			} else {
				
				int parentIndex = (i-1)/2;
				if (data[i] == data[(parentIndex*2)+1]) {
					
					data[parentIndex].setLeft(data[i]);
				} else {
					
					data[parentIndex].setRight(data[i]);
				}
				manyNodes++;
			}
		}
		read.close();
		int nodesToBalance = ((manyNodes-1)-1)/2;
		for (int i = nodesToBalance; i > -1; i--) {
			
			this.balanceParentNode(data[i]);
		}
	}
	
	// sorts nodes from greatest to least and returns array
	
	public HeapNode[] heapSort() {
		
		HeapNode[] sortedData = new HeapNode[data.length];
		for (int i = 0; i < sortedData.length; i++) {
			
			if (manyNodes == 0) { 
				i = sortedData.length;
			} else {
				sortedData[i] = this.removeGreatest();
			}
		}
		return sortedData;
	}
	
	public String toString() {
		
		String str = "";
		for (int i = 0; i < data.length; i++) {
			
			str += data[i].toString();
		}
		return str;
	}
}