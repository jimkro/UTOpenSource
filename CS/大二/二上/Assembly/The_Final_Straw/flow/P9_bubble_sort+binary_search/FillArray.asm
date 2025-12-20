INCLUDE Irvine32.inc

.code 
PUBLIC FillArray        
 
FillArray PROC USES eax edi ecx edx,
    pArray:PTR DWORD,         
    Count:DWORD,             
    LowerRange:SDWORD,       
    UpperRange:SDWORD          

    ; 1. 填入值
    mov edi,pArray          ;陣列存進edi
    mov ecx,Count           ;陣列個數

    ; 算出幾個可能值 5000 - (-5000) + 1
    mov edx,UpperRange  
    sub edx,LowerRange  
    inc edx 
    
    ; 邏輯 : 隨機產生0~10000再減掉5000

L1: 
    mov eax,edx                 
    call RandomRange    
    add eax,LowerRange      
    stosd                   ; 把eax的值存進[EDI] 並將EDI+4 (殺小)
    loop L1

    ret         ; 重要!!! 不然edx ecx那些 全炸了
FillArray ENDP

END