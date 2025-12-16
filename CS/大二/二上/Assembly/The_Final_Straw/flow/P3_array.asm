INCLUDE Irvine32.inc

.data
    arr DWORD 10, 20, 30, 40, 50
    n = ($ - arr) / 4

.code
main PROC
    ; 初始化                    : sum = 0, i = 0, n = arr.size()
    mov eax, 0                  ; sum = 0
    mov esi, 0                  ; i = 0
    ; mov ecx, n                ; times = n
    mov ecx, LENGTHOF arr ; times = arr.size()

    L1:
        add eax, arr[esi]
        add esi, 4
        loop L1

    call WriteDec
    call Crlf

    exit
main ENDP
END main