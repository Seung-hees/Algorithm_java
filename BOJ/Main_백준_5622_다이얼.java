import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_5622_다이얼 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int sum = 0;
		
		for (int i = 0; i < s.length(); i++) {
			
			char op = s.charAt(i);
			
			switch(op) {
			
			case 'A': case 'B': case 'C': //2
				sum+=3;
				break;
			case 'D': case 'E': case 'F': //3
				sum+=4;
				break; 
			case 'G': case 'H': case 'I'://4
				sum+=5;
				break;
			case 'J': case 'K': case 'L'://5
				sum+=6;
				break;
			case 'M': case 'N': case 'O'://6
				sum+=7;
				break;
			case 'P': case 'Q': case 'R': case 'S'://7
				sum+=8;
				break;
			
			case 'T': case 'U': case 'V'://8
				sum+=9;
				break;
			case 'W': case 'X': case 'Y': case 'Z'://9
				sum+=10;
				break;
			

			}				
		}
		
		System.out.println(sum);
		
		
		
	}// end of main
}// end of class
