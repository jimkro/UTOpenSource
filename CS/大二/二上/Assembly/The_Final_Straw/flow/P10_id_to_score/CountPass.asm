INCLUDE Irvine32.inc
 
PUBLIC CountPass

.data
W1 BYTE "總共有 ",0
W2 BYTE " 個人及格",0

.code 
CountPass PROC USES eax ebx ecx edx esi ,
    pGrades:PTR DWORD,  
    Count:DWORD    
     
    mov ebx, 0
    mov ecx, Count
    mov esi, pGrades
    cld                

L1: 
    mov eax , [esi]
    cmp eax , 60
    Jl L_next
    inc ebx

L_next:
    add esi, 4
    loop L1 
     

L_print:
    mov edx, OFFSET W1
    call WriteString
    
    mov eax, ebx        ; 把統計好的及格人數搬到 EAX 準備印出
    call WriteDec
    
    mov edx, OFFSET W2
    call WriteString
    call Crlf

    ret
CountPass ENDP
END