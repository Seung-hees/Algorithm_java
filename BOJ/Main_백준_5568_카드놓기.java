import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
// 순열
public class Main_백준_5568_카드놓기 {
	private static HashSet<Integer> set;
	private static int n;
	private static boolean[] selected;
	private static int[] arr;
	private static int[] permu;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		set = new HashSet<>();
		n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		arr = new int[n];
		selected = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		per(0,"",k);
		System.out.println(set.size());


	}// end of main

	private static void per(int cnt,String s, int k) {
		if(cnt == k) {
			set.add(Integer.parseInt(s));
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(selected[i]) continue;
			
			selected[i] = true;
			per(cnt+1,s+arr[i],k);
			selected[i] = false;
		}
		
		
	}

}// end of class
