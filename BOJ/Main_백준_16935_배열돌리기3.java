package workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_16935_배열돌리기3 {
	static int[][] arr, result;// 원본 , 새로운 배열
	static int N, M;// 행과 열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 배열의 크기 N 행
		M = Integer.parseInt(st.nextToken()); // 배열의 크기 M 행
		int R = Integer.parseInt(st.nextToken()); // 연산의 수 R
		arr = new int[N][M]; // 배열의 크기
		// 배열 삽입
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 연산 어떤것
		st = new StringTokenizer(br.readLine(), " ");
		int op;
		while (R > 0) {
			op = Integer.parseInt(st.nextToken());
			// 연산 경우
			switch (op) {
			case 1: // 상하반전
				uptodown();
				arr = result;
				break;
			case 2: // 좌우반전
				lefttoright();
				arr = result;
				break;
			case 3: // 오른쪽으로 90도 회전, 배열 변화
				right90();
				break;
			case 4: // 왼쪽으로 90도 회전, 배열변화
				left90();
				break;
			// 배열의 크기를 N/2xM/2인 4개의 부분배열로 나눔, 배열 그대로
			case 5: // 그룹을 1->2 , 2->3 ,3->4, 4->1
				section1();
				arr = result;
				break;
			case 6: // 1->4 , 4->3, 3->2, 2->1
				section2();
				arr = result;
				break;
			}// end of switch
			R--;
		} // end of while
		print();
	}// end of main
	private static void uptodown() {
		result = new int[N][M];
		for (int index = 0; index < N; index++) {
			System.arraycopy(arr[index], 0, result[N - 1 - index], 0, M);
		}
	}
	private static void lefttoright() {
		result = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = M - 1; j >= 0; j--) {
				result[i][M - 1 - j] = arr[i][j];
			}
		}
	}
	// 90도
	private static void right90() {
		result = new int[M][N];
		int index_M = 0;
		int index_N = 0;
		for (int j = 0; j < M; j++) {
			index_N = 0;
			for (int i = N - 1; i >= 0; i--) {
				result[index_M][index_N] = arr[i][j];
				index_N++;
			}
			index_M++;
		}
		arr = result;
		int temp = N; //swap
		N = M;
		M = temp;
	}
	private static void left90() {
		result = new int[M][N];
		int index_M = 0;
		int index_N = 0;
		for (int j = M - 1; j >= 0; j--) {
			index_N = 0;
			for (int i = 0; i < N; i++) {
				result[index_M][index_N] = arr[i][j];
				index_N++;
			}
			index_M++;
		}
		arr = result;
		int temp = N;
		N = M;
		M = temp;
	}

	private static void section1() {
		result = new int[N][M];
		int index_N = 0, index_M = 0;
		int K = N / 2, T = M / 2; // 부분 행, 열
		// 1,2
		for (int i = 0; i < K; i++) {
			index_M = 0;
			for (int j = 0; j < T; j++) {
				result[index_N][index_M] = arr[K * 1 + i][T * 0 + j];
				index_M++;
			}
			for (int j = 0; j < T; j++) {
				result[index_N][index_M] = arr[K * 0 + i][T * 0 + j];
				index_M++;
			}
			index_N++;
		}
		index_N = K;
		// 3,4
		for (int i = 0; i < K; i++) {
			index_M = 0;
			for (int j = 0; j < T; j++) {
				result[index_N][index_M] = arr[K * 1 + i][T * 1 + j];
				index_M++;
			}
			for (int j = 0; j < T; j++) {
				result[index_N][index_M] = arr[K * 0 + i][T * 1 + j];
				index_M++;
			}
			index_N++;
		}
	}
	private static void section2() {
		result = new int[N][M];
		int K = N / 2, T = M / 2; // 부분 열
		int index_N = 0, index_M = 0;
		// 1,2 (2,3)
		for (int i = 0; i < K; i++) {
			index_M = 0;
			for (int j = 0; j < T; j++) {
				result[index_N][index_M] = arr[K * 0 + i][T * 1 + j];
				index_M++;
			}
			for (int j = 0; j < T; j++) {
				result[index_N][index_M] = arr[K * 1 + i][T * 1 + j];
				index_M++;
			}
			index_N++;
		}
		index_N = K;
		// 3,4(1,4)
		for (int i = 0; i < K; i++) {
			index_M = 0;
			for (int j = 0; j < T; j++) {
				result[index_N][index_M] = arr[K * 0 + i][T * 0 + j];
				index_M++;
			}
			for (int j = 0; j < T; j++) {
				result[index_N][index_M] = arr[K * 1 + i][T * 0 + j];
				index_M++;
			}
			index_N++;
		}
	}
	// 배열 출력 함수
	private static void print() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}// end of class
