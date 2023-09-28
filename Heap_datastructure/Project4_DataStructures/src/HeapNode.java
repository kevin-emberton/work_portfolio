public class HeapNode {
	
	//data
	
	HeapNode leftChild = null;
	HeapNode rightChild = null;
	int data;
	
	//constructors
	
	HeapNode (int data) {
		
		this.data = data;
	}
	
	HeapNode(HeapNode node) {
		this.leftChild = node.leftChild;
		this.rightChild = node.rightChild;
		this.data = node.data;
	}
	
	//setters
	
	public void setLeft(HeapNode node) {
		
		leftChild = node;
	}
	
	public void setRight(HeapNode node) {
		
		rightChild = node;
	}
	
	// accessors
	
	public int getData() {
		
		return data;
	}
	
	// to String
	
	public String toString() {
		
		String str = String.format("%d\n", data);
		return str;
	}
	
	// checks if node is greater than another node
	
	public boolean greaterThan(HeapNode node) {
		
		if (this.data > node.data) {
			
			return true;
		} else {
			
			return false;
		}
	}
 }