; 記得改檔名 把這個檔改成 FillArray.asm
; 此檔和 FillArray.asm 比多了個 "學號不重複" 的規則 只能使用一個

INCLUDE Irvine32.inc

.code 
PUBLIC FillArray         

FillArray PROC USES eax edi ecx edx ebx esi, ;
    pGrades:PTR DWORD, 
    pID:PTR DWORD,
    Count:DWORD, 
    grade_lower_range:SDWORD, 
    grade_higher_range:SDWORD, 
    id_lower_range:SDWORD,
    id_higher_range:SDWORD     

; --- 1. 填入學號 (不重複版本) ---
    mov edi, pID        
    mov ecx, Count      
    mov ebx, 0          ; 初始化 ebx，用來記住目前陣列存了幾個數字

    ; 算出範圍
    mov edx, id_higher_range  
    sub edx, id_lower_range
    inc edx 

L1_Generate:
    mov eax, edx
    call RandomRange
    add eax, id_lower_range  

    ; --- 檢查是否重複 ---
    push ecx            ; 備份外層 Count
    cmp ebx, 0          ; 如果是第一個，直接存
    je L1_Unique

    mov ecx, ebx        ; 設定檢查次數 = 目前已存的數量
    mov esi, pID        ; 從頭開始檢查

L1_CheckLoop:
    cmp eax, [esi]      ; 比對新產生的 EAX 跟舊的
    je L1_Duplicate     ; 一樣的話就跳走
    add esi, 4          ; 下一個 DWORD
    loop L1_CheckLoop

L1_Unique:
    pop ecx             ; 拿回外層 Count
    stosd               ; 存入 [EDI] 並 EDI + 4
    inc ebx             ; 已存數量 + 1
    loop L1_Generate    ; 繼續產下一個直到 Count 歸零
    jmp L2_Setup        ; 學號填完，跳到填成績的部分

L1_Duplicate:
    pop ecx             ; 拿回外層 Count
    jmp L1_Generate     ; 重複了，不減 ECX，重新產一次

; 2. 填入成績
L2_Setup:
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