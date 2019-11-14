# oslobysykkel

Enkel rest-applikasjon som tilbyr data konsumert fra https://oslobysykkel.no/apne-data/sanntid 

## Tilgjengelige endepunkter 
Henter alle stasjoner
```
/
```
<br/>Henter alle fulle stasjoner
```
/fulle
```
<br/>Henter alle tomme stasjoner
```
/tomme
```
<br/>Henter en stasjon
```
/id/{station_id}
```
## Teknologi
* Java 12.0.1
* Apache Maven 3.6.2 

## Starte applikasjonen
```
cd .\oslobysykkel\
mvn clean install
java -jar .\target\oslobysykkel-1.0-SNAPSHOT.jar
```
