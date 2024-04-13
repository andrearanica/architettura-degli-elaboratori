# Sum an array of 10 numbers
.data
numeri: .word 10, 9, 8, 7, 6, 5, 4, 3, 2, 1
risultato: .word 0

.text
.globl main
main:   la $t7, numeri
        li $t0, 10              # t0 e' il contatore del ciclo
        li $s0, 0               # s0 contiene la somma

for:    lw $t1, 0($t7)          # Carico in $t1 il numero corrente
        add $s0, $s0, $t1       # Sommo il numero nella posizione corrente
        addi $t7, $t7, 4        # Aumento la posizione in cui cercare
        addi $t0, $t0, -1       # Decremento il contatore del ciclo
        bgtz $t0, for           # Controllo se devo tornare al for

        li $v0, 1
        move $a0, $s0
        syscall