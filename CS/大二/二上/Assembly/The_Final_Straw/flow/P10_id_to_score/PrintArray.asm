INCLUDE Irvine32.inc
 
PUBLIC PrintArray

.data
W1 BYTE " 的分數是 ",0
W2 BYTE " 分",0

.code 
PrintArray PROC USES eax ecx edx esi edi,
    pGrades:PTR DWORD, 
    pID:PTR DWORD,
    Count:DWORD    
    
    mov esi, pID
    mov edi, pGrades
    mov ecx, Count
    cld                

L1: 
    lodsd                       ; EAX = [ESI] 且 ESI = ESI + 4
    call WriteDec               ; 學號
    
    mov edx , OFFSET  W1 
    call Writestring  


    mov eax, [edi]
    call WriteDec               ; 分數

    mov edx , OFFSET  W2
    call Writestring  

    call Crlf
    add edi, 4 
    loop L1

L_Done:
    call Crlf
    ret
PrintArray ENDP

END