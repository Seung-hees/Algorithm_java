import java.util.Scanner;

public class Main_백준_1205_등수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int N = Integer.parseInt(sc.next());
        int X = Integer.parseInt(sc.next());
        int P = Integer.parseInt(sc.next());
        
        int[] rankList = new int[P];
        
        for(int i=0; i<N; i++) {
            rankList[i] = Integer.parseInt(sc.next());
        }
        
        
        if(N == 0) {
            System.out.println("1");
            return;
        }
        
        for(int i=0; i<N; i++) {
            
            if (rankList[i] <= X) {
                
                if(rankList[i] == X && N == P) {
                    
                    boolean flag = true;
                    
                    for(int temp = i+1; temp < N; temp++) {
                        if(rankList[i] > rankList[temp]) {
                            flag = false;
                            break;
                        }
                    }
                    
                    if(flag) { 
                        System.out.println("-1");
                        return;
                    }
                    
                }
                
                System.out.println(i+1);
                return;
            }
            
        }
        
        if(N < P) {
            System.out.println(N+1);
            return;
        }
       
        System.out.println("-1");
    }
}
