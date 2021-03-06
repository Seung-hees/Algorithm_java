-- type이 Datetime 인 데이터에서 시간만 추출하려면 hour을 사용
SELECT HOUR(DATETIME) AS 'HOUR', COUNT(DATETIME) AS 'COUNT'
FROM ANIMAL_OUTS
GROUP BY HOUR(DATETIME)
HAVING HOUR >=9 AND HOUR <= 19
ORDER BY HOUR
