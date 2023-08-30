# Arsenał (07.2021)
Konsolowa aplikacja umożliwiająca zarządzanie kolekcją broni palnej. 

Uruchamianie aplikacji w katalogu głównym projektu poprzez komendę:
```
java -jar arsenal.jar
```

## Wymagania funkcjonalne gry:
* Dodanie nowej broni w oparciu o następujące cechy:
    * nazwa, 
    * wersja, 
    * kaliber, 
    * pojemność magazynka,
    * typ,
    * liczba sztuk w magazynie.
* Edytowanie broni,
* Usunięcie broni,
* Zapisanie stanu arsenału do pliku binarnego,
* Wczytanie stanu arsenału z pliku binarnego,
* Wyświetlenie kolekcji (widok szczegółowy oraz ogólny).

## Technologie:
* Java.

## Prezentacja aplikacji:

Menu główne:
```
Menu:
show - Wyswietlenie kolekcji
add - Dodanie broni
edit - Edytowanie broni
remove - Usuniecie broni
save - Zapisz kolekcje do pliku
read - Wczytaj kolekcje z pliku
exit - Wylaczenie programu

Wprowadz odpowiednia komende: 
```

Dodanie broni:
```
Wprowadz odpowiednia komende: add
Prosze wprowadzic nazwe broni: M4
Prosze wprowadzic wersje: 1
Prosze wprowadzic kaliber: 5,56
Prosze wprowadzic liczbe pociskow w magazynku: 30
Prosze wprowadzic wage calkowita broni: 3
Prosze wprowadzic typ broni (Shogun, Pistol, Rifle): Rifle
Prosze wprowadzic liczbe broni: 2
```

Edytowanie broni:
```
Wprowadz odpowiednia komende: edit
Podaj nazwe zasobu: Ak
Podaj wersje zasobu: 47
Podaj kaliber broni: 9

Opcje:
name - Nazwa
version - Wersja
caliber - Kaliber
magazine - Rozmiar magazynka
type - Typ broni
number of - Liczba broni

Wprowadz odpowiednia kategorie ktora ma byc zmieniona: caliber
Wprowadz wartosc: 7,62
```

Usunięcie broni:
```
Wprowadz odpowiednia komende: remove
Podaj nazwe zasobu: Glock
Podaj wersje zasobu: 18
Podaj kaliber broni: 9
Udalo sie usunac zasob
```

Zapisanie stanu arsenału do pliku:
```
Wprowadz odpowiednia komende: save
Podaj nazwe pliku do zapisu: collection.bin
Poprawnie zapisano do pliku
```

Wczytanie stanu arsenału z pliku:
```
Wprowadz odpowiednia komende: read
Podaj nazwe pliku do odczytu: collection.bin
Poprawnie odczytano z pliku
```

Wyświetlenie ogólnych informacji kolekcji:
```
Wprowadz odpowiednia komende: show

Opcje:
generally - ogolne informacje
specifically - szczegolowe informacje

Wprowadz odpowiednia komende: generally

Glock-18 cal 9.0mm
Ak-47 cal 7.62mm
M4-1 cal 5.56mm
```

Wyświetlenie szczegółowych informacji o kolekcji:
```
...
Wprowadz odpowiednia komende: specifically

Nazwa	 Wersja 	 Kaliber(mm) 	 Rozmiar magazynka 	Waga(g) 	 Typ 	 Liczba sztuk
Glock	   18		     9.0			    30		    1000.0		Pistol		 0
Ak	       47		    7.62		        30		    3000.0		Rifle		30
M4	        1		    5.56		        30		    3000.0		Rifle		 2
```
