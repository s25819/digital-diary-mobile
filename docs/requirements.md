Pamiętnik Cyfrowy
Celem zadania jest stworzenie aplikacji mobilnej, która umożliwi użytkownikom tworzenie i przechowywanie spersonalizowanych wpisów w formie pisemnej, wraz z możliwością dodawania zdjęć oraz nagrań głosowych.

## Wymagania funkcjonalne:
* Tworzenie wpisów: Użytkownik może tworzyć wpisy zawierające notatki tekstowe wraz z markerem lokalizacji (na podstawie aktualnej lokalizacji pozyskanej z np GPSa do notatki zostanie dodana nazwa miejscowości gdzie została sporządzona notatka [3p]). 

* Oprócz tego do każdej notatki można dodać zdjęcie [1p] i nagranie głosowe [2p], które zostanie zrobione przy tworzeniu notatki.

* Edycja wpisów: Każdy wpis może być edytowany po jego stworzeniu. [brak spełnienia kryterium: -5p]

* Zapis danych: Wszystkie wpisy powinny być zapisywane w zewnętrznej bazie danych (np: Firebase lub własne API). [3p]

* Dodawanie napisów do zdjęć: Użytkownik ma możliwość dodania tekstowego opisu bezpośrednio (rysowanie po obrazie) na zdjęciu przed zapisaniem go w wpisie. [2p]

* Przeglądanie wpisów: Użytkownik może przeglądać wszystkie wpisy w aplikacji. [brak spełnienia kryterium: -5p]

* Zabezpieczenie pamiętnika: Użytkownik uruchamiający aplikację musi wprowadzić hasło lub pin aby uzyskać dostęp do zawartości pamiętnika w aplikacji. [1p]

* Mapa: Aplikacja posiada osobny ekran mapy z zaznaczonymi wpisami tam gdzie zostały one dokonane. [2p]

* Aplikacja powinna powiadamiać (powiadomienie w status barze [2p]) o wkroczeniu w zasięg (ok. 1 km) dowolnego miejsca dokonania któregoś z wpisów (mechanizm Geofence lub inny analogiczny [3p]).

## Wymagania techniczne:

* Wszelkie literały powinny zostać umieszone w zasobach (res/values) tak aby możliwe było ich przetłumaczenie na inne języki [1p]

* Przed poddaniem projektu ocenie należy przygotować zestaw danych przykładowych wczytywany podczas uruchomienia aplikacji, w celu zaprezentowania wszystkich funkcjonalności. (najlepiej dane te umieścić bezpośrednio w kodzie aplikacji) [brak spełnienia kryterium: -2p]