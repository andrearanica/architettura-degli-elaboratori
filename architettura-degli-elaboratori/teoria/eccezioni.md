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