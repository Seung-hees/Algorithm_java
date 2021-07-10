import java.util.*;

class Solution {
// 코드가 사라짐..
// 정렬후, 맨 앞과 맨 뒤 값을 비교하는 방법을 생각했었는데 오히려 효율성 측면에서 더 떨어질 것이라고 생각함. => 착각
// 나의 풀이 방식은 visited 배열을 생성후 , visit 하지 않은 해당 인덱스 뒤에 있는 인덱스 중 limit 를 만족하고 그 중 가장 큰 값을 찾아 visit 체크 => 답은 다 맞았지만 시간 초과

  public int solution(int[] people, int limit) {
    int answer = 0;

    Arrays.sort(people);

    int min = 0;

    for (int max = people.length - 1; min <= max; max--){
      if (people[min] + people[max] <= limit) min++;
      answer++;
    }

    return answer;
}
