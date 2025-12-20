INCLUDE Irvine32.inc
 
PUBLIC CountAverage

.data
W1 BYTE "這個班的平均是 ",0  
W2 BYTE " 分",0  
.code 
CountAverage PROC USES eax ecx esi ,
    pGrades:PTR DWORD,  
    Count:DWORD    

    mov eax, 0
    mov ecx, Count
    mov esi, pGrades
 
L_Sum:
    add eax, [esi]
    add esi, 4
    loop L_Sum
    
    mov edx, 0              ;便便edx會影響到eax除Count 神奇
    div Count
    mov edx , OFFSET W1
    call WriteString
    call WriteDec
    mov edx , OFFSET W2
    call WriteString
    call Crlf

    ret
CountAverage ENDP

END