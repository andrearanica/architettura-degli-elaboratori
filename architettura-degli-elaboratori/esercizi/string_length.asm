.data
stringa:    .asciiz "Pippo"
dimension:  .word 0
term:       .asciiz ""

.text
.globl main
main:   la $t7, stringa
        la $t8, dimension
        la $t6, term
        li $t0, 1           # For counter
        lw $s1, 0($t6)

for:    la $t1, stringa
        lw $t2, 0($t1)
        
        li $v0, 4
        move $a0, $t2
        syscall

        addi $t1, $t1, 4
        bne $t7, $s1, for