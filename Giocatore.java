
import java.util.ArrayList;

public class Giocatore {
    private String nome;
    private Cartella cartella;
    private ArrayList<String> listaPremi;
    private static Boolean ambo=true;
    private static Boolean terna=true;
    private static Boolean quaterna=true;
    private static Boolean cinquina=true;

    public Giocatore(Cartella cartella, String nome) {
        this.cartella = cartella;
        this.nome = nome;
        listaPremi= new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cartella getCartelle() {
        return cartella;
    }

    public void setCartelle(Cartella cartella) {
        this.cartella = cartella;
    }

    public ArrayList<String> getListaPremi() {
        return listaPremi;
    }

    public void setListaPremi(ArrayList<String> listaPremi) {
        this.listaPremi = listaPremi;
    }

    public void segnaNum(int n) {
        for (ArrayList<Integer> riga : cartella.getCartella()) {
            if (riga.contains(n)) {
                cartella.getSegnati().add(n);
                break;
            }
        }
    }

    public Boolean Tombola()
    {
        int conta=0;

        for(int j=0;j<3;j++)
        {
            for(int i=0;i<5;i++)
            {
                if(cartella.getSegnati().contains(cartella.getCartella().get(i).get(j)))
                {
                    conta+=1;
                }
            }
        }
        if(conta==15)   return true;
        else    return false;
    }

    public void controllaPremi() {
        for (int j = 0; j < 3; j++) { 
            int conta = 0;
            for (int i = 0; i < 5; i++) {
                if (cartella.getSegnati().contains(cartella.getCartella().get(i).get(j))) {
                    conta++;
                }
            }
            switch (conta) {
                case 2:
                    if (ambo) {listaPremi.add("Ambo"); ambo=false;}
                    break;
                case 3:
                    if (terna) {listaPremi.add("Terna");terna=false;}
                    break;
                case 4:
                    if (quaterna) {listaPremi.add("Quaterna");quaterna=false;}
                    break;
                case 5:
                    if (cinquina) {listaPremi.add("Cinquina");cinquina=false;}
                    break;
            }
        }
        if (Tombola() && !listaPremi.contains("Tombola")) {
            listaPremi.add("Tombola");
        }
    }

}

