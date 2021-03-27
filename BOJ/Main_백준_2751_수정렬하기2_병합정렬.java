import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

//병합정렬
public class Main_백준_2751_수정렬하기2_병합정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		mergeSort(arr);
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);

	}// end of main

	private static void mergeSort(int[] list) {// 1
		if(list.length == 1)
			return;
		mergeSort(list, 0, list.length - 1);

	}

	private static void mergeSort(int[] list, int start, int end) {// 2

		if (start == end)
			return;

		// 2집합으로 분할하여 각각 정렬
		int mid = (start + end) / 2;

		mergeSort(list, start, mid);// 왼쪽 집합
		mergeSort(list, mid+1, end);// 오른쪽 집합

		merge(list, start, mid, end);// 병합

	}

	private static void merge(int[] list, int start, int mid, int end) {// 3

		int[] newarr = new int[end - start + 1];
		int left = start;// 왼쪽 끝
		int right = mid + 1;// 오른쪽 끝
		int i = 0;

		do {
			if (list[left] < list[right]) {
				newarr[i++] = list[left++];
			} else {
				newarr[i++] = list[right++];
			}
		} while (left <= mid && right <= end);

		while (left <= mid) {//오른쪽 집합 다 소비된 경우
			newarr[i++] = list[left++];
		}
		//왼쪽 집합이 모두 소비된 경우
		while(right<=end) {
			newarr[i++] = list[right++];
		}
		
		System.arraycopy(newarr,0,list,start,newarr.length);

	}

}// end of class
