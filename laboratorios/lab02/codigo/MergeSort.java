
/**

 * Write a description of class merge here.

 *

 * @author Simon Correa, David Gomez

 * @version 2020/09/06

 */

public class MergeSort

{

    // public merge1(){

        // int s =0;

    // }

    public int[] sort(int arr[], int left, int right){
        if(left < right){
            
            int middle = (left + right) / 2;

            sort(arr, left, middle);            
            sort(arr, middle+1, right);         

            merge(arr, left, middle, right);    
                                                 
        }
        return arr;
    }

    public int[] merge(int arr[], int left, int middle, int right) {
        
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int leftArray[] = new int [n1];
        int rightArray[] = new int [n2];

        for (int i=0; i < n1; i++) {
            leftArray[i] = arr[left+i];
        }
        for (int j=0; j < n2; j++) {
            rightArray[j] = arr[middle + j + 1];
        }

        int i = 0, j = 0;

        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
        return arr;
    }
}
