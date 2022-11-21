# Algorithmik_Ubungsblatt_4

## Aufgabe 3
### Programmbeschreibung
Der erste Teil unseres Programms beinhaltet das Einfügen der Datei, die den zu bearbeitenden
Graphen enthält, dessen Inhalt in ein Array namens "graph_Big" geladen wird. <br> 
Danach erstellen wir eine temporäre matrix und ein temporäres Result, wobei wir unsere Temporäre Matrix erstmal weiß färben,
was die noch nicht bearbeiteten Knoten darstellt. <br> 
Daraufhin betrachten wir jeden noch nicht bearbeitenden Knoten und führen für ihn folgende Schritte aus:
Zuerst füllen wir unser temporäres Result mit -5, um es zurückzusetzen. <br> 
Als nächstes färben wir den aktuellen Knoten schwarz und rufen unsere funktion für den Depth-first search auf. <br> 
In unserer Depth-first search Methode suchen wir nach dem nächsten Knoten, der sich schon in unserem Pfad befindet. <br> 
Dafür suchen wir Rekursiv nach dem nächsten erreichbare Knoten und brechen ab, wenn wir entweder den Knoten gefunden haben oder wir so oft rekursiv aufgerufen haben, ohne dass wir eine Schleife finden konnten, dass keine Schleife existieren kann. <br> 
Wenn unsere Depth-first search durch ist, speichern wir unser Ergebnis in unserem result Array und färben unsere grau gefärbten Knoten wieder weiß für die nächste Suche. <br> 
Die starken Zusammenhanskomponenten Knoten, die wir gefunden haben hingegen, färben wir schwarz um sie in der nächsten Suche nicht zu beachten. <br> 
Zuletzt erhöhen wir noch die Knoten Werte um eins und geben unser Result nach Ende der Schleife aus.
