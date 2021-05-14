import java.io.*;
import java.util.*;

public class Main_백준_1926_그림{

   static int N, M,max = 0;
   static int[][] map;
   static boolean[][] visit;
   static Queue<Paint> queue;
   static ArrayList<Integer> result;
   static int dx[] = { -1, 1, 0, 0 };
   static int dy[] = { 0, 0, -1, 1 };

   static class Paint {
      int x;
      int y;

      public Paint(int x, int y) {
         super();
         this.x = x;
         this.y = y;
      }
   }

   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken()); // 세로
      M = Integer.parseInt(st.nextToken());// 가로
      map = new int[N][M];
      visit = new boolean[N][M];
      result = new ArrayList<>();

      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < M; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      int cnt = 0;
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < M; j++) {
            if (map[i][j] == 1 && !visit[i][j]) {
               visit[i][j] = true;
               cnt++;
               bfs(i, j);

            }
         }
      }

      System.out.println(cnt);
      System.out.println(max);

   }// end of main

   private static void bfs(int x, int y) {

      queue = new LinkedList<>();
      queue.offer(new Paint(x, y));
      int paint = 1;

      while (!queue.isEmpty()) {
         Paint p = queue.poll();
         
         for (int k = 0; k < 4; k++) {
            int nx = dx[k] + p.x;
            int ny = dy[k] + p.y;

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny] && map[nx][ny] == 1) {
               queue.offer(new Paint(nx, ny));
               paint++;
               visit[nx][ny] = true;
               

            }
         }
      }
      
      max = Math.max(max, paint);

   }
} // end of class