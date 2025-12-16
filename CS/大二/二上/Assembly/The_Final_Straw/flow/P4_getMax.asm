INCLUDE Irvine32.inc

.data
    arr DWORD 10, 20, 30, 40, 50
    msg BYTE "最大值是: ", 0

.code
main PROC
    mov esi, 0
    mov ecx, LENGTHOF arr
    
    ; 先假設第一個數字是最大值
    mov eax, arr[esi] ; 存最大值

L1:
    mov ebx, arr[esi]       ; 把當前陣列元素放進 EBX
    cmp eax, ebx             ; 比較 (最大值 vs 當前值)
    
    jae Next
    mov eax, ebx             ; 如果走到這，代表 ebx 比較大，更新 max

Next:
    add esi, TYPE arr       ; 移動一個元素的距離
    loop L1

    ; 輸出
    mov edx, OFFSET msg
    call WriteString
    
    call WriteDec
    call Crlf

    exit
main ENDP
END main