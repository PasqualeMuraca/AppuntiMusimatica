public class EditDistance {
    public static void main(String[] args) {
        // Test della funzione
        String str1 = "torta";
        String str2 = "parlare";
        int distance = computeED(str1, str2);
        System.out.println("Edit Distance tra \"" + str1 + "\" e \"" + str2 + "\": " + distance);
    }

    public static int computeED(String m1, String m2) {
        int len1 = m1.length();
        int len2 = m2.length();
        int[][] d = new int[len1 + 1][len2 + 1];
        char[][] s = new char[len1 + 1][len2 + 1]; // Cambiato in char[][]

        // Inizializzazione delle matrici
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                d[i][j] = 0;
                s[i][j] = ' ';
            }
        }

        // Inizializzazione della prima riga e prima colonna
        for (int i = 1; i <= len1; i++) {
            d[i][0] = i;
            s[i][0] = 'D'; // Cancellazione
        }
        for (int j = 1; j <= len2; j++) {
            d[0][j] = j;
            s[0][j] = 'I'; // Inserimento
        }

        // Riempimento delle matrici
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (m1.charAt(i - 1) == m2.charAt(j - 1)) { // Confronto corretto
                    d[i][j] = d[i - 1][j - 1];
                    s[i][j] = 'E'; // Nessuna modifica
                } else {
                    int substitution = d[i - 1][j - 1] + 1;
                    int deletion = d[i - 1][j] + 1;
                    int insertion = d[i][j - 1] + 1;
                    
                    d[i][j] = Math.min(substitution, Math.min(deletion, insertion));

                    // Salvataggio operazione usata
                    if (d[i][j] == substitution) {
                        s[i][j] = 'S'; // Sostituzione
                    } else if (d[i][j] == deletion) {
                        s[i][j] = '^'; // Cancellazione
                    } else {
                        s[i][j] = '<'; // Inserimento
                    }
                }
            }
        }

        // Stampa della matrice delle distanze
        System.out.println("Matrice delle distanze:");
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }

        // Stampa della matrice delle operazioni
        System.out.println("\nMatrice delle operazioni:");
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }

        return d[len1][len2]; // Restituisce la distanza finale
    }
}
