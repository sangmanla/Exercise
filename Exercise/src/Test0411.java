import java.util.Arrays;
import java.util.stream.Stream;

public class Test0411 {

	public static void main(String[] args) {
		int[] nums = {3,2,6,5,4,8,7,9,0,1};
		int[] result = mergeSort(nums, 0, nums.length-1);
		
		Stream.of(result).flatMapToInt(x -> Arrays.stream(x)).forEach(x -> System.out.println(x));
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

	private static void merge(int[] arr, int l, int m, int r) {
		 // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
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