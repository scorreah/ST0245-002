
/**
 * Write a description of class Array2 here.
 * 
 * @author David Gomez, Simon Correa
 * @version 2020/08/29
 */
public class Array2
{
    public int centeredAverage(int[] nums) {
        int n = nums.length;
        int pos_menor, temp;
        int promedio = 0;
        int cont = 0;
        for (int i = 0; i < n - 1; i++) {
            pos_menor = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[pos_menor]){
                    pos_menor = j;
                }
            }
            temp = nums[i];
            nums[i] = nums[pos_menor];
            nums[pos_menor] = temp;
        }
        for (int i = 1; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1] && i +1 < nums.length-1){
                continue;
            }else{
                promedio = promedio + nums[i];
                cont++;
            }
        }
        return promedio/cont;
    }

    public int[] fizzArray(int n) {
        int[] nums= new int[n];
        for(int i=0; i<nums.length;i++){
            nums[i]=i;
        }
        return nums;
    }

    public int[] shiftLeft(int[] nums) {
        if(nums.length == 0)return nums;
        int num2[] = new int[nums.length];
        int temp = nums[0];
        int cont = 0;
        for(int i = 1;i< nums.length; i++){
            num2[cont] = nums[i];
            cont++;
        }
        num2[cont] = temp;
        return num2;
    }

    public boolean haveThree(int[] nums) {
        int cont = 0;
        if(nums.length == 0)return false;
        if(nums[0] == 3)cont++;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == 3 && i + 1 <= nums.length && nums[i] != nums[i-1]){
                cont++;
            }
        }
        return cont == 3;
    }

    public int[] zeroMax(int[] nums) {
        for(int i=0; i< nums.length; i++){
            if(nums[i] == 0){
                int x = 0;
                for(int j = i+1; j < nums.length; j++){
                    if(nums[j]%2!=0 && nums[j] > x){
                        x=nums[j];
                    }
                }
                nums[i] = x;
            }
        }
        return nums;
    }
}
