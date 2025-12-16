INCLUDE Irvine32.inc

.data
    arr DWORD 1, 2, 3, 4, 5
    msgL BYTE "偶數有 : ", 0
    msgR BYTE " 個", 0
    sz DWORD ?

.code
main PROC
    mov esi, 0
    mov ecx, LENGTHOF arr
    mov eax, 0

    ; while(n--)
L1:
    ; if(arr[idx] % 2 != 0) continue
    ; cnt++
    mov ebx, arr[esi]
    test ebx, 1
    jnz Skip 
    inc eax
Skip:
    add esi, TYPE arr ; idx++
    loop L1 ; n--
    ; end L1

    ; output
    mov edx, OFFSET msgL
    call WriteString
    call WriteDec
    mov edx, OFFSET msgR
    call WriteString

    exit
main ENDP
END main