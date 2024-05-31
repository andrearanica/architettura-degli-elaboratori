# Esercitazione datapath

## Esercizio 1
- Quali sono e quali funzioni svolgono le unità funzionali del datapath?
    - <b>Memoria</b>: elemento di stato che, nel datapath multiciclo, contiene sia le istruzioni che i dati
        - Input: indirizzo, dati da scrivere, segnale di scrittura
        - Output: valore della cella nell'indirizzo specificato
    - <b>Instruction register</b>: insieme con 32 registri general-purpose
        - Input: 2 registri da leggere, 1 registro da scrivere, dato da scrivere, segnale di scrittura
        - Output: 2 registri letti
    - <b>ALU</b>: componente <i>combinatorio</i> che svolge operazioni aritmentico-logiche
        - Input: A e B, che sono due valori su cui svolgere le operazioni, ALU control, che è un segnale a due bit che indica quale operazione verrà effettuata dall'ALU:
            - 00 somma, 01 differenza, 10 da decidere in base agli ultimi 6 bit dell'IR (func)
        - Output: ALU result, zero che indica se due valori sono uguali facendo la sottrazione (se A-B=0 => A=B)
        - In base all'istruzione svolge le seguenti operazioni:
            - Per tutte le istruzioni, calcola il PC+4 e l'indirizzo di branch (che verrà eventualmente utilizzato o scartato, parcheggiato in ALUOut)
            - Istruzioni R-type: esegue l'operazione aritmentico-logica corrispondente
            - Istruzione lw/sw: calcola l'indirizzo per leggere/scrivere in memoria
            - Istruzione branch: confronta i valori dei due registri
    - <b>Instruction register</b>: contiene l'istruzione (non l'indirizzo) che sta venendo eseguita
        - Input: l'istruzione
        - Output: i campi dell'istruzione
    - <b>Shift left 2</b>: esegue l'operazione di shift logico a sinistra due volte, moltiplica quindi il valore in input per 4 (utile per il campo offset, dato che viene passato un numero da allineare alla word)
    - <b>Sign extend</b>: estensore del segno che è utile quando, nelle istruzioni I-type, l'immediate viene dato come 16 bit e non come 32 bit (estende tutti 1 se l'MSB è 1, altrimenti tutti zero)
    - <b>Control unit</b>: prende in input i 6 bit dell'opcode e manda in output i segnali di controllo per tutti i multiplexor, in modo che il circuito si comporti diversamente in base all'istruzione
- Quali sono e quali funzioni svolgono ciascuno dei registri?
    - <b>PC</b>: contiene l'indirizzo all'istruzione successiva a quella in corso di esecuzione
    - <b>Instruction register</b>: contiene l'istruzione in corso di esecuzione
    - <b>MDR</b>: contiene l'indirizzo che è stato letto da un'istruzione di lw, dato che nel ciclo di clock successivo verrà scritto all'interno della memoria (deve essere parcheggiato)
    - <b>A e B</b>: registri temporanei in cui contenere i valori letti dal register file, che verranno eventualmente usati dall'ALU in base al tipo di operazione
    - <b>ALU Out</b>: contiene il risultato dell'operazione calcolata dall'ALU, che può essere l'indirizzo di jump, la somma/altro dei due registri, l'indirizzo di memoria a cui/da cui leggere
- Qual è il ruolo di ciascun multiplexer? (indico il segnale di controllo)
    - <b>IorD</b>: sceglie l'indirizzo dell'istruzione da caricare (PC o ALUOut per operazioni con memoria)
    - <b>RegDst</b>: sceglie il registro su cui andare a scrivere in base al tipo dell'istruzione
        - I-type: Instruction[20:16]
        - R-type: Instruction[15-11]
    - <b>MemtoReg</b>: decide se scrivere nel registro il valore letto precedentemente dalla memoria (da MDR) o quello calcolato dalla ALU (per R-type)
    - <b>ALUSrcA</b>: sceglie se il primo operando dell'ALU sarà l'indirizzo del PC (per PC+4) o il valore del registro A
    - <b>ALUSrcB</b>: sceglie se il secondo operando dell'ALU sarà:
        - Il registro B, per operazioni R-type
        - La costante 4, per incrementare il PC
        - I bit 15-0 dell'istruzione, per le operazioni I-type
        - I bit 15-0 dell'istruzioni shiftati di due, per l'offset delle operazioni lw/sw
    - <b>PCSource</b>: sceglie la sorgente con cui sovrascrivere il PC
        - 0 = Risultato dell'ALU (PC+4)
        - 1 = ALUOut
        - 2 = Campo immediate delle istruzioni j

## Esercizio 2
- In riferimento allo schema completo del datapath multiciclo (fig. 5.28), in che fase (fetch, decode, execute), e come, sono impostati i segnali di controllo per le diverse classi di istruzioni?
    - Le fasi fetch e decode sono comuni a tutte le classi di istruzioni
    - La classe execute abilita segnali di controllo diversi in base all'istruzione

| LW/SW | R-type | BEQ | Jump |
| ----- | ------ | --- | ---- |
| ALUSrcA=1 | ALUSrcA=1 | ALUSrcA=1 | PCSource=10 |
| ALUSrcB=10 | ALUSrcB=0 | ALUSrcB=0 | PCWrite |
| ALUOp=00 | ALUOp=10 | ALUOp=01 |
| ----- | ----- | PCWriteCond=1 |
| IorD=1 | RegDst=1 | PCSource=01 |
| MemRead | MemToReg=0 |
| ----- | RegWrite |
| MemToReg=1 |
| RegWrite |
| RegDst=0 |
| ----- |

## Esercizio 3
- Per quali classi di istruzioni viene usata la ALU?
    - La ALU viene utilizzata nelle istruzioni:
        - R-type, per effettuare l'operazione aritmentico-logica necessaria
        - BEQ, per verificare se due valori sono uguali (se fare il branch)
        - Accesso alla memoria, per calcolare l'indirizzo a cui accedere (offset)

## Esercizio 4
- Quanti cicli sono necessari per l'esecuzione dell'istruzione `add $s0, $s1, $s2`?
    - Fetch
    - Decode
    - Execute
    - Scrivere il risultato nel register file

## Esercizio 5
- Quanti cicli sono necessari per l'esecuzione dell'istruzione `beq $s0, $s1, imm`?
    - Fetch
    - Decode
    - Execute

## Esercizio 6
- Aggiungere l’istruzione jr rs al set delle istruzioni del datapath multiciclo. Specificare le modifiche da effeUuare al datapath e le modifiche da effettuare nella FSM