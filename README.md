# Obligatorisk oppgave 3 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* Jon Petter Wiig, s364697@oslomet.no


# Oppgavebeskrivelse

I oppgave 1 så tok jeg inspirasjon fra [programmkode 5.2.3 a](https://www.cs.hioa.no/~ulfu/appolonius/kap5/2/kap52.html#5.2.3). Det pogrammkoden gjør er den bruker en comparator til å sjekke hvilket barn som skal bli lagt til. Hvis noden som er nå er større så går den til venstre, hvis den er større så går den til høyre. 

                            10
                          /    \
                         5      15 
                        / \     / \
                       4   6   8   21
                              /
                             7  
*--treets oppbygning bruk av kode (tilfeldig tall)*

I oppgave 2 så brukte jeg comparatoren igjen med å sjekke de forskjellige nivåene i treeet. Jeg valgte å bruke nivåordent(fra venstre til høyre fra hvert nivå før man gikk videre) til å traverse igjennom treet og sjekke. Dette er fordi at det var lettere i øyeblikket å gjøre. Her var det også viktig at oppgave 1 var riktig, hvis ikke så fungerte ikke oppgave 2, så jeg måtte gå litt tilbake i oppgave 1 for  å sjekke at alt fungerte, da man **TEKNISK SETT** kan bestå testen med å bare skrive  `Antall++` i slutten av metoden.

I oppgave 3 så 

I testen så valgte jeg å kommentere ut testene for oppgave 5 & 6, dette er fordi at jeg har lyst til å gjøre disse på en seperat branch, men vil ha en fungerende oblig som har minstekravene. Dette er ting som jeg vet at det er godt mulig at jeg ikke får på plass før innleveringsfristen. 