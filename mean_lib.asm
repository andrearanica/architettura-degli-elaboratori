.text

.globl mean

mean:
    addi $sp, $sp, -4
    sw   $ra, 0($sp) 
    jal sum			#chiamata alla procedura per il calcolo della somma
    lw $ra, 0($sp)
    addi $sp, $sp, 4
    
    div $v0, $v0, $a1 		#divisione del valore restituito dalla procedura sum, per il numero di elementi dell'array
    jr $ra

sum:
    move $t0, $a0
    move $t1, $zero
    move $t2, $zero
    move $v0, $zero
    ciclo:
        lb $t1, ($t0)
        add $v0, $t1, $v0	
        addi $t0, 1		#incremento per leggere, al ciclo successivo, il byte successivo
        addi $t2, 1		#incremento il numero di elementi sommati
        bne $t2, $a1, ciclo	#ripeto il ciclo, se non ho raggiunto l'ultimo elemento
    jr $ra