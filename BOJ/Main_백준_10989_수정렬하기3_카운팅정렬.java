import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_10989_수정렬하기3_카운팅정렬 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	
		final int size = arr.length;
		int[] result = new int[size];
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		// 최대값과 최소값 구하기 (0부터 시작하지 않기 위해 min 구함)
		for (int i = 0; i < size; i++) {
			if(arr[i]<min) min = arr[i];
			if(arr[i]>max) max = arr[i];
		}
		
		// 배열 원소의 최대값 표현 가능한 크기의 카운팅 배열 ㅐㅇ성
		int[] count = new int[max+1];
		for (int i = 0; i < size; i++) {
			count[arr[i]]++;
		}
		// 카운팅 변형 : 누적합
		
		for (int i = min+1; i <=max; i++) {
			count[i] = count[i-1] + count[i];
		}
		
		// 배열 원소 하나씩 들여다보며 결과배열의 각 원소에 해당하는 위치에 채움, 뒤에서부터!!
		for (int i = size-1; i >=0; i--) {
			result[--count[arr[i]]] = arr[i];
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
		
		
		
	}// end of main

}// end of class
