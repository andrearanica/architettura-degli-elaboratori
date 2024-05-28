# Esercizi I/O

## Determinare la percentuale di tempo in cui viene effettivamente utilizzata la CPU per trasferire 1 parola da una tastiera uLlizzando la tecnica di ges6one a controllo di programma se:
• la tasIera trasferisce 10 byte/s
• frequenza di clock: 50 MHz
• sono richiesI 20 cicli di clock per ogni by

- Per ogni byte sono necessari 20 cicli di clock => per 4 byte servono 80 cicli di clock
- Per trasferire 10 byte è necessario un secondo => per trasferire un byte servono 0,4 sec
    - In 0,4 secondi vengono svolti 50 * 10^6 * 0.4 cicli = 2 * 10^7 cicli
- La CPU usa quindi 80 cicli su 2 * 10^7 per trasferire il dato => utilizzo dello 0.0004%

## Esercizio 2
- Quale è la frazione del tempo del processore usata per la gestione degli interrupt per il traferimento se
    - Frequenza di clock = 250 MHz
    - Trasferimento di 4 MByte/s in blocchi di 4 word
    - Ogni interruzione impiega 500 cicli di clock

- Il trasferimento avviene a blocchi di 4 word o 16 byte, quindi vengono generati (4*10^6)/16 = 250000 interrupt/s
- Ogni interrupt impiega 500 cicli di clock, quindi sono richiesti 250k * 500 = 125 * 10^6 cicli/sec per gestire gli interrupt
- In un secondo la CPU esegue 250*10^6 cicli => 50% del tempo impiegato per la gestione delle eccezioni

## Esercizio 3
- Qual è la frazione di tempo del processore usata per la gestione con DMA di trasferimento da periferica se
    - Frequenza di clock 250 MHz
    - Trasferimento a blocchi di 8 kbyte per ogni DMA a 4 MByte/sec
    - Per inizializzare il DMA servono 1000 cicli di clock
    - Per interrompere il DMA servono 500 cicli di clock

- Il trasferimento avviene a blocchi di 8 kbyte a 4 MByte/sec => (4 * 10^6) / (8 * 10^3)=500 DMA/sec
- Per ciascun DMA servono 1500 cicli di clock, ossia 1500 * 500 DMA/sec = 750k cicli/sec per gestire il DMA
- La CPU può eseguire 250*10^6 cicli al secondo => 750k / (250 * 10^6) = 0.003 = 0.3% del tempo per gestire i DMA

## Esercizio 4
- Si vuole trasferire un testo di 2 Mbyte
- La CPU esegue 1 istruzione per ciclo di clock
- La CPU va a 500 MHz
- La periferica trasmette a 1KB/sec
- Impostare i registri del DMA richiede 10 cicli di clock
- Qual è il rapporto tra il tempo di DMA e controllo di programma?

- Per gestire il DMA, la CPU impiega 10 cicli di clock => 10 / (500*10^6) = 2 * 10^(-8) secondi
- In caso di controllo di programma
    - La periferica impiega (2 * 10^6)/(1000) = 2000 secondi a trasferire il testo di 2 MByte
    - In 2000 secondi vengono eseguiti 2000 * 500 * 10^6 = 10^12 cicli di clock

## Esercizio 5
- Determinare la percentuale di tempo in cui viene usata la CPU per trasferie una parola con gestione di programma da un floppy disk e da un hard disk considerando che:
    - Servono 20 cicli di clock per ogni byte
    - Frequenza di clock 50 MHz
    - Floppy disk va a 50 KByte/s
    - Hard disk va a 2 MByte/s

- Il floppy impiega 4 byte / 50 KByte/s = 0,00008 secondi
    - In 8*10^-5 secondi vengono lanciati 4000 cicli di clock => per trasferire 4 byte servono 80 cicli di clock, quindi la CPU viene usata per il 80/4000=2%
- L'hard disk impiega 4 byte / 2 MByte/s = 2*10^(-6) secondi
    - In 2*10^(-6) secondi vengono lanciati 100 cicli di clock => la CPU viene usata per l'80%

## Laboratorio quiz 5
- Frequenza di clock 250 MHz
- Velocità di trasferimento 4MB/s
- Dati trasferiti a blocchi di 4 word
- Ogni interruzione occupa 500 cicli di clock
    
- Dopo quanti byte avviene un interrupt?
    - Il trasferimento è a blocchi di 4 word, quindi avviene un interrupt ogni 4 word (16 byte)
- Quanti cicli di clock vengono impiegati per gestire tutti gli interrupt in un secondo?
    - Ogni secondo vengono trasferiti 4MB, quindi vengono generati 4*10^6 / 16 = 250000 interrupt/secondo
    - Per gestire tutti gli interrupt in un secondo vengono impiegati 500 cicli * 250000 interrupt/secondo = 125*10^6 cicli
- Quanta frazione di tempo usa la CPU per gestire gli interrupt?
    - In un secondo vengono usati 125*10^6 cicli per gestire gli interrupt su 250 * 10^6 => 50%