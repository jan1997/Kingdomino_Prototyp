import java.util.Random;

public class Kartenstapel
{
    private Karte[] karten = new Karte[Karte.MAXKARTE];
    private int top=0;

    public Kartenstapel()
    {
    }

    public Kartenstapel(Karte[] karten)
    {
        this.karten = karten;
        top= karten.length;
        mischen();
    }

    public void push(Karte karte){
        karten[top]=karte;
        top++;
    }
    public Karte pop(){
        if(!isEmpty()){
            Karte karte = karten[top-1];
            karten[top-1]=null;
            top--;
            return karte;
        }
        return null;
    }
    public boolean isEmpty(){
        boolean flag = false;
        if(top==0){
            flag = true;
        }
        return flag;
    }

    public void mischen(){
        Karte temp;
        int rand;
        Random r = new Random();
        for (int i = 0; i < karten.length; i++)
        {
            rand = r.nextInt(karten.length);
            temp = karten[i];
            karten[i]=karten[rand];
            karten[rand]=temp;
        }

    }

    public Karte[] getKarten()
    {
        return karten;
    }

    public int getAnzahl(){
        return top;
    }
}
