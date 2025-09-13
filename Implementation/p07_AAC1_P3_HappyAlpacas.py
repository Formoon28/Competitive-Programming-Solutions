# Problem Link: https://dmoj.ca/problem/aac1p3

line = input().split()
n = int(line[0])
x = int(line[1])

if (n%2==0 and x%2==1) or (n%2==1 and x%2==0):
    print(-1)
else:
    answer = []
    if x==n:
        for i in range(n):
            answer.append("0")
        print(" ".join(answer))
    else:
        for i in range(x+1):
            answer.append("0")
        for i in range(n-(x+1)):
            if i%2==0:
                answer.append("1")
            else:
                answer.append("0")
        print(" ".join(answer))
