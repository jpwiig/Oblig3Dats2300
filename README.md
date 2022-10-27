# Obligatorisk oppgave 3 i Algoritmer og Datastrukturer
# **Oppgaver som ikke er krav av innleveringen** (oppgave 5 og 6)

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

I oppgave 3 så traverserer vi nedover i postorden. Vi sjekker først om p er null, hvis ikke så går vi nedover til vi finner første i postorden, etter det så returnerer vi p, som er den første i postorden. I neste postorden så gjør vi mye av det samme. Se kommentarer i kode. Jeg bruker deler av kompendiet seksjon 5.1.7 (5.1.7 h har jeg brukt som inspriasjonskilde for første postorden, med essensielle endringer for at den skal fungere i koden)

I oppgave 4 så bruker jeg først metodene i oppgave 3 for å gå gjennom hele treet. Jeg bruker førstePostorden(rot) til å finne ut hvor postorden skal starte, da jeg finner første postorden med rotnoden, så bruker jeg nestepostorden() til å traversere resten av treet. 

I den rekurssive så starter vi først med et basistilfelle, før vi da kaller på metoden rekursivt for enten høyre eller venstre basert på om det er en verdi i enten høyre eller venstre barn. 

Alle warningsene er enten for bruk av ÆØÅ -> "non asiic character"
eller ting som gjort i kildekoden (utlevert) -> "field could be final"

I testen så valgte jeg å kommentere ut testene for oppgave 5 & 6, dette er fordi at jeg har lyst til å gjøre disse på en seperat branch, men vil ha en fungerende oblig som har minstekravene. Dette er ting som jeg vet at det er godt mulig at jeg ikke får på plass før innleveringsfristen. 
