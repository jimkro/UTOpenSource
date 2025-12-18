TITLE DAA and DAS Simulation Template

INCLUDE Irvine32.inc

.data
    ; --- DAA 測試資料 (35 + 48 = 83) ---
    val1_DAA BYTE 35h
    val2_DAA BYTE 48h
    msgDAA1  BYTE "DAA 測試: 35h + 48h", 0
    msgDAA2  BYTE "  加法後(未修正): ", 0
    msgDAA3  BYTE "  DAA 修正後結果: ", 0

    ; --- DAS 測試資料 (83 - 48 = 35) ---
    val1_DAS BYTE 83h
    val2_DAS BYTE 48h
    msgDAS1  BYTE "DAS 測試: 83h - 48h", 0
    msgDAS2  BYTE "  減法後(未修正): ", 0
    msgDAS3  BYTE "  DAS 修正後結果: ", 0

.code
main PROC
    ; ==========================================
    ; 1. 測試 DAA (加法修正)
    ; ==========================================
    mov edx, OFFSET msgDAA1
    call WriteString
    call Crlf

    mov eax, 0          ; 清除暫存器，避免殘留
    mov al, val1_DAA
    add al, val2_DAA    ; 35h + 48h = 7Dh
    
    ; 顯示未修正前的結果 (7D)
    mov edx, OFFSET msgDAA2
    call WriteString
    movzx eax, al
    call WriteHex
    call Crlf

    ; 執行模擬 DAA
    call MySimulatedDAA ; 修正後 AL 應為 83h
    
    ; 顯示修正後的結果 (83)
    mov edx, OFFSET msgDAA3
    call WriteString
    movzx eax, al
    call WriteHex
    call Crlf
    call Crlf

    ; ==========================================
    ; 2. 測試 DAS (減法修正)
    ; ==========================================
    mov edx, OFFSET msgDAS1
    call WriteString
    call Crlf

    mov eax, 0
    mov al, val1_DAS
    sub al, val2_DAS    ; 83h - 48h = 3Bh
    
    ; 顯示未修正前的結果 (3B)
    mov edx, OFFSET msgDAS2
    call WriteString
    movzx eax, al
    call WriteHex
    call Crlf

    ; 執行模擬 DAS
    call MySimulatedDAS ; 修正後 AL 應為 35h
    
    ; 顯示修正後的結果 (35)
    mov edx, OFFSET msgDAS3
    call WriteString
    movzx eax, al
    call WriteHex
    call Crlf

    exit
main ENDP

; -----------------------------------------------------------
; MySimulatedDAA
; 模擬加法後的十進位調整
; -----------------------------------------------------------
MySimulatedDAA PROC
    push ebx
    lahf                ; 讀取旗標到 AH (AF在bit 4, CF在bit 0)
    mov bh, ah          ; BH 備份原始旗標

    ; --- 低位修正 ---
    mov bl, al
    and bl, 0Fh         ; 取得低 4 位
    cmp bl, 9
    ja  FixL
    test bh, 00010000b  ; 檢查 AF
    jz  CheckH
FixL:
    add al, 6
    or  bh, 00010000b   ; 設定 AF = 1

    ; --- 高位修正 ---
CheckH:
    test bh, 00000001b  ; 檢查 CF
    jnz FixH
    cmp al, 9Fh
    jbe Done
FixH:
    add al, 60h
    or  bh, 00000001b   ; 設定 CF = 1

Done:
    pop ebx
    ret
MySimulatedDAA ENDP

; -----------------------------------------------------------
; MySimulatedDAS
; 模擬減法後的十進位調整
; -----------------------------------------------------------
MySimulatedDAS PROC
    push ebx
    lahf                ; 讀取旗標
    mov bh, ah

    ; --- 低位修正 ---
    mov bl, al
    and bl, 0Fh
    cmp bl, 9
    ja  FixL
    test bh, 00010000b  ; 檢查 AF
    jz  CheckH
FixL:
    sub al, 6
    or  bh, 00010000b   ; 設定 AF = 1

    ; --- 高位修正 ---
CheckH:
    test bh, 00000001b  ; 檢查 CF
    jnz FixH
    cmp al, 9Fh
    jbe Done
FixH:
    sub al, 60h
    or  bh, 00000001b   ; 設定 CF = 1

Done:
    pop ebx
    ret
MySimulatedDAS ENDP

END main