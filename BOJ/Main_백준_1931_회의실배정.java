package workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


// 최상 온도 순으로 정렬 후, 뒤의 최하의 온도가 앞의 최상 온도 보다 크면 냉장고 수 증가.
public class Main_백준_1931_회의실배정 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] temp = new int[n][2];// n개의 최하, 최상 온도
		int num = 1; // 냉장고 수
		// 입력 받기
		for (int i = 0; i <n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			temp[i][0] = Integer.parseInt(st.nextToken());
			temp[i][1] = Integer.parseInt(st.nextToken());
		}
		// 오름차순 정렬
		Arrays.sort(temp ,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {//예외인 경우
					return o1[0] - o2[0];
				}
				return o1[1] -o2[1];
			}	
		});
		
		int end = temp[0][1];
		int idx = 1; 
		//두번째 부터 값 비교 및 변경
		while(idx<n) {
			if(end<=temp[idx][0]) {
				end = temp[idx][1];
				num++;
			}
			idx++;
		}
		
		System.out.println(num);
		
		
	}

}
