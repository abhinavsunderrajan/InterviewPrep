package sorting;

import java.util.Arrays;

/**
 * Create a max heap and then start 'deleting elements' which results in a
 * sorted heap.
 * 
 * @author 746310
 *
 */
public class HeapSort {

    public static void main(String[] args) {
	int arr[] = { 4, 1, 3, 9, 7 };

	int n = arr.length - 1;
	for (int i = n; i >= 0; i--) {
	    heapify(arr, i, n);
	}
	System.out.println("heapify");
	System.out.println(Arrays.toString(arr));
	System.out.println("Now delete");

	// Now delete elements one by one and add to the last index

	int count = 0;
	for (int i = n; i > 0; i--) {
	    int temp = arr[0];
	    arr[0] = arr[i];
	    arr[i] = temp;
	    deleteRoot(arr, 0, n - count);
	    System.out.println(Arrays.toString(arr));
	    count++;

	}

    }

    /**
     * Delete the first element one by one and add the last element to the last
     * index of the heap. Note that size decrements every iteration. Make it a heap
     * structure once again.
     * 
     * @param a
     * @param parent
     * @param size
     */
    private static void deleteRoot(int[] a, int parent, int size) {
	int lChild = 2 * parent + 1;
	int rChild = 2 * parent + 2;
	int child = -1;
	if (lChild < size)
	    child = lChild;
	if (rChild < size && a[rChild] > a[lChild])
	    child = rChild;
	if (child != -1 && a[parent] < a[child]) {
	    int temp = a[parent];
	    a[parent] = a[child];
	    a[child] = temp;
	    deleteRoot(a, child, size);
	}

    }

    /**
     * Heapify creates a max heap out of the array. It is a bottom up approach. O(n)
     * 
     * @param arr
     * @param parent
     * @param n
     */
    public static void heapify(int arr[], int parent, int n) {

	int lchild = 2 * parent + 1;
	int rchild = 2 * parent + 2;
	if (parent < 0)
	    return;

	if (lchild > n && rchild > n)
	    return;
	int child = -1;
	// your choosing which among the left and right children are greater than the
	// parent.
	if (lchild <= n && arr[parent] < arr[lchild]) {
	    child = lchild;
	}
	if (rchild <= n && arr[rchild] > arr[lchild]) {
	    child = rchild;
	}

	if (child != -1 && arr[parent] < arr[child]) {
	    int temp = arr[parent];
	    arr[parent] = arr[child];
	    arr[child] = temp;
	}

	heapify(arr, child, n);

    }

}
