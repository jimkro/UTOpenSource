INCLUDE Irvine32.inc

.code 

PUBLIC BinarySearch
 
BinarySearch PROC USES ebx edx esi edi,
	pArray:PTR DWORD,	 
	Count:DWORD,			 
	searchVal:DWORD		 
LOCAL first:DWORD , last:DWORD, mid : DWORD				  

	; 
	mov	 first,0		; l = 0	 
	mov	 eax,Count		; 陣列總數	 
	dec	 eax			; eax--
	mov	 last,eax		; r = 總數 - 1
	mov	 edi,searchVal	; edi = goal	
	mov	 ebx,pArray		; ebx = arr 

L1: 
	; 先判斷 if (l > r) 的終止條件
	mov	 eax,first			
	cmp	 eax,last
	jg	 L5				 
	 
	; 計算 mid 是多少 
	mov	 eax, last		; 此時 eax = r 
	add	 eax, first		; eax = l + r
	shr	 eax,1			; eax = ( l + r ) / 2
	mov	 mid,eax		; mid = ( l + r ) / 2
	
	; 求出 arr[mid] ==> int edx = arr[]
	mov	 esi,mid		
	shl	 esi,2				;相當於*4 往左移一個的意思
	mov	 edx,[ebx+esi]		; 陣列首位址 + 格數 = arr[mid] 
	  
	; 比較小於 等於 大於
	
	cmp	 edx,edi		
	jge	 L2					; 如果arr[mid] >= goal  跳到 L2

	; 剩下就是 arr[mid] < goal ==> mid = l + 1
	mov	 eax , mid			; eax = mid	
	inc	 eax				; eax ++ ==> eax = mid + 1
	mov	 first,eax			; mid = l + 1
	jmp	 L1		
	 
L2:	;arr[mid] >= goal ==> mid = r - 1 
	cmp	 edx , edi
	jle	 L3			 ;先判斷是否相等
	mov	 eax,mid			 
	dec	 eax
	mov	 last,eax
	jmp	 L1
	 
L3:	mov	 eax,mid 			 
	jmp	 L9		 				 

; 沒找到
L5:	mov	 eax,-1	


L9:	ret
BinarySearch ENDP
END