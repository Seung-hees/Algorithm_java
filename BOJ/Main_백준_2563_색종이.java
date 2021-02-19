package workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2563_색종이 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] arr = new boolean[100][100];
		
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					arr[j][k] = true;
				}
			}
		}
		
		int width = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j] == true)
					width++;
			}
		}
		System.out.println(width);
		
		
	}
	
}
