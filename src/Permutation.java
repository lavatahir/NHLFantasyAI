import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Java program to print all combination of size r in an array of size n
 
class Permutation {
 
	public void subset(int[] A, int k, int start, int currLen, boolean[] used) {

		if (currLen == k) {
			for (int i = 0; i < A.length; i++) {
				if (used[i] == true) {
					System.out.print(A[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		if (start == A.length) {
			return;
		}
		// For every index we have two options,
		// 1.. Either we select it, means put true in used[] and make currLen+1
		used[start] = true;
		subset(A, k, start + 1, currLen + 1, used);
		// 2.. OR we dont select it, means put false in used[] and dont increase
		// currLen
		used[start] = false;
		subset(A, k, start + 1, currLen, used);
	}
	static <T> List<List<T>> chopped(List<T> list, final int L) {
	    List<List<T>> parts = new ArrayList<List<T>>();
	    final int N = list.size();
	    for (int i = 0; i < N; i += L) {
	        parts.add(new ArrayList<T>(
	            list.subList(i, Math.min(N, i + L)))
	        );
	    }
	    return parts;
	}


	
	public static void main(String[] args) {
		/*int A[] = { 1, 2, 3, 4, 5 };
		boolean[] B = new boolean[A.length];
		Permutation i = new Permutation();
		i.subset(A, 3, 0, 0, B);
		*/
		RosterGenerator rg = new RosterGenerator();
		ArrayList<Forward> forwards = rg.getForwards();
		
		List<Integer> numbers = Collections.unmodifiableList(
			    Arrays.asList(5,3,1,2,9,5,0,7)
			);
			List<List<Forward>> parts = chopped(forwards, 3);
			System.out.println(parts); // prints "[[5, 3, 1], [2, 9, 5], [0, 7]]"
			
			System.out.println(parts); // prints "[[5, 3, 1, -1], [2, 9, 5], [0, 7]]"
			System.out.println(numbers); // prints "[5, 3, 1, 2, 9, 5, 0, 7]" (unmodified!)

	}
}
 
/* This code is contributed by Devesh Agrawal */