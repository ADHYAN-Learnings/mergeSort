package mergeSort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSort {

	public static void main(String[] args) {
		int[] array_list = {2, 4, 6, 8, 9, 7, 5, 3, 1};
		int length = array_list.length;
		Sort sort = new Sort();
		
		System.out.println("Before Sorting array values are:-");
		Arrays.stream(array_list).forEach(data->System.out.print(data+" "));
		
		sort.mergeSort(array_list,0,length-1);
		
        System.out.println("\nAfter Sorting array values are:-");
		Arrays.stream(array_list).forEach(data->System.out.print(data+" "));

	}
}

class Sort {

	public void mergeSort(int[] array_list, int beginning, int end) {
		if(beginning < end) {
		  int middle = (beginning+end)/2;	
		  mergeSort(array_list,beginning,middle);
		  mergeSort(array_list, middle+1, end);
		  merge(array_list,beginning,middle,end);		
		}
		
	}

	private void merge(int[] array_list, int beginning, int middle, int end) {
		int n1 = middle - beginning +1;
		int n2 = end - middle;
		
		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];
		
		IntStream.range(0, n1).forEach(i->leftArray[i]=array_list[beginning+i]);
		IntStream.range(0, n2).forEach(j->rightArray[j]=array_list[middle+1+j]);
		
		int i=0;
		int j=0;
		int k=beginning;
		
		for(k=beginning;i<n1 && j<n2;k++) {
			array_list[k]=leftArray[i]<=rightArray[j]?leftArray[i++]:rightArray[j++];
		}
		
		for(;i<n1;k++) {
		   array_list[k]=leftArray[i++];	
		}
		
        for(;j<n2;k++) {
        	array_list[k]=rightArray[j++];
		}
	}
	
}
