INCLUDE Irvine32.inc
 
PUBLIC PrintArray

.data
comma BYTE ", ",0

.code 
PrintArray PROC USES eax ecx edx esi,
    pArray:PTR DWORD,        
    Count:DWORD     
    
    mov esi, pArray
    mov ecx, Count
    cld                

L1: 
    lodsd                       ; [esi] 指向 EAX 且 eax加上4 
    call WriteInt               
    mov edx , OFFSET comma      
    call Writestring  
    loop L1

    call Crlf
    ret
PrintArray ENDP

END