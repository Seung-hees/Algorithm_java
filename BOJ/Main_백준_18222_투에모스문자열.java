import java.util.*;

public class Main_백준_18222_투에모스문자열 {
    static long[] arr = new long[64];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();

        for (int i = 0; i < arr.length; i++) {
			arr[i] = (long)Math.pow(2, i); 
		}
       
        System.out.println(solv(k));
    }

    public static int solv(long k) {
        if (k == 1)  return 0;
        
        long N = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (k > arr[i]) N = arr[i];
            else break;
            
        }
        return 1 - solv(k - N);

    }

}