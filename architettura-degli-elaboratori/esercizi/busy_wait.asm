# Busy wait I/O management
.data   
message:        .ascii "Il tasto premuto è: "
char:           .asciiz "\n\n"
exit_char:      .ascii "q"

.text
.globl main
main:   li $t0 0xffff0000   # Receiver Control | Read only | Two bits: bit 0 is ready, bit 1 is interrupt enable
        li $t1 0xffff0004   # Receiver Data | Contains the last character (last 8 bits)
        li $t2 0xffff0008   # Transmitter Control | Works as the Receiver control
        li $t3 0xffff000c   # Transmitter Data | Send to the console the last 8 bits
        la $t7, char
        la $t8, exit_char
        lb $t9, 0($t8)

BusyWaitRead:   lw $t4, 0($t0)  # $t4 = Receiver control
                andi $t4, $t4, 0x1  # $t4 = bit ready Receiver
                beq $t4, $zero, BusyWaitRead    # if bit ready is zero nothing has arrived

                # something arrived from console
                lb $t5, 0($t1)
                beq $t5, $t9, ExitBusyWait
                sb $t5, 0($t7)          # I store inside char the new character
                li $v0, 4
                la $a0, 0($t7)
                syscall

                j BusyWaitRead

ExitBusyWait:   jr $ra