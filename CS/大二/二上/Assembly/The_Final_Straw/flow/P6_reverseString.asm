TITLE String Reverse Practice

INCLUDE Irvine32.inc

.data
    MAX = 50
    prompt  BYTE "請輸入字串 (1-50個字元): ", 0
    msg     BYTE "反轉後的結果為: ", 0
    buffer  BYTE MAX + 1 DUP(0)  ; 用來存放輸入的字串
    strLen  DWORD ?              ; 存放字串的實際長度

.code
main PROC
    ; 1. 提示並讀取字串
    mov edx, OFFSET prompt
    call WriteString
    
    mov edx, OFFSET buffer
    mov ecx, MAX                 ; 超重要 : 存 buffer 大小
    call ReadString              ; 使用者輸入，長度會回傳在 EAX
    mov strLen, eax              ; 存好長度，等等迴圈要用

    ; 2. 【第一階段】把字元一個一個推入堆疊 (PUSH)
    mov ecx, strLen              ; 迴圈次數 = 字串長度
    mov esi, 0                   ; ESI 當作陣列索引 (Index)

L1:
    movzx eax, buffer[esi]       ; 將 8-bit 字元零延伸到 32-bit 的 EAX
    push eax                     ; 壓入堆疊
    inc esi                      ; 下一個字
    loop L1

    ; 3. 【第二階段】把字元從堆疊彈出回陣列 (POP)
    mov ecx, strLen              ; 再次設定迴圈次數
    mov esi, 0                   ; ESI 歸零，從頭開始寫入

L2:
    pop eax                      ; 彈出最上面的字元 (最後進去的字)
    mov buffer[esi], al          ; 將 8-bit 的值存回 buffer
    inc esi
    loop L2

    ; 4. 顯示結果
    mov edx, OFFSET msg
    call WriteString
    mov edx, OFFSET buffer
    call WriteString
    call Crlf

    exit
main ENDP
END main