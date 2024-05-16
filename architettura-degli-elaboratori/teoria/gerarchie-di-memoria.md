# Gerarchie di memoria
- All'interno dell'elaboratore sono presenti diversi tipi di memorie
- Sono organizzati in una forma piramidale (gerarchica): più sono vicine al processore, più sono veloci (per sfruttare la velocità del processore)
    - Es. HDD costano poco e sono lenti, sono lontani dal processore
- Un programma non accede a tutte le sue istruzioni e a tutti i suoi dati contemporaneamente
    - Organizziamo le memorie con una gerarchia, in cui la CPU ha accesso diretto alle memorie del primo livello della piramide: le <b>cache</b>
- Per fornire un dato da un livello inferiore alla CPU, il sistema operativo deve cercare (algoritmi di rimpiazzamento) e prendere l'informazione in quella memoria e trasportarla nel primo livello
    - Per principio di spazialità l'informazione viene trasportata per livelli adiacenti fino alla CPU

## Gerarchie di memoria
- <b>Memoria interna</b> della CPU: costituita dai registri, con alta velocità e limitate dimensioni
- <b>Memoria centrale</b>: dimensioni e tepmi di accesso maggiori, accessibile in modo diretto tramite indirizzi
    - Nei sistemi moderni tra CPU e memorie centrali è stato inserito un livello di memorie di <b>cache</b>
- Quando eseguiamo il programma, in un istante di tepmo accediamo a una porzione ridotta del suo spazio di indirizzmento
- Per rendere efficiente l'esecuzione, vengono predisposti dei meccanismi per spostare le informazioni nei vari livelli di memoria per arrivare fino alla CPU
- Questo meccanismi si basano sui principi di:
    - <b>Località temporale</b>: qunado si fa riferimento ad un elemento (istruzione o dato), si tende a fare riferimento allo stesso elemento dopo poco tempo
    - <b>Località spaziale</b>: qunado si fa riferimento ad un elemento (istruzione o dato), si tende a fare riferimento ad altri elementi vicini (in indirizzamento) all'elemento che stiamo considerando
- I programmi referenziano i dati come se fossero sempre in <b>memoria centrale</b>
    - Bisogna mantenere vicini alla CPU i dati utilizzati più frequentemente e più recentemente
- Serve fare un compromesso tra costo, velocità e vicinanza al processore
- N.B. Un livello di memoria contiene solo un sottoinsieme dei dati memorizzati in ogni livello sottostante => tutti i dati sono memorizzati a livelli più bassi

## Definizioni
- <b>Blocco/linea</b>: quantità più piccola di informazione che può essere presente/assente in una gerarchia di memoria
- <b>Hit</b>: l'informazione richiesta dal processore è disponibile in uno dei blocchi di memoria del livello che stiamo esaminando
- <b>Miss</b> opposto di hit
- <b>Hit/miss rate</b>: frazione degli accessi ad un livello di memoria in cui l'informazione è stata trovata/non trovata (quante volte su tutte le richieste la rierca è andata a buon fine o no)
    - Miss rate = 1 - Hit rate
- <b>Tempi di hit</b>: quando viene fatta una richiesta e si verifica se il dato è presente, viene fatta una ricerca e l'elemento è stato trovato; il tempo comprende sia la ricerca che la generazione dell'hit/miss
- <b>Tempo di miss</b>: comprende il tempo di ricerca, verifica e il tempo necessario a sostituire il blocco del livello a cui siamo, andando a prelevare l'informazione da un livello inferiore
    - Tmiss = Verifica + accesso al livello + trasferimento

## Cache
- Livello di memoria tra processore e memoria principale
- Qualsiasi memoria che usa il principio di località degli accessi
- Il programma non vede la cache (viene gestita dall'OS)
- Quando il processore chiede una word che non è presente nella cache viene generato un miss, e l'informazione viene trasferita dalla memoria centrale alla cache per portarla al processore
    - E' necessario conoscere se l'informazione è presente o meno in cache: il processore chiede l'informazione alla cache
    - Se non c'è il dato, bisogna conoscere la sua locazione ed accedere al dato
        - Accendendo, può darsi che il dato non sia in quella posizione, oppure quella locazione potrebbe non contenere un dato valido
- Vogliamo sapere se l'indirizzo contiene il dato di cui abbiamo bisogno (nel minor tempo possibile!)
    - Algoritmi di Caching: mantengono i dati richiesti recentemetne vicino alla CPU (località temporale) e muovono blocchi contigui di memoria (località spaziale)

- <b>Cache a mappatura diretta</b>: a ciascun blocco della memoria centrale corrisponde una specifica locazione della cache (non il contrario)
    - In una posizione della cache possiamo avere accesso a diversi elemneti della memoria
    - Es. una linea di cache (10) referenzia due elementi che hanno gli ultimi due bit corrispondenti a 10
    - Nascono dei conflitti
- <b>Cache fully associative</b>: ogni blocco della memoria centrale può essere posizionato all'interno di qualunque locazione della cache
    - Quando bisogna cercare un blocco all'interno della cache dobbiamo scorrere in modo sequenziale tutte le linee della cache
    - Risolve nativamente i conflitti
    - Politiche di ricerca costose
- <b>Cache set associative</b>: ibrida tra mappatura diretta e fully associative, ciascun blocco della memoria è associato a >=2 locazioni della cache
    - Rapporto 1:n tra memoria centrale e cache

### Cache a mappatura diretta
- Associano una sola locazione di memoria ad una parola della nostra memoria centrale: corrispondenza tra una parola di memoria e la propria locazione della cache
    - Un indice può puntare a più elementi
- All'interno della sequenza di bit con cui accedere ad un elemento della cache ci sono:
    - Tag: insieme di bit che contiene tutte le informazioni che verificano se una determinata word della cache corrisponde alla parola (dettaglia di più quale indirizzo sta mappando)
    - Indice: selezionare il blocco della cache
    - Offset: bit per selezionare il byte richiesto dalla parola
    - [...]
- Una linea di cache contiene:
    - 1 bit di validità: indica se i dati contenuti nella linea di cache sono validi (all'avvio tutte zero)
    - Tag: individua in modo univoco il blocco di memoria che è stato mappato nella linea di cache
    - Blocco di dati (una o più parole)
- In pratica, su 32 bit: 
    - I 10 bit meno significativi dell'indirizzo della memoria principale indicano l'indirizzo della cache in cui mappo l'indirizzo di memoria
    - I 20 bit più significativi dell'indirizzo verificano se l'elemento è presente all'interno della cache: se questi bit sono uguali al campo tag e il bit di validità in cache è uguale 1, il dato è presente e valido
        - Il controllo di uguaglianza controlla che il campo tag della cache e il campo tag dell'indirizzo siano uguali, e il risultato va in AND con il bit di validità per fornire l'HIT

- Se la cache genera un hit, il processore continua il processamento
- In caso di miss, il processore viene messo in stallo come nel pipelining in attesa di ricevere l'elemento in memoria (la cache lo deve prelegare)
    - Viene inviato l'indirizzo al controller della memoria e viene trasferito in cache
- La frequenza di miss si riduce all'aumentare della dimensione dei blocchi