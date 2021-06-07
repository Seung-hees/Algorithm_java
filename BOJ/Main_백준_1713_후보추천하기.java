import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_1713_후보추천하기 {

	static class Candidate implements Comparable<Candidate> {
		int num;
		int vote;
		int old;

		public Candidate(int num, int vote, int old) {
			super();
			this.num = num;
			this.vote = vote;
			this.old = old;
		}
		
		@Override
		public int compareTo(Candidate o) {
			return this.num - o.num;// 오름차순
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Candidate> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());// 사진 틀
		int rec = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < rec; i++) {
			boolean chk = false;
			int sec = Integer.parseInt(st.nextToken());

			// 사진 틀에 있는 지 확인
			for (Candidate c : list) {
				if (c.num == sec) {
					c.vote++;
					chk = true;
					break;
				}
			}
			// 사진 틀에 없다면
			if (!chk) {
				if (list.size() < N) {
					list.add(new Candidate(sec, 1, i));
				} else {
					list.sort(new Comparator<Candidate>() {

						@Override
						public int compare(Candidate o1, Candidate o2) {
							if(o1.vote < o2.vote) {
								return -1;
							}
							else if (o1.vote == o2.vote) {
								if(o1.old < o2.old) {
									return -1;
								}
								else if (o1.old == o2.old) {
									return 0;
								}
								else {
									return 1;
								}
							}
							else {
								return 1;
							}
						}
					});
					list.remove(0);// 1번째꺼 삭제
					list.add(new Candidate(sec, 1, i));
				}

			}

		} // end

		Collections.sort(list);

		for (Candidate c : list) {
			System.out.print(c.num + " ");
		}

	}// end of main

}// end of class
