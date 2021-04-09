import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
			
			int n = sc.nextInt();// 덤프 횟수
			int[] arr = new int[100];// 상자 담는 곳
			
            int sum = 0;
			for (int j = 0; j < arr.length; j++) {
				arr[j]= sc.nextInt();
                sum +=arr[j];
			}
			Arrays.sort(arr);
            int target = 1; // 평탄화 작업의 목표치 (최대 - 최소)
			if(sum % 100 == 0) {
				target = 0;
			}
            
            
			int dump = 0;
			for (int k = 0; k < n && arr[99] - arr[0]>target ; k++) {
				arr[0]++;
				arr[99]--;
				Arrays.sort(arr);
			}
			dump = arr[99] - arr[0];
			System.out.println("#"+(i+1)+" "+dump);
            
		}
		
		}
		
		
	}
