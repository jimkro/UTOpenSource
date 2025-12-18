INCLUDE Irvine32.inc

.data
    msg1 BYTE "請輸入數字 A : ", 0
    msg2 BYTE "請輸入數字 B : ", 0

    resA BYTE "A 比較大！！", 0
    resB BYTE "A 沒有比較大！！", 0

    numA DWORD ?
    numB DWORD ?
.code
main PROC
    
    ; 提示 A
    mov edx, OFFSET msg1
    call WriteString

    ; 輸入 B
    call ReadInt
    mov numA, eax
    
    ; 提示 A
    mov edx, OFFSET msg2
    call WriteString

    ; 輸入 B
    call ReadInt
    mov numB, eax

    ; 比較
    mov eax, numA
    mov ebx, numB

    cmp eax, ebx
    jg L1
    jmp L2
L1 : 
    mov edx, OFFSET resA
    jmp Quit
L2 :
    mov edx, OFFSET resB
Quit:
    call WriteString
    call Crlf
    exit
main ENDP
END main