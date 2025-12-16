TITLE Remainder Procedure Practice

INCLUDE Irvine32.inc

.data

.code
main PROC
    ; 測試迴圈版
    mov eax, 432
    mov ebx, 226
    call GCD_Loop
    call WriteDec    ; 顯示結果
    call Crlf

    ; 測試遞迴版
    mov eax, 432
    mov ebx, 226
    call GCD_Recursive
    call WriteDec    ; 顯示結果
    call Crlf

    exit
main ENDP

; --- 求餘數 ---
GetRemainder PROC
    mov edx, 0
    div ebx
    mov eax, edx
    ret
GetRemainder ENDP

; --- GCD(By Loop) ---
GCD_Loop PROC
L1:
    cmp ebx, 0       ; 1. 檢查 B 是否為 0 (終止條件)
    je Done          ; 如果是 0，EAX 裡的就是最大公因數

    mov edx, 0       ; 2. 清除 EDX (準備除法)
    div ebx          ; 3. EAX / EBX -> 商在 EAX, 餘數在 EDX
    
    mov eax, ebx     ; 4. A = 舊的 B
    mov ebx, edx     ; 5. B = 餘數 (R)
    jmp L1           ; 6. 跳回 L1 繼續下一輪

Done:
    ret
GCD_Loop ENDP

; -----------------------------------------------------------
; GCD_Recursive
; 輸入: EAX = A, EBX = B
; 輸出: EAX = 結果
; -----------------------------------------------------------
GCD_Recursive PROC
    cmp ebx, 0       ; 1. 檢查終止條件 (Base Case)
    je Done          ; 如果 B = 0，直接返回目前的 EAX (即 A)

    ; 2. 計算 A % B
    mov edx, 0       
    div ebx          ; EAX / EBX -> 餘數在 EDX

    ; 3. 準備下一層遞迴所需的參數
    ; 下一層的 A 應該是現在的 B
    ; 下一層的 B 應該是現在的 餘數 (EDX)
    push ebx         ; 先把現在的 B 存到堆疊
    mov ebx, edx     ; 把 B 設為餘數
    pop eax          ; 把剛才存的 B 彈出來給 EAX (變成下一層的 A)

    ; 4. 遞迴呼叫自己
    call GCD_Recursive

Done:
    ret              ; 所有的 call 最後都會從這裡一層一層退回去
GCD_Recursive ENDP


END main