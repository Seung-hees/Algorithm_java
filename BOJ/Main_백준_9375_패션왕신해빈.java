import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_백준_9375_패션왕신해빈 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 0; t < TC; t++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> clothes = new HashMap<>();// <종류,개수>

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();// 옷 이름
				String kind = st.nextToken();// 옷 종류

				// 해당 종류의 옷이 해시맵에 있을경우 , 해시맵에 저장되어있던 해당 종류의 개수를 +1 증가시킴
				// 해당 종류가 없을 경우 , 해당 종류와 개수 +1

				if (clothes.containsKey(kind)) {
					clothes.put(kind, clothes.get(kind) + 1);
				} else {
					clothes.put(kind, 1);
				}
			}
			int res = 1;

			// 안 입는 경우 고려하여 +1 씩 더한 값을 곱해줌
			for (int val : clothes.values()) {
				res *= (val + 1);
			}
			// 알몸 상태 제외
			System.out.println(res - 1);

		}

	}// end of main

}// end of class
