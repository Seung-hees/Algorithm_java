import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1316_그룹단어체커 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int t = 1; t <= TC; t++) {
			int check = 0;
			String word = br.readLine();
			
go:			for (int i = 0; i < word.length(); i++) {
				// 같으면 다음으로 이동
				if(i+1 < word.length() && word.charAt(i) == word.charAt(i+1)) {
					continue;
				}else {// 다르다면 
					if(i+2<word.length()) {	
						char w = word.charAt(i);

						for (int j = i+2; j < word.length(); j++) {// 그 다음다음 부터 확인하여 자신의 값과 일치하는 것이 있는 지 확인
							if ( w == word.charAt(j)) {// 같은게 있다면, 해당 단어 탐색 종료
								check = 1;
								break go;
							}
						}
					}
				}
			}
			
			if(check == 0) {
				//System.out.println(word);
				cnt++;				
			}

		}// end of tc
		System.out.println(cnt);
		
		
		
	}//end of main
}// end of class
