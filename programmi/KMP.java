public class KMP {

    public static void main(String[] args) {
        String text = "ABABABCABABABCABABC";
        String pattern = "ABABC";
        KMPSearch(pattern, text);
    }

    private static int[] computeLSP(String pattern) {
        int m = pattern.length();
        int[] LSP = new int[m]; // Inizializzazione della tabella LSP
        int j = 0;  // Lunghezza del prefisso più lungo trovato
    
        for (int i = 1; i < m; i++) {  // Scorriamo il pattern dal secondo carattere
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = LSP[j - 1];  // Torna indietro al valore precedente di LSP
            }
            
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;  // Aumentiamo la lunghezza del prefisso più lungo
            }
    
            LSP[i] = j;  // Salviamo il valore nella tabella
        }
    
        return LSP;
    }
 
    private static void KMPSearch(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();
        int[] LSP = computeLSP(pattern); // Precomputiamo la tabella LSP
        int j = 0; // Indice nel pattern
    
        for (int i = 0; i < n; i++) { // Scansioniamo il testo
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = LSP[j - 1]; // Torniamo indietro nel pattern
            }
    
            if (text.charAt(i) == pattern.charAt(j)) {
                j++; // Avanziamo nel pattern
            }
    
            if (j == m) { // Se abbiamo trovato tutto il pattern
                System.out.println("Pattern trovato alla posizione " + (i - m + 1));
                j = LSP[j - 1]; // Cerchiamo altre occorrenze
            }
        }
    }
    
}