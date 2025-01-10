
import java.util.ArrayList;
import java.util.Random;

public class Cartella
{
    //attributi
    private ArrayList<ArrayList<Integer>> cartella;
    private ArrayList<Integer> segnati;

    public Cartella() {
        cartella= new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<5;i++)
        {
            cartella.add(new ArrayList<>());
            for(int j=0;j<3;j++)
            {
                cartella.get(i).add(random.nextInt(90)+1);
            }
        }
        this.segnati = new ArrayList<>();
    }

    public ArrayList<ArrayList<Integer>> getCartella() {
        return cartella;
    }

    public void setCartella(ArrayList<ArrayList<Integer>> cartella) {
        this.cartella = cartella;
    }

    public ArrayList<Integer> getSegnati() {
        return segnati;
    }

    public void setSegnati(ArrayList<Integer> segnati) {
        this.segnati = segnati;
    }




    

}