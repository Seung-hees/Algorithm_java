import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2740_행렬곱셈 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int AN = Integer.parseInt(st.nextToken());
		int AM = Integer.parseInt(st.nextToken());

		int[][] A = new int[AN][AM];

		for (int i = 0; i < AN; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < AM; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int BN = Integer.parseInt(st.nextToken());
		int BM = Integer.parseInt(st.nextToken());
		
		int[][] B = new int[BN][BM];
		for (int i = 0; i < BN; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < BM; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		// 입력완료
		
		int[][] C = new int[AN][BM];
		for (int i = 0; i < AN; i++) {
			for (int j = 0; j < BM; j++) {
				for (int k = 0; k < BN; k++) {
					C[i][j]+=A[i][k]*B[k][j];
				}
			}
		}
		
		
		
		for (int i = 0; i < AN; i++) {
			for (int j = 0; j < BM; j++) {
				System.out.print(C[i][j]+" ");
			}
			System.out.println();
		}

	}// end of main

}// end of class
