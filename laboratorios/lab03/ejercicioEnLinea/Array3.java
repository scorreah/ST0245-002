
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
        int y = 0;
        if(n%2==0){
            y = (n/2)*(n+1);
        }else{
            y=((n+1)/2)*n;
        }
        int[] nums = new int[y];
        for(int i = 1; i<=n;i++){
            for(int j = 1; j<= i; j++){
                nums[cont] = j;
                cont= cont+1;
            }
        }
        return nums;
    }

    public int[] fix34(int[] nums) {
        int index = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i]==3){
                for(int j = index; j<nums.length; j++){
                    if(nums[j]==4){
                        int temp = nums[i+1];
                        nums[i+1]=4;
                        nums[j]= temp;
                        index=j;
                        break;
                    }
                }
            }
        }
        return nums;
    }

    public boolean linearIn(int[] outer, int[] inner) {
        int cont = 0;
        boolean res = false;
        if(inner.length == 0) return true;
        for(int i = 0; i < inner.length; i++){
            for(int j = 0; j < outer.length; j++){
                if(inner[i] == outer[j]){
                    cont++;
                    break;
                }
            }
            if(cont == inner.length){
                res = true;
            }
        }
        return res;
    }

    public int countClumps(int[] nums) {
        int clumps = 0;
        boolean next = true;
        for (int i=0; i < nums.length-1; i++ ) {
            if(nums[i] == nums[i+1] && next) {
                clumps++;
                next = false;
            } else if(nums[i] != nums[i+1]) {
                next = true;
            }
        }
        return clumps;
    }
    
    public int maxMirror(int[] nums) {
        int[] updown = new int[nums.length];
        int n = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            updown[n] = nums[i];
            n++;
        }
        boolean next = false;
        int temp = 0;
        int cont = 0;
        for (int j = 0; j < nums.length; j++) {
            int z = j;
            for (int k = 0; k < nums.length ; k++) {

                if (nums[z] == updown[k] && cont == 0) {
                    cont++;
                    next = true;
                }else if (next && nums[z] == updown[k]) {
                    cont++;
                } else if(nums[z] != updown[k] && next) {
                    next = false;
                    if (cont > temp) temp = cont;
                    cont = 0;
                    //break; 
                }

                if (z+1 < nums.length && next)  z++;
            }
            if (cont > temp) temp = cont;
            cont = 0;
        }

        return temp;
    }
}
