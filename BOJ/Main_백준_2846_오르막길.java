import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2846_오르막길 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = arr[0];// 시작지점
		int end = arr[0];// 끝지점
		int len = 0;
		for (int i = 1; i < N; i++) {
			if(arr[i-1]>=arr[i]) {
				len = Math.max(len, end-start);
				start = arr[i];// 시작 지점 바꾸기
				end = arr[i];
			}else {// 오르막길
				end = arr[i];// 끝을 갱신
			}
		}
		len = Math.max(len, end-start);// 마지막 한번더
		System.out.println(len);
		
		
	}// end of main

}// end of class
