INCLUDE Irvine32.inc
 
PUBLIC find_high_and_low

.data
W1 BYTE "最高的人是 ",0
W2 BYTE " , 他的分數是 ",0
W3 BYTE "最低的人是 ",0
W4 BYTE " , 他的分數是 ",0
W5 BYTE " 分" ,0

.code 
find_high_and_low PROC USES eax ebx ecx edx esi edi,
    pGrades:PTR DWORD, 
    pID:PTR DWORD,
    Count:DWORD    

    ;本地初始化 : 最大最小的學號成績
    Local   maxGrade: DWORD, 
            maxID : DWORD,
            minGrade: DWORD,
            minID : DWORD
            
    mov edi, pID
    mov esi, pGrades 
    mov ecx, Count
    cld     
    
    ; 1.初始化 : 假設初始是最大和最小
    mov eax, [esi]
    mov maxGrade, eax
    mov minGrade, eax

    mov eax, [edi]
    mov maxID, eax
    mov minID, eax

    dec ecx

L1: 
    add esi, 4
    add edi, 4

    mov eax, [esi]
    cmp eax , maxGrade
    JG L_checkMax

    cmp eax , minGrade
    JL L_checkMin
L2:
    loop L1
    jmp  L_print
     
L_checkMax: 
    mov maxGrade , eax
    mov ebx, [edi]
    mov maxID, ebx
    jmp L2

L_checkMin:
    mov minGrade , eax
    mov ebx, [edi]
    mov minID, ebx
    jmp L2

L_print:
    ; 印最高
    mov edx, OFFSET W1
    call WriteString
    mov eax, maxID
    call WriteDec
    mov edx, OFFSET W2
    call WriteString
    mov eax, maxGrade
    call WriteDec
    mov edx, OFFSET W5
    call WriteString
    call Crlf

    ; 印最低
    mov edx, OFFSET W3
    call WriteString
    mov eax, minID
    call WriteDec
    mov edx, OFFSET W4
    call WriteString
    mov eax, minGrade
    call WriteDec
    mov edx, OFFSET W5
    call WriteString
    call Crlf

    ret
find_high_and_low ENDP
END