package sort;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeSort {

	public static void main(String[] args) {
		int[] nums = {3,2,6,5,4,8,7,9,0,1};
		int[] result = mergeSort(nums, 0, nums.length-1);
		
		Stream.of(result).flatMapToInt(x -> Arrays.stream(x)).forEach(x -> System.out.print(x + ", "));
		System.out.println();
		Stream.of(nums).sorted().flatMapToInt(x -> Arrays.stream(x)).forEach(x -> System.out.print(x+ ","));
	}

	private static int[] mergeSort(int[] nums, int first, int last) {
		if(first < last){
			int mid = (first + last) / 2;
			mergeSort(nums, first, mid);
			mergeSort(nums, mid+1, last);
			merge(nums, first, mid, last);
		}
		
		return nums;
	}

	private static void merge(int[] arr, int first, int mid, int last) {
		 // Find sizes of two subarrays to be merged
        int size1 = mid - first + 1;
        int size2 = last - mid;
 
        /* Create temp arrays */
        int leftArray[] = new int [size1];
        int rightArray[] = new int [size2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<size1; ++i) leftArray[i] = arr[first + i];
        for (int j=0; j<size2; ++j) rightArray[j] = arr[mid + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int indexOfLeftArray = 0, indexOfRightArray = 0;
 
        // Initial index of merged subarry array
        int mergedArrayIndex = first;
        while (indexOfLeftArray < size1 && indexOfRightArray < size2)
        {
            if (leftArray[indexOfLeftArray] <= rightArray[indexOfRightArray])
            {
                arr[mergedArrayIndex] = leftArray[indexOfLeftArray];
                indexOfLeftArray++;
            }
            else
            {
                arr[mergedArrayIndex] = rightArray[indexOfRightArray];
                indexOfRightArray++;
            }
            mergedArrayIndex++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (indexOfLeftArray < size1)
        {
            arr[mergedArrayIndex] = leftArray[indexOfLeftArray];
            indexOfLeftArray++;
            mergedArrayIndex++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (indexOfRightArray < size2)
        {
            arr[mergedArrayIndex] = rightArray[indexOfRightArray];
            indexOfRightArray++;
            mergedArrayIndex++;
        }
	}
	
	
//	public static void main(String[] args) {
////		List<String> myList = Arrays.asList("a2", "a1", "b1", "c2", "c1");
////		myList.stream().filter(s->s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);
//		
////		Arrays.asList("a1", "b1", "c1").stream().findAny().ifPresent(System.out::println);
////		Stream.of("a1", "b1", "c1").findFirst().map(s -> s.toUpperCase()).filter(s->s.startsWith("b")).ifPresent(System.out::println);
////		IntStream.range(1,4).forEach(System.out::println);;
//		
//		Arrays.stream(new int[]{1,2,3,4}).map(n-> 2* n + 1).average().ifPresent(System.out::println);
//	}
}


/**

			myList
			    .stream()
			    .filter(s -> s.startsWith("c"))
			    .map(String::toUpperCase)
			    .sorted()
			    .forEach(System.out::println);
*/