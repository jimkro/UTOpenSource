'''
By Allen Chang
在java那邊的解法2提過階乘解法以及面臨的數值儲存問題，然而對python來說這件事無須擔心，
所以我們一樣可以用DP，不過是紀錄0! ~ 50!的值。
這邊我用的是dictionary，但用list也可以。
其它解法請去java的部分看。
'''

tmp={0: 1}
for i in range(50):
    if i==0:
        tmp[1]=1
    else:
        tmp[i+1]=tmp[i]*(i+1)
while True:
    try:
        n=int(input())
        s=0
        for k in range(n+1):
            t=tmp[n]//(tmp[k]*tmp[n-k])
            print(t, end=' ')
            s+=t
        print()
        print(s)
    except EOFError:
        break