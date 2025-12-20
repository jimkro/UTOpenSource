INCLUDE Irvine32.inc

PUBLIC BubbleSortID

.code 
 
BubbleSortID PROC USES eax ebx ecx edx esi edi,
    pGrades :PTR DWORD,  
    pID :PTR DWORD,        
    Count:DWORD             

    mov ecx,Count
    dec ecx        ; n個數只n-1次排序  

;  外層迴圈 : 控制掃描幾輪
L1: push ecx            ; 保護 ecx
    mov esi , pID    
    mov edi , pGrades  

; 內層迴圈 : 掃描相隔的元素
L2: mov eax,[esi]        
    cmp [esi+4],eax     
    jge L3        ; arr[+1] >= arr[i]
    
    ; 交換 : arr[i+1] < arr[i]時 ==> 大的往右邊推
    xchg eax,[esi+4]   
    mov [esi],eax
    mov ebx, [edi]        ; 取出目前成績
    xchg ebx, [edi+4]     ; 與下一個成績交換
    mov [edi], ebx        ; 存回目前位置
;判斷內層迴圈是否結束 : 結束了跳到 L1 沒結束跳到 L2
L3: add esi, 4       
    add edi, 4
    loop L2     ; 等 ecx 到 0 就會跳到 下面       

    pop ecx           
    loop L1       ; 同理     

L4: ret
BubbleSortID ENDP

END