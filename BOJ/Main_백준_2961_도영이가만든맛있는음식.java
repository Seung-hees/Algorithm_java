package workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2961_도영이가만든맛있는음식 {

	static int N; // 재료의 개수 , 음식 신맛 쓴맛 차 적은 것
	static int min = Integer.MAX_VALUE;
	static int[] S;
	static int[] B;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());// 재료의 개수 1~10
		S = new int[N];//신맛
		B = new int[N];//쓴맛
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			S[i] = Integer.parseInt(st.nextToken());// 신맛
			B[i] = Integer.parseInt(st.nextToken());// 쓴맛
		}
		
		powerSet(0,1,0);
		
		System.out.println(min);

	}// end of main
	/**
	 * index : 차수 , sVal : 지금까지 사용한 재료들의 곱 , bVal : 지금까지 사용한 재료들의 합
	 * index 번째의 재료를 사용할지 , 사용할지 않을 지 결정*/
	private static void powerSet(int index,int sVal,int bVal) {
		
	if(index == N) {// 종료파트
		//재료를 사용하지 않으면 리턴
		if(bVal==0) {
			return;
		}
		//신맛, 쓴맛 차 절대값의 최소값을 update
		int result = Math.abs(sVal-bVal);
		if(min>result) min = result;
		return;
	}
	
	//index 번째 재료사용
	powerSet(index+1, sVal*S[index],bVal+B[index]);
	// index 번째 재료 사용 안함.
	powerSet(index+1, sVal,bVal);
		
	}


}// end of class
