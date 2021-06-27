import java.util.*;

class Solution {
    
    static class song implements Comparable<song>{
        private int idx;
        private int cnt;
        private int total;

        public song(int idx, int cnt, int total){
            this.idx = idx;
            this.cnt = cnt;
            this.total = total;
        }
        
        public int compareTo(song o){

            if(this.total == o.total){
                if(this.cnt == o.cnt){
                     return this.idx - o.idx;// 인덱스는 오름차순 
                 }
                return o.cnt - this.cnt;// 횟수는 내림차순
            }
            
            return o.total - this.total;// 총 재생횟수도 내림차순
        }
        
        
        
    }

    public int[] solution(String[] genres, int[] plays) {
        // index 가 고유번호
        // genres 노래의 장르
        
        HashMap<String, Integer> map = new HashMap<>();
        int size = genres.length;
        // map 완성
        for(int i = 0; i<size; i++){
            if(!map.containsKey(genres[i])){// 만약에 없다면
                // 넣어준다.
                map.put(genres[i],plays[i]);
            }else{
                map.put(genres[i],map.get(genres[i])+plays[i]);
            }
        }
        // 입력 완료
        
        song[] arr = new song[size];// 각 key 별 사이즈 별로 생성
        
        for(int i =0 ; i<size; i++){
            arr[i] = new song(i, plays[i], map.get(genres[i]));
        }
        // 정렬
        Arrays.sort(arr);
        
        ArrayList<Integer> ilist = new ArrayList<Integer>();
        // 가장 맨 앞은 넣어주고 시작
        int music = arr[0].total;
        int val = 0;
        ilist.add(arr[0].idx);
        
        for(int i=1; i<size ; i++){
            if(music != arr[i].total){// 같지 않다면
                music = arr[i].total;
                val = 0;// 변경
                ilist.add(arr[i].idx);
            }else{// 같을 때;
                if(val == 1){
                    continue;// 넣지 않기
                }
                val++;// 1개
                ilist.add(arr[i].idx);// 그냥 넣기
            }
        }// end of for
        
        int[] answer = new int[ilist.size()];
        for(int i= 0; i<ilist.size(); i++){
            answer[i] = ilist.get(i);
        }    
        
        return answer;
    }
}
