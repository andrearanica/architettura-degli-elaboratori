# Simulates the behaviour of an if-else
.data
valori: .word 0, 5, 21
risultato: .word 0

.text
.globl main
main:   la $t7, valori              # Main
        la $t8, risultato
        lw $t1, 0($t7)
        lw $t2, 4($t7)
        lw $t3, 8($t7)

        bgtz $t1, then
        blt $t1, $zero, else
        or $s0, $t2, $t3
        j fine

then:   add $s0, $t1, $t2
        add $s0, $s0, $t3
        j fine

else:   li $s0, 1
        mul $s0, $t1, $t2
        mul $s0, $s0, $t3

fine:   sw $s0, 0($t8)             # Fine
        li $v0, 1
        move $a0, $s0

        li $v0, 1
        move $a0, $s0
        syscall