## Sovelluksen kuvaus:

Instabase on sovellus kuvien lisäämiseen ja toisten käyttäjien kuvien selaamiseen, kommentointiin ja tykkäämiseen.



## Toteutetut käyttötapaukset:

- rekisteröidy
- kirjaudu sisään
- kirjaudu ulos
- lisää kuva
- poista kuva
- kommentoi kuvaa
- poista kommentti
- lisää tykkäys
- poista tykkäys
- selaa kaikkien käyttäjien kuvia
- selaa kuvia hastagin avulla
- vaihda kieltä (suomi/englanti)

Tarkemmat kuvaukset keskeisimmistä käyttötapauksista:

Käyttötapaus: Rekisteröidy  
Käyttäjä: User  
Tavoite: Uuden käyttäjätunnuksen rekisteröinti  
Jälkiehto: Käyttäjätunnus rekisteröidään järjestelmään ja siihen liitetään salasana  
Käyttötapauksen kulku:
  1. Käyttäjä aloittaa rekisteröitymisen
  2. Käyttäjä kirjoittaa kirjautumistunnuksen
  3. Käyttäjä kirjoittaa salasanan
  4. Järjestelmä tarkastaa, että käyttäjätunnus on vapaa
  5. Järjestelmä ilmoittaa käyttäjälle rekisteröitymisen onnistumisesta  
Poikkeuksellinen toiminta:  
  2a. Käyttäjätunnuksen tulee olla 3-15 merkkiä pitkä
  3a. Salasanan tulee olla vähintään 5 merkkiä pitkä
  4a. Järjestelmä ei voi hyväksyä varattua käyttäjätunnusta

Käyttötapaus: Kirjaudu sisään  
Käyttäjä: User  
Tavoite: Sisäänkirjautuminen  
Esiehto: Käyttäjä on rekisteröitynyt  
Jälkiehto: Käyttäjä pääsee kirjautumaan sisään sovellukseen  
Käyttötapauksen kulku:
  1. Käyttäjä aloittaa sisäänkirjautumisen
  2. Käyttäjä kirjoittaa kirjautumistunnuksen ja salasanan
  3. Järjestelmä tarkastaa kirjautumisen oikeellisuuden
  4. Järjestelmä ilmoittaa käyttäjälle kirjautumisen onnistumisesta  
Poikkeuksellinen toiminta:  
  3a. Käyttäjä ei voi kirjautua virheellisellä salasanalla

Käyttötapaus: Lisää kuva  
Käyttäjä: User  
Tavoite: Kuvan lisääminen  
Esiehto: Käyttäjä on kirjautunut sisään  
Jälkiehto: Kuva on lisätty onnistuneesti  
Käyttötapauksen kulku:  
  1. Käyttäjä aloittaa kuvan lisäämisen
  2. Käyttäjä valitsee kuvan
  3. Käyttäjä kirjoittaa kuvalle kuvatekstin
  4. Käyttäjä lähettää kuvan sovellukselle
  5. Järjestelmä vastaanottaa kuvan onnistuneesti
  6. Järjestelmä lisää kuvan käyttäjän kuvakokoelmaan  
Poikkeuksellinen toiminta:  
  5a. Kuvan täytyy olla jpg- tai png-formaattia
  
Käyttötapaus: Tykkää kuvasta  
Käyttäjä: User  
Tavoite: Tykkäyksen lisääminen kuvaan  
Esiehto: Käyttäjä on kirjautunut sisään  
Jälkiehto: Tykkäys on lisätty onnistuneesti  
Käyttötapauksen kulku:  
  1. Käyttäjä menee kyseisen kuvan sivulle
  2. Käyttäjä painaa tykkäys-napista
  3. Järjestelmä vastaanottaa tykkäyksen onnistuneesti
  4. Järjestelmä lisää kuvalle yhden tykkäyksen lisää  
Poikkeuksellinen toiminta:  
  4a. Yksi käyttäjä voi lisätä vain yhden tykkäyksen per kuva
  
Käyttötapaus: Kommentoi kuvaa  
Käyttäjä: User  
Tavoite: Kommentin lisääminen kuvaan  
Esiehto: Käyttäjä on kirjautunut sisään  
Jälkiehto: Kommentti on lisätty onnistuneesti  
Käyttötapauksen kulku:  
  1. Käyttäjä menee kyseisen kuvan sivulle
  2. Käyttäjä painaa kirjoittaa kommentin annettuun kenttään
  3. Käyttäjä lähettää kommentin
  4. Järjestelmä vastaanottaa kommentin onnistuneesti
  5. Järjestelmä lisää kommentin kyseisen kuvan kommentteihin  
Poikkeuksellinen toiminta:  
  4a. Kommentti ei voi olla 0 merkkiä pitkä


  
## Kuvaus toteuttamatta jääneistä ominaisuuksista:
- Toisten käyttäjien seuraaminen
- Ulkoasussa parantamisen varaa
