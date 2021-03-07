import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2869_달팽이는올라가고싶다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int d = A - B;// 하루에 올라가는 거리
		
		int cnt = (V-B)/d;// 마지막 도달할 때의 down을 빼준 거리 / 하루 이동 거리
		if((V-B)%d!=0) { // 나머지가 존재한다면 하루 더 걸림
			cnt++;
		}
		System.out.println(cnt);

	}// end of main

}// end of class
