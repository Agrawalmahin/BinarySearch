// Java program for the Search insert position of K in a sorted array
import java.io.*;

class GFG{

// Function to find insert position of K
static int find_index(int[] arr, int n, int K)
{
	
	// Lower and upper bounds
	int start = 0;
	int end = n - 1;

	// Traverse the search space
	while (start <= end)
	{
		int mid = (start + end) / 2;

		// If K is found
		if (arr[mid] == K)
			return mid;

		else if (arr[mid] < K)
			start = mid + 1;

		else
			end = mid - 1;
	}

	// Return insert position
	return end + 1;
}

// Driver Code
public static void main(String[] args)
{
	int[] arr = { 1, 3, 5, 6 };
	int n = arr.length;
	int K = 2;
	
	System.out.println(find_index(arr, n, K));
}
}


