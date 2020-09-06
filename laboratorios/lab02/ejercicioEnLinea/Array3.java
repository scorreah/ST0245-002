
/**
 * 5 ejercicios resueltos de Codingbat: Array3
 * 
 * @author Simon Correa, David Gomez
 * @version 2020/09/06
 */
public class Array3
{
    public int[] seriesUp(int n) {
        int cont =0;
        int y = 0;                            //c_1
        if(n%2==0){
            y = (n/2)*(n+1);                  //c_2
        }else{
            y=((n+1)/2)*n;                    //c_3
        }
        int[] nums = new int[y];
        for(int i = 1; i<=n;i++){             //c_4+(c_5)*n
            for(int j = 1; j<= i; j++){       //(c_6+(c_7*n))*n
                nums[cont] = j;
                cont= cont+1;
            }
        }
        return nums;                          //c_8
    }                                         //T(n): c_1+c_2+c_3+c_4+(c_5)*n+(c_6+(c_7*n))*n+c_8

    public int[] fix34(int[] nums) {
        int index = 0;
        for(int i = 0; i<nums.length;i++){                 //c_1+(c_2*n)
            if(nums[i]==3){
                for(int j = index; j<nums.length; j++){    //(c_3+(c_4*n))*n
                    if(nums[j]==4){
                        int temp = nums[i+1];
                        nums[i+1]=4;
                        nums[j]= temp;
                        index=j;
                        break;                             //(c_5*n)*n
                    }
                }
            }
        }
        return nums;                                    //c_6
    }                                                   //T(n)=c_1+(c_2*n)+(c_3+(c_4*n))*n+(c_5*n)*n+c_6

    public boolean linearIn(int[] outer, int[] inner) {
        int cont = 0;
        boolean res = false;                             //c_1
        if(inner.length == 0) return true;               //c_2
        for(int i = 0; i < inner.length; i++){           //c_3+(c_4*n)
            for(int j = 0; j < outer.length; j++){       //(c_5+(c_6*n))*n
                if(inner[i] == outer[j]){
                    cont++;
                    break;                               //(c_7*n)*n
                }
            }
            if(cont == inner.length){
                res = true;                              //c_8*n
            }
        }
        return res;                                      //c_9
    }                                                    //T(n)=c_1+c_2+c_3+(c_4*n)+(c_5+(c_6*n))*n+(c_7*n)*n+c_8*n+c_9

    public int countClumps(int[] nums) {
        int clumps = 0;
        boolean next = true;
        for (int i=0; i < nums.length-1; i++ ) {         //c_1+(c_2*n)
            if(nums[i] == nums[i+1] && next) {
                clumps++;
                next = false;                            //c_3*n
            } else if(nums[i] != nums[i+1]) {
                next = true;                             //c_4*n
            }
        }
        return clumps;                                   //c_5
    }                                                    //T(n)=c_1+(c_2*n)+c_3*n+c_4*n+c_5
    
    public int maxMirror(int[] nums) {
        int[] updown = new int[nums.length];
        int n = 0;
        for (int i = nums.length-1; i >= 0; i--) {          //c_1+(c_2*n)
            updown[n] = nums[i];
            n++;
        }
        boolean next = false;
        int temp = 0;
        int cont = 0;
        for (int j = 0; j < nums.length; j++) {             //c_3+(c_4*n)
            int z = j;
            for (int k = 0; k < nums.length ; k++) {        //(c_5+(c_6*n))*n

                if (nums[z] == updown[k] && cont == 0) {
                    cont++;
                    next = true;                            //(c_7*n)*n
                }else if (next && nums[z] == updown[k]) {
                    cont++;                                 //(c_8*n)*n
                } else if(nums[z] != updown[k] && next) {
                    next = false;                           //(c_9*n)*n
                    if (cont > temp) temp = cont;
                    cont = 0;                               //(c_10*n)*n
                    //break; 
                }

                if (z+1 < nums.length && next)  z++;        //(c_11*n)*n
            }
            if (cont > temp) temp = cont;                   
            cont = 0;                                       //c_12*n
        }

        return temp;                                        //c_13
    }
}                                                           //T(n)=c_1+(c_2*n)+c_3+(c_4*n)+(c_5+(c_6*n))*n+(c_7*n)*n+(c_8*n)*n+(c_9*n)*n+(c_10*n)*n+(c_11*n)*n+c_12*n+c_13
