

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeDup {

	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34,
			86, 25, 43, 2, 1, 10000, 11, 16, 19, 1, 18, 4, 9, 3, 20, 17, 8, 15,
			6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17,
			16, 3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17,
			10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	public static void main(String[] args) {
		DeDup deDup = new DeDup();
		deDup.dedupByList();
		deDup.dedupByArray();
	}

	/**
	 * deduping the integers by list
	 * maintaining the order
	 */
	public void dedupByList() {
		List<Integer> dedupNumbers = new ArrayList<Integer>();

		for (int i : randomIntegers) {

			if (!dedupNumbers.contains(i)) {
				dedupNumbers.add(i);
			}
		}
		System.out.println("Printing distinct numbers : ");
		System.out.println("Filtered by List");
		System.out.println(dedupNumbers);
	}
	
	/**
	 * deduping integers by using temporary array
	 * need to sort the array first since I am using temp array, then iterate it to compare
	 */
	public void dedupByArray(){
		
		Arrays.sort(randomIntegers);
		int[] dedupNumbers = new int[randomIntegers.length];
		int previousNumber = randomIntegers[0];
		dedupNumbers[0] = previousNumber;

		//total dedup integers count
		int count = 0;
		for(int i=1;i<randomIntegers.length;i++){
			
			int currentNumber = randomIntegers[i];
			
			if(previousNumber!=currentNumber){
				dedupNumbers[count++] = currentNumber;
			}
			previousNumber = currentNumber;
			
		}
		
		int[] finalArray = Arrays.copyOf(dedupNumbers, count);
		
		System.out.println("Printing distinct numbers : ");
		System.out.println("Filtered by Array");
		
		for(int k=0;k<finalArray.length;k++){
			System.out.println(finalArray[k]);
		}
		
	}

}
