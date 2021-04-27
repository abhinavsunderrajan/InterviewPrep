package math;

public class FindNumberAppearOnceSortedArray {

    public static void main(String[] args) {
	int arr[] = { 1, 1, 2, 2, 3 };
	int i = 0;
	int j = 1;
	while (j < arr.length) {
	    int xor = arr[i] ^ arr[j];
	    if (xor != 0) {
		System.out.println(arr[i] + " is the distinct element");
		break;
	    }
	    i = i + 2;
	    j = j + 2;
	}

	if (arr.length % 2 == 1 && i == arr.length - 1) {
	    System.out.println(arr[i] + " is the distinct element");
	}

    }

}
