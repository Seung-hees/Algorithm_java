def solution(numbers):
    answer = 45
    for i in numbers:
        answer-=i
    return answer

def solution(numbers):
    answer = 0
    
    for i in range(0,10) :
        if i not in numbers :
            answer+=i
    return answer

def solution(numbers):
    answer = 0
    check = [0] * 10
    for i in numbers :
        check[i] += 1
    for i in check :
        if i == 0 :
            answer += check.index(i)
            check[check.index(i)] = 1
    return answer

def solution(numbers):
    return 45-sum(numbers)
