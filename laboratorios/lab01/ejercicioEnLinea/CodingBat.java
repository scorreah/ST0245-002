
/**
 * Write a description of class CodingBat here.
 * 
 * @author David Gomez, Simon Correa
 * @version 23/08/2020
 */
public class CodingBat
{
    //Recursion 1
    public int triangle(int rows) {
        if(rows==0)
            return 0;                 //c_1 = 3
        return rows+triangle(rows-1); //c_2 = 3
        //T(n) = T(n-1) + c_2

    }

    public int fibonacci(int n) {
        if(n==0)
            return 0; //c_1 = 3

        if(n==1)
            return 1; //c_2 = 3

        return fibonacci(n-1)+fibonacci(n-2); //c_3 = 4
        //T(n) = c_3 + T(n-1) + T(n-2)

    }

    public int countHi(String str) {
        int cont=0;
        if(str.length()<=2) {
            if(str.substring(0,str.length()).equalsIgnoreCase("hi")){
                return cont=1;          //c_1 = 6
            }else{
                return 0;               //c_2 = 4
            }
        }else{
            if(str.substring(0,2).equalsIgnoreCase("hi")){
                cont=1;                 //c_3 = 4
            }
        }
        return cont+countHi(str.substring(1,str.length())); //c_4 = 2
        //T(n) = c_4 + T(n-1)
    }

    public int powerN(int base, int n) {
        if (n==1)
            return base;        //c_1 = 3

        return base*powerN(base, n-1);      //c_2 = 3
        //T(n) = c_2 + T(n-1)
    }

    public String endX(String str) {
        return endXAux(str, 0);
    }

    public String endXAux(String str, int index) {
        if(index == str.length())
            return str;             //c_1 = 3
        if (str.charAt(index) == 'x')   //c_2 = 5
            return endXAux(str.replaceFirst("x", "") + "x", index+1);
                                   //T(n) = c_2 + T(n-1)
        return endXAux(str, index+1);
    }
    
    
    //Recursion2
    public boolean groupSum5(int start, int[] nums, int target) {

        return groupSum5Aux(nums,start,target);

    }

    public boolean groupSum5Aux(int[] nums, int prefix, int target){
        if(prefix>=nums.length)return target==0;            //c_1 = 4

        if(nums[prefix]%5==0&&prefix+1<nums.length){

            if(nums[prefix+1]==1)
                return groupSum5Aux(nums, prefix+2, target-nums[prefix]); //c_2 = 15

            return groupSum5Aux(nums, prefix+1, target-nums[prefix]); //c_3 = 11

        }

        return groupSum5Aux(nums, prefix+1, target-nums[prefix])||            //c_4 = 6
        groupSum5Aux(nums, prefix+1, target);                                 //T(n) = c_4 + 2T(n-1)

    }

    public boolean groupSum6(int start, int[] nums, int target) {

        return groupSum6Aux(nums, 0, target);

    }

    public boolean groupSum6Aux(int[] nums, int prefix, int target){
        if(prefix>=nums.length)
            return target==0;           //c_1 = 4

        if(nums[prefix]==6)             //c_2 = 7
            return groupSum6Aux(nums, prefix+1, target-nums[prefix]);
        //T(n) = c_2 + T(n-1)

        return groupSum6Aux(nums, prefix+1, target-nums[prefix])||
        groupSum6Aux(nums,prefix+1, target); //c_3 = 6
        //T(n) = c_3 + 2T(n-1)
    }

    public boolean splitArray(int[] nums) { 
        return splitAux(nums, 0, 0,0); 
    } 

    public boolean splitAux(int[] nums, int prefix, int sum1, int sum2){ 
        if(prefix==nums.length)
            return sum1==sum2; //c_1 = 4

        return splitAux(nums, prefix+1, sum1, sum2+nums[prefix])|| 
        splitAux(nums, prefix+1, sum1+nums[prefix], sum2); //c_2 = 7
        //T(n) = c_2 + 2T(n-1)
    }

    public boolean split53(int[] nums) { 
        return split53Aux(nums, 0, 0,0); 
    }  

    public boolean split53Aux(int[] nums, int prefix, int sum1, int sum2){ 
        if(prefix==nums.length)
            return sum1==sum2; //c_1 = 4

        if(nums[prefix]%5==0){ //c_2 = 8
            return splitAux(nums, prefix+1, sum1, sum2+nums[prefix]); 
            //T(n) = c_2 + T(n-1)
        } else if(nums[prefix]%3==0){ //c_3 = 8
            return splitAux(nums, prefix+1, sum1+nums[prefix], sum2);
            //T(n) = c_3 + T(n-1)
        } 
        return splitAux(nums, prefix+1, sum1, sum2+nums[prefix])|| 
        splitAux(nums, prefix+1, sum1+nums[prefix], sum2); //c_4 = 7
        //T(n) = c_4 + 2T(n-1)
    }

    public boolean groupNoAdj(int start, int[] nums, int target) {
        return groupNoAdjAux(nums,0,target);
    }

    public boolean groupNoAdjAux(int[] nums, int prefix, int target){
        if(prefix>=nums.length){
            return target==0;           //c_1 = 4
        }else{
            return groupNoAdjAux(nums, prefix+2,target-nums[prefix])||
            groupNoAdjAux(nums,prefix+1,target);  //c_2 = 6
            //T(n) = c_2 + T(n-1) + T(n-2)
        }

    }
}
