import java.util.*;
import java.io.*;
// sjf
// 준비 큐에서 가장 짧은 프로세스에게 CPU 할당
// starvation, aging 기법으로 해결
// 실행 전에는 실행시간을 알수 없다. 지수 평균 방법을 통해 추측한다.

// 대기 큐, 작업 큐 분리하기 
class Solution {
    static class pro{
        private int arr;// 요청시간
        private int times;// 수행시간
        
        public pro(int arr, int times){
            this.arr = arr;
            this.times = times;
        } 
        
    }
    
    
    public int solution(int[][] jobs) {
        LinkedList<pro> q = new LinkedList<>();// 작업 큐
        // 수행 큐
        PriorityQueue<pro> pq = new PriorityQueue<>(new Comparator<pro>(){
            @Override
            public int compare(pro p1, pro p2){
                return p1.times - p2.times;
            }
        });
        
        
		// 처리 시간 오름차순으로 정렬되는 우선순위 큐(Heap)
		//PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
       for(int[] job:jobs){
           q.offer(new pro(job[0],job[1]));
       }
        // 대기 큐(연결리스트만 collections.sort 가능) 정렬
        Collections.sort(q, new Comparator<pro>(){
            @Override
            public int compare(pro p1, pro p2){
                return p1.arr - p2.arr;
            }
        });
        // 다른 방법
        // 원본 배열 오름차순 정렬 (요청시간 오름차순)
		//Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);


        int answer = 0;
        int cnt = 0;
        int time = q.peek().arr;// 가장 첫번째 현재시간
        // 요청이 모두 수행될때까지 반복
        while(cnt<jobs.length){
            // 하나의 작업이 완료되는 시점 (끝 end) 까지 들어온 모든 요청을 큐에 넣기
            while(!q.isEmpty() && q.peek().arr<=time){
                pq.offer(q.poll());
            }
           
            // 비어있지 않다면
            // 들어온 요청중 가장 수행시간이 빠른 것부터 수행
            if(!pq.isEmpty()){
                pro p = pq.poll();
                time += p.times;// end
                answer +=time - p.arr;// 수행된 시간
                cnt++;
            }else{
                 // 큐가 비어있다면 작업 완료(end ) 이후에 다시 요청이 들어온다는 의미.
                // 그렇담 남아있는 대기큐의 대기시간으로 바꾸어줌
                time = q.peek().arr;
            }
        }
        
        return answer/cnt;
    }
}
