package holiday;

//우선 순위 큐!로 다시 푸는 방법 보기!
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.chrono.MinguoChronology;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int index;
	int priority;

	Point(int index, int priority) {
		this.index = index;
		this.priority = priority;
	}
}

public class Main_백준_1966_프린터큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());// 테케
		for (int t = 1; t <= TC; t++) {
			Queue<Point> printer = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());// 문서의 개수 0,1
			int M = Integer.parseInt(st.nextToken());// 몇 번째로 인쇄되었는지 궁금한 문서의 위치
			st = new StringTokenizer(br.readLine(), " ");
			// 큐 값 삽입
			int max = -1;
			for (int i = 0; i < N; i++) {
				int m = Integer.parseInt(st.nextToken());
				if (m > max) {
					max = m;
				}
				printer.offer(new Point(i, m));
			}
			int cnt = 0; // 몇번째로 빠졌는지
			while (!printer.isEmpty()) {
				// 크거나 같다면
				if (printer.peek().priority == max) {
					cnt++;
					if (printer.peek().index == M) {
						break;
					}
					printer.poll();
					// 꺼내고 나서 다시 max값 찾기
					max = -1;
					for (Point i : printer) {
						if (i.priority > max) {
							max = i.priority;
						}
					}

				} else if (printer.peek().priority < max) { // max 보다 작다면 빼서 다시 넣음
					printer.offer(printer.poll());
				}
			}
			System.out.println(cnt);

		} // end of tc

	}// end of main
}// end of class
