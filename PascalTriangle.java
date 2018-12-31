/*Project Info
    This code was used to generate Pascal's Triangle
    
*/

public class PascalTriangle {

    public static void main(String[] args) {
    	
        int n = args.length == 1 ? Integer.parseInt(args[0]) : 1;

        for (int i = 1; i <= 10; ++i) {
            int[] arr = Pascal.triangle(i);
            System.out.print((i < 10 ? " " : "") + i + ": ");
            for (int j : arr) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

class Pascal {

    public static int[] triangle(int n) {
    	if(n==1){
    		return new int[]{1};
    	}
    	int[] actual=new int[n];
    	int[] temp=triangle(n-1);
    	actual[0]=1;
    	actual[n-1]=1;
    
    	for(int i=1;i<n-1;i++){
    		actual[i]=temp[i-1]+temp[i];
    		
    		
    	}
    	
        return actual;
    }
}