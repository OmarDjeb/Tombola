import java.util.ArrayList;
import java.util.Random;

public class Tombola {
    
    private ArrayList<Giocatore> giocatori;
    private ArrayList<Integer> listaEstratti;

    public Tombola(ArrayList<Giocatore> giocatori, ArrayList<Integer> listaEstratti) {
        this.giocatori = giocatori;
        this.listaEstratti = listaEstratti;
    }

    public ArrayList<Giocatore> getGiocatori() {
        return giocatori;
    }

    public void setGiocatori(ArrayList<Giocatore> giocatori) {
        this.giocatori = giocatori;
    }


    public ArrayList<Integer> getListaEstratti() {
        return listaEstratti;
    }

    public void setListaEstratti(ArrayList<Integer> listaEstratti) {
        this.listaEstratti = listaEstratti;
    }

    //metodi

    public int estrazione()
    {
        Random random = new Random();
        int num_estratto;
        do{
            num_estratto= random.nextInt(90)+1;
        }while(listaEstratti.contains(num_estratto));
        
        listaEstratti.add(num_estratto);
        for (Giocatore giocatore : giocatori) 
        {
            giocatore.segnaNum(num_estratto);
            giocatore.controllaPremi();
        }
        return num_estratto;
    }

    public String controllaVincitori() {
        StringBuilder vincitori = new StringBuilder("I vincitori sono: ");
        boolean vittoria = false;
    
        for (Giocatore giocatore : giocatori) {
            if (giocatore.getListaPremi().contains("Tombola")) {
                vincitori.append(giocatore.getNome()).append(", ");
                vittoria = true;
            }
        }
    
        return vittoria ? vincitori.toString() : "Ancora nessun vincitore";
    }


}
