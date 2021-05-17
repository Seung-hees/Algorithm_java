import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2016년의 1월 1일은 금요일, 윤년
// 0- 월 , 1-화, 2-수, 3-목, 4-금, 5-토, 6-일
public class Solution_SWEA_5515_2016년요일맞추기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int month = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			int days = 0;

			switch (month) {
			case 1:
				days = day;
				break;
			case 2:
				days = 31 + day;
				break;
			case 3:
				days = 31 + 29 + day;
				break;
			case 4:
				days = 31 + 29 + 31 + day;
				break;
			case 5:
				days = 31 + 29 + 31 + 30 + day;
				break;
			case 6:
				days = 31 + 29 + 31 + 30 + 31 + day;
				break;
			case 7:
				days = 31 + 29 + 31 + 30 + 31 + 30 + day;
				break;
			case 8:
				days = 31 + 29 + 31 + 30 + 31 + 30 + 31 + day;
				break;
			case 9:
				days = 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + day;
				break;
			case 10:
				days = 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + day;
				break;
			case 11:
				days = 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + day;
				break;
			case 12:
				days = 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + day;
				break;

			}
			int result = (3+days)%7;

			System.out.println("#" + t + " " + result);
		}

	}// end of main

}// end of class
