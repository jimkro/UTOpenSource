; 模仿c語言期中考的題目 不知道會不會考 希望會考啦
; 隨機生成十個學生學號和成績 11316001~11316099 / 0~100
; (1) 列出初始隨機學號和成績的陣列 
; (2) 列出依照成績排序的陣列
; (3) 列出依照學號排序的陣列
; (4) 列出十個人的平均分 
; (5) 列出總共有幾個人及格(60up)
; (6) 列出最高分及最低分學生和分數

; 有兩個 FillArray.asm 分別是學號不重複 與 學號會重複 版本，兩者擇一
; 副程式皆可改成 檔名 PROC USES eax ebx ecx edx esi edi, 以防多加變數 

INCLUDE Irvine32.inc
 
EXTERN FillArray  : PROTO           pGrades:PTR DWORD, 
                                    pID:PTR DWORD,
                                    Count:DWORD, 
                                    grade_lower_range:SDWORD, 
                                    grade_higher_range:SDWORD, 
                                    id_lower_range:SDWORD,
                                    id_higher_range:SDWORD

EXTERN PrintArray : PROTO           pGrades:PTR DWORD, 
                                    pID:PTR DWORD,
                                    Count:DWORD 

EXTERN BubbleSortID : PROTO         pGrades:PTR DWORD, 
                                    pID:PTR DWORD,
                                    Count:DWORD

EXTERN BubbleSortGrade : PROTO      pGrades:PTR DWORD, 
                                    pID:PTR DWORD,
                                    Count:DWORD 

EXTERN CountAverage : PROTO         pGrades:PTR DWORD,  
                                    Count:DWORD 

EXTERN CountPass : PROTO            pGrades:PTR DWORD, 
                                    Count:DWORD

EXTERN find_high_and_low : PROTO    pGrades:PTR DWORD, 
                                    pID:PTR DWORD,
                                    Count:DWORD 

.data
    ARRAY_SIZE = 10                                 
    Grade DWORD ARRAY_SIZE DUP(?)  ;  成績
    ID DWORD ARRAY_SIZE DUP(?)  ;  學號
    

    msg1            BYTE    "隨機生成的學號和成績為 :" , 0    
    msgsortID       BYTE    "按照學號排序:", 0
    msgsortGrade    BYTE    "按照成績排序:", 0 

.code
main PROC
    call Randomize          ; call隨機種子   

    ; 1. 填入亂數 ==> 呼叫 FillArray 
    mov  edx, OFFSET msg1
    call WriteString
    call Crlf
    push 11316099              ; 7: id_higher_range
    push 11316000              ; 6: id_lower_range
    push 100                   ; 5: grade_higher_range
    push 0                     ; 4: grade_lower_range
    push ARRAY_SIZE            ; 3: Count
    push OFFSET ID             ; 2: pID
    push OFFSET Grade          ; 1: pGrades
    call FillArray                    
    
    ; 2. 顯示排序前的陣列 ==> 呼叫 PrintArray 

    push ARRAY_SIZE            ; 3. count
    push OFFSET ID             ; 2: pID
    push OFFSET Grade          ; 1: pGrades
    call PrintArray

    ; 3. 按照學號排序陣列 ==> 呼叫 BubbleSortID
    mov edx, OFFSET msgSortID
    call WriteString

    push ARRAY_SIZE            ; 3. count
    push OFFSET ID             ; 2: pID
    push OFFSET Grade          ; 1: pGrades
    call BubbleSortID

    ; 4. 顯示學號排序後的陣列 ==> 呼叫 Print Array
    call Crlf

    push ARRAY_SIZE            ; 3. count
    push OFFSET ID             ; 2: pID
    push OFFSET Grade          ; 1: pGrades
    call PrintArray

    ; 5. 按照分數排序陣列 ==> 呼叫 BubbleSortGrade
    mov  edx, OFFSET msgSortGrade
    call WriteString
    push ARRAY_SIZE            ; 3. count
    push OFFSET ID             ; 2: pID
    push OFFSET Grade          ; 1: pGrades
    call BubbleSortGrade

    ; 6. 顯示分數排序後的陣列 ==> 呼叫 PrintArray
    call Crlf

    push ARRAY_SIZE            ; 3. count
    push OFFSET ID             ; 2: pID
    push OFFSET Grade          ; 1: pGrades
    call PrintArray 

    ; 7. 顯示平均分數 ==> 呼叫  CountAverage 
    push ARRAY_SIZE            ; 2. count 
    push OFFSET Grade          ; 1: pGrades
    call CountAverage

    ; 8. 顯示幾個人 及格==> 呼叫  CountPass
    call Crlf
    push ARRAY_SIZE            ; 2. count 
    push OFFSET Grade          ; 1: pGrades
    call CountPass

    ; 9. 顯示最高和最低分數 ==> 呼叫  find_high_and_low
    call Crlf
    push ARRAY_SIZE            ; 3. count
    push OFFSET ID             ; 2: pID
    push OFFSET Grade          ; 1: pGrades
    call  find_high_and_low
      
    exit
main ENDP
END main