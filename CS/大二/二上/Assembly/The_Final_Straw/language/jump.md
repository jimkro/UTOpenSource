## 特殊的 flag 值
- JZ	若為零則跳	ZF = 1
- JNZ	若不為零則跳	ZF = 0
- JC	若進位則跳	CF = 1
- JNC	若不進位則跳	CF = 0
- JO	若溢位則跳	OF = 1
- JNO	若不溢位則跳	OF = 0
- JS	若負號則跳	SF = 1
- JNS	若非負號則跳	SF = 0
- JP	同位(偶)則跳	PF = 1
- JNP	非同位(偶)則跳	PF = 0

## 兩運算元是否相等
- JE	相等則跳
- JNE	不相等則跳
- JCXZ	若 CX = 0 則跳
- JECXZ	若 ECX = 0 則跳

## Unsigned 數字間的比較
- JA	        較大則跳
- JNBE	    不是較小或相等則跳 (=JA)
- JAE	        較大或相等則跳
- JNB	        不是較小則跳 (=JAE)
- JB	        較小則跳
- JNAE	    不是較大或相等則跳 (=JB)
- JBE	        較小或相等則跳
- JNA	        不是較大則跳 (=JBE)
- Sign        數字間的比較

## Sign 數字間的比較
- JG	        較大則跳
- JNLE	    不是較小或相等則跳 (=JG)
- JGE	        較大或相等則跳
- JNL	        不是較小則跳 (=JGE)
- JL	        較小則跳
- JNGE	    不是較大或相等則跳 (=JL)
- JLE	        較小或相等則跳
- JNG	        不是較大則跳 (=JLE)