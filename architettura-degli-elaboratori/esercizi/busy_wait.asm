# Busy wait I/O management
.data   
char:           .asciiz "\n\n"
exit_char:      .ascii "q"
end_message:    .asciiz "\nEsecuzione terminata"

.text
.globl main
main:   li $s0 0xffff0000   # Receiver Control | Read only | Two bits: bit 0 is ready, bit 1 is interrupt enable
        li $s1 0xffff0004   # Receiver Data | Contains the last character (last 8 bits)
        li $s2 0xffff0008   # Transmitter Control | Works as the Receiver control
        li $s3 0xffff000c   # Transmitter Data | Send to the console the last 8 bits
        la $t0, exit_char
        lb $t1, 0($t0)

BusyWaitRead:   lw $s4, 0($s0)  # $s4 = Receiver control
                andi $s4, $s4, 0x1  # $s4 = bit ready Receiver
                beq $s4, $zero, BusyWaitRead    # if bit ready is zero nothing has arrived

                # something arrived from console
                lb $s5, 0($s1)
                beq $s5, $t1, ExitBusyWait
                sb $s5, char            # I store inside char the new character
                
                lw $s6, 0($s2)          # I get the Transmitter Control
                andi $s6, $s6, 0x1      # And I check if it's ready
                beq $s6, $zero, BusyWaitRead
                lb $s5, char
                sw $s5, 0($s3)          # If it's ready...

                j BusyWaitRead

ExitBusyWait:   la $a0, end_message
                li $v0, 4
                syscall
                jr $ra