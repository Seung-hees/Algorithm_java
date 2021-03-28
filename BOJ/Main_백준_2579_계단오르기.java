import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_백준_2579_계단오르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] scores = new int[301];
        int[] dp = new int[301];
        for (int i = 1; i <= N; i++) {
            dp[i] = scores[i] = Integer.parseInt(br.readLine());
        }
        dp[2] += scores[1];

        for (int i = 3; i <= N; i++) {
            dp[i] += Math.max(dp[i - 2], dp[i - 3] + scores[i - 1]);
        }

        System.out.println(dp[N]);
    }
}