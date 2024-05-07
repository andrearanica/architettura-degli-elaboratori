.data
    message:    .asciiz "Insert a number\n"
    array:      .byte 5

.text
.globl main
main:   li $v0, 4           # Print message
        la $a0, message
        syscall

        li $v0, 5           # Syscall 5 ask for a number
        syscall
        addi $s0, $v0, 1

        la $t1, array
        li $t0, 1

for:    sb $t0, 0($t1)
        addi $t1, $t1, 1
        addi $t0, $t0, 1
        blt $t0, $s0, for

        addi $sp, $sp, -4
        sw $ra, 0($sp)        
        la $a0, array
        addi $a1, $s0, 0
        jal mean
        lw $ra, 0($sp)
        addi $sp, $sp, 4

        addi $a0, $v0, 0
        li $v0, 1
        syscall

        jr $ra