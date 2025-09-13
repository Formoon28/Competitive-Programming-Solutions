# Problem Link: https://dmoj.ca/problem/avocadotrees

line = input().split()
n = int(line[0])
q = int(line[1])
h = int(line[2])

trees = [0]
for i in range(1,n+1):
    treeData = input().split()
    height = int(treeData[0])
    numAvocado = int(treeData[1])

    if height <= h:
        trees.append(trees[i-1]+numAvocado)
    else:
        trees.append(trees[i-1])

maxAvocado = 0
for i in range(q):
    ranges = input().split()
    a = int(ranges[0])
    b = int(ranges[1])
    numAvocado = trees[b] - trees[a-1]

    if numAvocado > maxAvocado:
        maxAvocado = numAvocado

print(maxAvocado)
