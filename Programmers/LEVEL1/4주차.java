import java.util.*;
import java.io.*;

public class Solution {
    static class Point implements Comparable<Point>{
        int score;
        String kind;
        
        @Override
        public int compareTo(Point p){
            if(p.score == this.score){
                return this.kind.compareTo(p.kind);// 문자열 사전순 정렬 compareTo 사용!!!
            }
            return p.score - this.score;
        }
        
        public Point(int score, String kind){
            this.score = score;
            this.kind = kind;
        }

    }
    
    public String solution(String[] table, String[] languages, int[] preference) {
        //String answer = "";
        ArrayList<Point> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i=0; i<table.length; i++){// 각 직군 별 나누기
            
            String[] group = table[i].split(" ");
            int sum = 0;
            String job = group[0];
            
            for(int j=0; j<languages.length;j++){// 언어
            
                for(int k=1; k< group.length; k++){// 직군 내 언어 찾기
                    if(languages[j].equals(group[k])){// 일치 시 더해주고 다시 되돌아 가기
                        sum+=preference[j]*(6-k);
                        break;
                    }
                }
            }
            list.add(new Point(sum , job));
            
        }
        Collections.sort(list);
        
        return list.get(0).kind;
    }
}
