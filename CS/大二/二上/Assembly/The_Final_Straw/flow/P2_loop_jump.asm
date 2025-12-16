TITLE Nested Loop Practice

INCLUDE Irvine32.inc

.data
    prompt BYTE "請輸入次數 : ", 0
    msgH   BYTE "Hello World ", 0
    cool   BYTE "！", 0
    total  DWORD ?

.code
main PROC
    mov edx, OFFSET prompt
    call WriteString
    call ReadInt
    mov total, eax      ; 總行數
    
    mov ecx, 1          ; 我們從 1 個驚嘆號開始

L1: ; --- 外層迴圈 (控制行數) ---
    push ecx            ; 【關鍵】把外層的 ECX 存進堆疊
    
    ; 1. 印出 Hello World
    mov edx, OFFSET msgH
    call WriteString

    ; 2. 內層迴圈 (印出驚嘆號)
    ; 此時 ECX 決定要印幾個驚嘆號
    mov edx, OFFSET cool
    L2:
        call WriteString
        loop L2

    call Crlf           ; 換行
    
    pop ecx             ; 【關鍵】從堆疊把外層的 ECX 拿回來
    
    inc ecx             ; 下一行要多印一個驚嘆號
    
    ; 因為我們手動控制次數，這裡我們檢查是否超過輸入的總行數
    cmp ecx, total
    jbe L1              ; 如果 ecx <= total，跳回 L1 繼續下一行

    exit
main ENDP
END main