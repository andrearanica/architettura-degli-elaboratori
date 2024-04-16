.data
number: .word 10

.text
.globl main
main:   la $t7, number
        lw $t0, 0($t7)
        
        li $v0, 5               # Syscall to ask number
        syscall
        move $s0, $v0

        add $s0, $s0, $t0
        
        li $v0, 1
        move $a0, $s0
        syscall                 # Stampo a schermo la somma