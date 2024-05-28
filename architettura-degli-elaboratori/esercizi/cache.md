# Cache

## Esercizio 1a
- In una cache a mappatura diretta con 32 blocchi da 1 word, quali indirizzi di parole di memoria sono mappati nel blocco 13?
    - Se la cache è a mappatura diretta, vengono usati 5 bit per memorizzare l'indice
    - Quindi, tutti gli indirizzi che hanno come ultimi 5 bit il valore 13=01101

## Esercizio 1b
- L'indirizzo della parola di memoria 301 viene mappato nel blocco 13 di una cache da 32 blocchi o da 64 blocchi?
    - 301 = 0x12D = 0001 0010 1101
    - In una cache da 32 blocchi, il campo indice è formato da 5 bit =>  01101
    - In una cache da 64 blocchi, il campo indice è formato da 6 bit => 101101
    - L'indirizzo fornito non può essere mappato nel blocco 13 di una cache a 64 bit => 32 bit

## Esercizio 1c
- Qual è l'indirizzo della word contenuta nel blocco con indice <i>IND</i> e con etichetta <i>TAG</i>, se la cache è a <i>x</i> blocchi da 1 word?
- Se la cache ha 8 blocchi, quali sono indice e etichetta dell'indirizzo 19?
    - La cache ha 3 bit per l'indice
    - 19 = 10011 => l'indirizzo 19 avrà come indice 011 e tag 10

## Esercizio 2
- Consideriamo una cache a mappatura diretta a 8 blocchi da 1 word vuota
- Data la sequenza di accessi 22, 26, 22, 26, 16, 3, 16, 18, 16 qual è la sequenza di hit/miss? Come cambia il contenuto della cache ad ogni miss?
    - Sequenza: miss, miss, hit, hit, miss, miss, hit, miss, hit

| ID  | TAG | V | Value |
| --- | --- | - | ----- |
|     |     |   |       |

| ID  | TAG | V |
| --- | --- | - |
| 110 |  10 | 1 |

| ID  | TAG | V |
| --- | --- | - |
| 110 |  10 | 1 |
| 010 |  11 | 1 |

| ID  | TAG | V |
| --- | --- | - |
| 110 |  10 | 1 |
| 010 |  11 | 1 |

| ID  | TAG | V |
| --- | --- | - |
| 110 |  10 | 1 |
| 010 |  11 | 1 |
| 000 |  10 | 0 |

| ID  | TAG | V |
| --- | --- | - |
| 110 |  10 | 1 |
| 010 |  11 | 1 |
| 000 |  10 | 1 |
| 011 |  00 | 1 |

| ID  | TAG | V |
| --- | --- | - |
| 110 |  10 | 1 |
| 010 |  10 | 1 |
| 000 |  10 | 1 |
| 011 |  00 | 1 |

## Esercizio 3
- In una cache a mappatura diretta in cui ogni blocco contiene due word quale è il valore del TAG per la parola di memoria con indirizzo 301?
    - Non so quanti blocchi sono => non so i bit del campo indice, mettiamo <i>n</i>
    - Ogni blocco contiene due word, quindi verrà usato il bit finale per distinguere le word
    - 301 = 1001 0110 1
    - Se ci sono 4 bit per l'indice, allora l'indirizzo 301 ha come tag 1001

## Esercizio 4a
- Data una cache a mappatura diretta con blocchi di 4 parole e una dimensione totale di 32 parole, assumendo indirizzi di parola a 16 bit, determinare il numero di bit per etichetta, indice e parola
    - Se la dimensione totale è di 32 parole, ci sono 8 blocchi => sono usati 3 bit per il campo indice
    - Ogni blocco contiene 4 parole, quindi sono necessari due bit per distinguere le parole
    - Rimangono 11 bit per il tag

## Esercizio 4b
- Data una cache a mappatura diretta con blocchi di 4 parole e una dimensione totale di 32 parole, viene data la seguente sequenza di indirizzi di parola a cui si vuole accere: 1, 4, 8, 5, 33, 66, 32, 56, 9, 11, 4, 43, 88, 6, 32
- Determinare il numero di miss e hit
    - Indirizzi di parola: 1, 4, 8, 5, 33, 66, 32, 56, 9, 11, 4, 43, 88, 6, 32
    - Indirizzi di blocco: 0, 1, 2, 1,  8, 16,  8, 14, 2, 2,  1, 10, 22, 1,  8
    - Blocco della cache:  0, 1, 2, 1,  0,  0,  0,  6, 2, 2,  1,  2,  6, 1,  0
    - Sequenza: 