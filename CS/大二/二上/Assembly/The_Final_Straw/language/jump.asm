; JE：相等時跳 (Jump if Equal)
; JNE：不相等時跳 (Jump if Not Equal)

; JG / JL：有號數的大於 / 小於
; JGE / JLE：有號數的大於等於 / 小於等於

; JA / JB：無號數的大於 / 小於 (Above / Below)
; JBA / JBE：無號數的大於等於 / 小於等於 (Above or Equal/ Below or Equal)

.data
    msgA BYTE "A is bigger", 0
    msgB BYTE "B is bigger or equal", 0

.code
main PROC
    ; 假設 EAX 裡是 A，EBX 裡是 B
    ; (這裡省略輸入步驟，直接假設數值)
    mov eax, 50
    mov ebx, 30

    cmp eax, ebx     ; 第一步：比較 EAX 和 EBX
    jg  L1           ; 第二步：JG 代表 "Jump if Greater" (如果左邊 > 右邊，就跳到 L1)

    ; --- 這是 Else 部份 (不跳的話會執行這裡) ---
    mov edx, OFFSET msgB
    call WriteString
    jmp Quit         ; 執行完畢，直接跳到結尾，不要執行到 L1

L1: ; --- 這是 If 部份 ---
    mov edx, OFFSET msgA
    call WriteString

Quit:
    call Crlf
    exit
main ENDP

特殊的 flag 值
助憶符	說明	旗標
JZ	若為零則跳	ZF = 1
JNZ	若不為零則跳	ZF = 0
JC	若進位則跳	CF = 1
JNC	若不進位則跳	CF = 0
JO	若溢位則跳	OF = 1
JNO	若不溢位則跳	OF = 0
JS	若負號則跳	SF = 1
JNS	若非負號則跳	SF = 0
JP	同位(偶)則跳	PF = 1
JNP	非同位(偶)則跳	PF = 0

兩運算元是否相等
助憶符	說明
JE	相等則跳
JNE	不相等則跳
JCXZ	若 CX = 0 則跳
JECXZ	若 ECX = 0 則跳

Unsigned 數字間的比較
助憶符	說明
JA	較大則跳
JNBE	不是較小或相等則跳 (=JA)
JAE	較大或相等則跳
JNB	不是較小則跳 (=JAE)
JB	較小則跳
JNAE	不是較大或相等則跳 (=JB)
JBE	較小或相等則跳
JNA	不是較大則跳 (=JBE)

Sign 數字間的比較
助憶符	說明
JG	較大則跳
JNLE	不是較小或相等則跳 (=JG)
JGE	較大或相等則跳
JNL	不是較小則跳 (=JGE)
JL	較小則跳
JNGE	不是較大或相等則跳 (=JL)
JLE	較小或相等則跳
JNG	不是較大則跳 (=JLE)