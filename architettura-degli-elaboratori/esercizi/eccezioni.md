# Esercizi eccezioni
- Quali eccezioni sono generate se ci sono questi errori?
    - 0x00000100 => 00000 = 0 => interrupt hardware
    - 0x00000018 => 00110 = 6 => bus error on instruction fetch
    - 0x00000200 => 00000 = 0 => interrupt hardware
    - 0x00000000 => no eccezione
    - 0x00000020 => 01000 = 8 => syscall exception
    - 0x00000014 => 00101 = 5 => address error exception (store)
    - 0x00000030 => 01100 = 12 => arithmetic overflow exception