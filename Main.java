import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Giocatore> giocatori = new ArrayList<>();
        ArrayList<Integer> listaEstratti = new ArrayList<>();
        
        // Creazione cartelle e giocatori
        for (int i = 1; i <= 4; i++) {
            Cartella cartella = new Cartella();
            Giocatore giocatore = new Giocatore(cartella, "Giocatore" + i);
            giocatori.add(giocatore);
        }

        Tombola partita = new Tombola(giocatori, listaEstratti);

        System.out.println("Inizio partita!");

        // Estrarre numeri finché non c'è un vincitore
        String vincitori;
        do {
            int numeroEstratto = partita.estrazione();
            System.out.println("Numero estratto: " + numeroEstratto);
            vincitori = partita.controllaVincitori();
            System.out.println("Premi parziali: ");
            for (Giocatore giocatore : giocatori) {
                System.out.println(giocatore.getNome() + " ha ottenuto: " + giocatore.getListaPremi());
            }
        } while (vincitori.equals("Ancora nessun vincitore"));

        System.out.println(vincitori);
        System.out.println("Fine partita!");
    }
}