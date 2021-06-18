-- '=' : MySQL에서 SET 명령어에서 대입 연산자, 다른 곳에서는 비교연산자
-- ':=' : MySQL에서 대입 연산자로만 사용됨.

SET @hour :=-1; -- 변수 선언
SELECT (@hour := @hour +1) AS 'HOUR',
    (SELECT COUNT(*) 
     FROM ANIMAL_OUTS 
     WHERE HOUR(DATETIME) = @hour) AS 'COUNT'
FROM ANIMAL_OUTS
WHERE @hour < 23
