# Cache

## Esercizio 1a
- Cache mappatura diretta con 32 blocchi da 1 word
- Quali indirizzi sono mappati nel blocco 13

- Ogni blocco deve essere riconoscibile, ogni blocco si rappresenta con log2(32) bit => 5 bit
- Nel blocco 13 entrano tutti gli indirizzi in cui gli ultimi 5 bit sono uguali a 13 (01101)
- Quindi entrano gli indirizzi che finiscono con 01101

## Esercizio 1b
- L'indirizzo della parola di memoria 301 fa parte degli indirizzi mappati nel blocco 13 di una cache con blocchi a 32 o 64 bit

- 301 in binario ha gli ultimi 5 bit come il blocco 13, ma non gli ultimi 6 bit

## Esercizio 1c
- La cache ha 8 blocchi da 1 word
1. Quali sono l'indice e l'etichetta dell'indirizzo 19?
    - L'indice è a 3 bit (log2(8))
    - 19 = 10011 => l'indice dell'indirizzo 19 è 011, il tag è 10
2. A quale indirizzo corrisponde il blocco con TAG=11 e IND=011
    - 11011 = 27

## Esercizio 2
- Cache a mappatura diretta a 8 blocchi da 1 word vuota
    - 3 bit per index, 2 bit per tag
- Data la sequenza di accessi 22, 26, 22, 26, 16, 3, 16, 18, 16
1. Qual è la sequenza di hit/miss?
    - Miss, miss, hit
2. Come cambia il contenuto della cache ad ogni miss?

    | Index | Valid | Tag |
    | ----- | ----- | --- |
    | 110   | 00000 | 10  |


    | Index | Valid | Tag |
    | ----- | ----- | --- |
    | 110   | 1     | 10  |
    | 010   | 1     | 10  |


    | Index | Valid | Tag |
    | ----- | ----- | --- |
    | 110   | 1     | 10  |
    | 010   | 1     | 10  |
    | 000   | 1     | 10  |

    [...]

## Esercizio 3
- Cache direct mapped in cui ogni blocco contiene due word (non so quanto è grande l'index)
- Qual è il tag della parola con indirizzo 301?
    - 301 = 1001 0110 1 => index = 1001, tag = 0110, ultimo bit per decidere se prima o seconda word

## Esercizio 4a
- Cache a mappatura diretta con blocchi di 4 parole e una dimensione totale di 32 parole
    - 7 bit per index
    - 8 blocchi => 3 bit per indice
- Indirizzi a 16 bit
- Quanti bit riservati a etichetta, indice e parola?
    - Uso gli ultimi due bit per capire a quale delle 4 parole devo accedere
    - 3 bit per indice
    - 11 bit per il tag

## Esercizio 4b
- Cache a mappatura diretta con blocchi di 4 parole => 8 blocchi => 3 bit per indice
- 