public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Heap heap = new Heap(15);
		try {
			heap.buildHeap();
		} catch (Exception e) {
			System.err.println(e);
		}
		System.out.println("Unsorted:");
		System.out.println(heap);
		HeapNode[] sortedData = heap.heapSort();
		System.out.println("Sorted:");
		for (int i = 0; i < sortedData.length; i++) {
			
			System.out.print(sortedData[i]);
		}
	}
}
