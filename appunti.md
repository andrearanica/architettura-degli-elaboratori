# PIPELINE
- Sfruttare al massimo l'hardware del datapath: quando l'istruzione sta facendo una fase, contemporaneamente un'altra istruzione inizia una fase precedente. 
- Nel datapath della pipeline le memorie sono separate (istruzioni - dati) e non c'è l'instruction register, è una specie diversa di datapath rispetto al multiciclo
- Ogni operazione coinvolge fasi diverse in base al tipo di operazione:
    - Instruction fetch
    - Instruction decode
    - Execute
    - MEM: scrittura o lettura sulla memoria
    - Write back: scrive sul register file, ad esempio per il load word
    Ad esempio, il `beq` esegue solo IF, ID e EX, mentre la `sw` esegue IF, ID, EX, MEM 
- Una sola istruzione per volta può lavorare su una fase
- Dopo ogni stadio, il risultato non fluisce direttamente verso le altre fasi, ma viene scritto in un registro apposito (anche per i segnali di controllo)
- Il segnale si propaga a inizio del ciclo di clock e viene scritto nei registri intermedi alla fine del ciclo di clock
- La scrittura dei registri avviene sul fronte di clock, mentre la lettura viene fatta nella seconda parte del ciclo di clock (nello stesso ciclo di clock, posso leggere i dati aggiornati)
- Hazard: problemi dovuti ad accesso delle risorse nelle fasi della pipeline. Come si risolve?
    - Data hazard: problema dovuto all'accesso dei dati che potrebbero non essere ancora stati aggiornati
        - Introdurre ritardi nella pipeline (stallo nel datapath), perdendo dei colpi di clock a vuoto, gli stalli vengono gestiti dell'HW
        - Mezzo clock per scrittura, mezzo clock per lettura (vedi 14), non risolve tutto
        - Forwarding: modificare il datapath aggiungendo un collegamento dall'output dell'ALU a dove voglio
    - Structural Hazard: accesso in contemporanea a una risorsa da più parti diverse
    - Control Hazard: se sto eseguendo una jump può venire lanciata la fetch dell'istruzione successiva anche se questa non dovrebbe essere eseguita

# ECCEZIONI
- Quando viene inserita un'istruzione che non è valida (es. non esiste l'opcode) vogliamo venga lanciato un programma di gestione
- Ci sono due eventi inattesi: eccezioni e interruzioni
- Eccezione: evento sincrono, generato all'interno del processore e provocato da problemi nell'esecuzione di un'istruzione (overflow, istruzione non valida...)
- Interruzione: evento asincrono, giunge dall'esterno del processore, solitamente quando si verificano certi eventi da I/O (esempio quando una periferica è pronta per essere usata dopo la richiesta del processore)
- Cosa fa il gestore?
    - Eccezione: cerca di riprendere l'esecuzione dopo aver sistemato il problema
    - Interruzione: sospendere l'esecuzione del programma, gestire l'interruzione e riprendere l'esecuzione del programma
      N.B. Viene prima portata a completamento l'istruzione corrente, prima di gestire l'interrupt
- E' l'HW che deve essere in grado di gestire la situazione! Quando viene ricevuta un'eccezione/interruzione, e' necessario
    - Interrompere l'esecuzione del programma corrente: salto al gestore (cambio PC)
    - Salvare lo stato di esecuzione corrente (es. PC), ed è per questo che è necessario l'HW apposito
    - Salto a una routine dell'OS
- Il gestore delle eccezioni deve capire cosa è successo: 
    - MIPS: l'errore viene scritto nel registro `cause` prima di saltare all'handler dell'OS (operazione HW). L'indirizzo Exception Program Counter contiene il PC dell'istruzione sospesa
    - Interruzioni vettorizzate: handler diversi per eccezioni diverse
- Se prendiamo due casi di errori sincroni (codice sbagliato, intercettato in decode, e overflow, intercettato durante execute)
    - Opcode sbagliato viene rilevato nell'unità di controllo, mentre l'overflow viene intercettato dall'ALU