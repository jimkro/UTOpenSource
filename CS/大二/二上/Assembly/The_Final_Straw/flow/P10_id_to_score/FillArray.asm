INCLUDE Irvine32.inc

.code 
PUBLIC FillArray         

FillArray PROC USES eax edi ecx edx,
    pGrades:PTR DWORD, 
    pID:PTR DWORD,
    Count:DWORD, 
    grade_lower_range:SDWORD, 
    grade_higher_range:SDWORD, 
    id_lower_range:SDWORD,
    id_higher_range:SDWORD     

; 1. 填入學號

    mov edi, pID        ;陣列存進edi
    mov ecx, Count           ;陣列個數

    ; 算出幾個可能值 11316099 - 11316000 + 1
    mov edx, id_higher_range  
    sub edx, id_lower_range
    inc edx 
      
L1: 
    mov eax,edx                 
    call RandomRange    
    add eax , id_lower_range     
    stosd                   ; 把eax的值存進[EDI] 並將EDI+4 (殺小)
    loop L1

; 2. 填入成績

    mov edi, pGrades        ;陣列存進edi
    mov ecx, Count           ;陣列個數

    ; 算出幾個可能值 100 - 0 + 1
    mov edx, grade_higher_range
    sub edx, grade_lower_range
    inc edx 
      
L2: 
    mov eax,edx                 
    call RandomRange    
    add eax , grade_lower_range     
    stosd                   ; 把eax的值存進[EDI] 並將EDI+4 (殺小)
    loop L2


    ret         
FillArray ENDP

END