; 模擬期末考分多個檔案
; 隨機產生 50 個 -5000~5000 的亂數，排序後進行二元搜尋
; 沒找到就繼續找 找到了就break
INCLUDE Irvine32.inc

; 宣告外部程序  (後面是參數)
EXTERN FillArray  :  PROTO pArray:PTR DWORD, Count:DWORD, LowerRange:SDWORD, UpperRange:SDWORD
EXTERN BubbleSort :  PROTO pArray:PTR DWORD, Count:DWORD
EXTERN PrintArray :  PROTO pArray:PTR DWORD, Count:DWORD
EXTERN BinarySearch : PROTO pArray:PTR DWORD, Count:DWORD, searchVal:DWORD

;   DWORD : 無號數
;   SDWORD : 有號數
;   陣列回傳要加 PTR 否則取陣列第一個元素

.data
    ARRAY_SIZE = 50                                  
    myArray DWORD ARRAY_SIZE DUP(?)  ; 宣告陣列 長度50
     
    msgFill     BYTE "--- Filling Array with random numbers (-5000 to 5000) ---",0dh,0ah,0  ; 0dh, oAh 是換行
    msgSort     BYTE 0dh,0ah,"--- Sorting Array (Bubble Sort) ---",0dh,0ah,0
    msgPrint    BYTE "Current Array: ",0dh,0ah,0
    msgAsk      BYTE 0dh,0ah,"Enter a signed integer to search for: ",0
    msgFound    BYTE "Value found at index: ",0
    msgNotFound BYTE "Value not found.",0dh,0ah,0

    searchVal   DWORD ?     ; 使用者輸入

.code
main PROC
    call Randomize          ; call隨機種子   

    ; 1. 填入亂數 ==> 呼叫 FillArray 
    mov  edx, OFFSET msgFill
    call WriteString
    push 5000               ; 上界 (第四個參數)  
    push -5000              ; 下界 (第三個參數)  
    push ARRAY_SIZE         ; 陣列大小 (第二個參數)  
    push OFFSET myArray     ;  陣列位址 (第一個參數)  
    call FillArray          

    ; 2. 顯示排序前的陣列 ==> 呼叫 PrintArray
    mov  edx, OFFSET msgPrint
    call WriteString
    push ARRAY_SIZE         ; 陣列大小 (第二個參數)
    push OFFSET myArray     ; 陣列位址 (第一個參數)
    call PrintArray

    ; 3. 排序陣列 ==> 呼叫 BubbleSort
    mov  edx, OFFSET msgSort
    call WriteString
    push ARRAY_SIZE         ; 陣列大小 (第二個參數)
    push OFFSET myArray     ; 陣列位址 (第一個參數)
    call BubbleSort

    ; 4. 顯示排序後的陣列 ==> 呼叫 Print Array
    mov  edx, OFFSET msgPrint
    call WriteString
    push ARRAY_SIZE         ; 陣列大小 (第二個參數)
    push OFFSET myArray     ; 陣列位址 (第一個參數)
    call PrintArray


AskLoop:
    mov  edx, OFFSET msgAsk
    call WriteString
    call ReadInt        
    mov  searchVal, eax

    ; 5. 執行二元搜尋 ==>  呼叫 BinarSearch 
    push searchVal          ; 使用者輸入 (第三個參數)
    push ARRAY_SIZE         ; 陣列大小 (第二個參數)
    push OFFSET myArray     ; 陣列位址 (第一個參數)
    call BinarySearch       

    cmp  eax, -1          
    je   NotFound           ;相等則跳

    ; 找到 (沒找到就被跳到了)
    push eax                    ; 因為組語唐唐的 cout 改變edx可能影響eax 先保存
    mov  edx, OFFSET msgFound
    call WriteString
    pop eax                     ; eax推出來
    call WriteInt               ; eax
    call Crlf
    jmp  QuitProgram            ; 如果要一直輸入就jmp AskLoop

NotFound:
    mov  edx, OFFSET msgNotFound    
    call WriteString    
    jmp  AskLoop        ;  沒找到就跳到AskLoop 找下個數字


QuitProgram:
    call WaitMsg
    exit
main ENDP
END main