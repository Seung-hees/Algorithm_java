import java.util.*;

class Solution {
    public int solution(String numbers) {
      
        HashSet<Integer> set = new HashSet<>();
        
        // 소수를 만들기 (순열)
        
        permutation("",numbers,set);
        
        // 소수 확인하기
     
        int answer = set.size();
        // while(set.iterator().hasNext()){
        //     int i = set.iterator().next();
        //     set.remove(i);
        //     if(i%2!=0 && isPrime(i)){
        //         answer++;
        //     }
        //     if(i == 2){
        //         answer++;
        //     }
        // }
        
    
        return answer;
    }
    
    public void permutation(String prefix, String str, HashSet<Integer> set){
        
        if(!prefix.equals("")){
            int n = Integer.valueOf(prefix);// 스트링을 Integer 로 변환, 0도 알아서 사라짐
            if(n%2!=0 && isPrime(n)){
                set.add(n);
            }
            if(n == 2){
                set.add(n);
            }
        }
        int n = str.length();
        for(int i=0; i< n;i++){
            permutation(prefix+str.charAt(i), str.substring(0,i)+str.substring(i+1,n),set);// i는 사용했으니까 중복 사용은 안되므로 substring 함수를 통해서 i 부분만 빼준다.
        }

    }
    
    // 소수 찾기
    public boolean isPrime(int n ){
        if(n==0 || n==1){
            return false;
        }
     
        for(int i=2; i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        
        return true;//소수임
    }

    
}// end of class
