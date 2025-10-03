'''
By Allen Chang
其它解法請去java的部分看，python最快的解法就是將字串以 int() 轉數字後，再用
chr() 把數字轉成ASCII對應的字元
'''

while True:
    try:
        a=input()
        for i in range(0,len(a),3):
            n=int(a[i]+a[i+1]+a[i+2])
            print(chr(n),end='')
        print()
    except EOFError:
        break
