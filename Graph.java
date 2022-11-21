
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;

public class Graph {
public static	int[] tempor�res_result;

public static	int[] results;

public static	int[] tempor�re_matrix;

	public static void main(String[] args) throws IOException {

		int[][] graph_big = new int[1000][1000];
		int zeile = 0;

		String line = "";
		String lineArray[];

		String splitBy = ",";

		// Matrix aus der Datei in ein Array laden
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader("src/big_graph.txt"));
			while ((line = reader.readLine()) != null) {
				lineArray = line.split(splitBy);
				for (int i = 0; i < lineArray.length; i++) {
					graph_big[zeile][i] = Integer.parseInt(lineArray[i]);
				}
				zeile++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int white = -1;
		int grey = -2;
		int black = -3;

		tempor�res_result = new int[graph_big.length];

		results = new int[graph_big.length];

		tempor�re_matrix = new int[graph_big.length];

		// Wir f�rben alle Knoten wei�
		for (int i = 0; i < tempor�re_matrix.length; i++) {
			tempor�re_matrix[i] = white;
		}

		// wir betrachten jeden bisher noch nicht erledigten, also schwarzen Knoten 
		for (int i = 0; i < tempor�re_matrix.length; i++) {
			if (tempor�re_matrix[i] == white) {

				// results- und tempor�res_result- Arrays f�llen wir mit negativen Werten
				for (int n = 0; n < results.length; n++) {
					results[n] = -5;
				}
				for (int n = 0; n < tempor�res_result.length; n++) {
					tempor�res_result[n] = -5;
				}

				int count = 0;

				// den Knoten, den wir uns anschauen f�rben wir schwarz und rufen DFS auf
				tempor�re_matrix[i] = black;
				DFS(graph_big, -1, -2, -3, count, i);

				// Ergebnis des DFS in result-Array speichern
				results = tempor�res_result;

				for (int j = 0; j < tempor�re_matrix.length; j++) {
					// alle grau gef�rbten Knoten vom DFS wieder wei� f�rben
					if (tempor�re_matrix[j] == grey) {
						tempor�re_matrix[j] = white;
					}
					// alle Knoten aus der gefudenen starken Zusammenhangskomponente schwarz f�rben
					if (results[j] != -5) {
						tempor�re_matrix[results[j]] = black;
					}
				}
				int length = 0;

				// die Knoten-Werte um eins erh�hen (da kein Knoten 0 existiert)
				for (int k = 0; k < results.length; k++) {
					if (results[k] != -5) {
						results[k] += 1;
						length++;
					}
				}

				// result in ein output-Array mit passender Gr��e umf�llen
				int[] output = new int[length];
				for (int k = 0; k < output.length; k++) {
					output[k] = results[k];
				}

				// zuletzt geben wir die starke Zusammenhangskomponenten aus
				System.out.println(Arrays.toString(output));
			}
		}
	}

	public static void DFS(int[][] graph_big, int white, int grey, int black,
			int count, int i) {

		// aktuellen Knoten speichern
		tempor�res_result[count] = i;
		count++;

		tempor�re_matrix[i] = grey;
		for (int s = 0; s < graph_big[0].length; s++) {

			// wenn sich der n�chste erreichbare Knoten schon in dem Pfad befindet brechen wir
			// ab, da schon eine starke Zusammenhangskomponente gefunden wurde
			if (graph_big[i][s] == 1 && tempor�re_matrix[s] == black) {
				break;

				// sonst rufen wir DFS mit dem n�chstem erreichbarem Knoten rekursiv auf
			} else if (graph_big[i][s] == 1 && tempor�re_matrix[s] == white) {
				DFS(graph_big, -1, -2, -3, count, s);
				break;
			}

			// konnte keine Schleife gefunden werden, so wird der gefundene Pfad verworfen
			if (s == graph_big[0].length - 1) {
				for (int n = 1; n < tempor�res_result.length; n++) {
					tempor�res_result[n] = -5;
				}
				count = 0;
			}
		}
	}
}