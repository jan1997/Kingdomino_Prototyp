import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class MVC1_viewer extends PApplet
{
    MVC1_controller controller = null;
    MVC1_model model = null;
    PImage hintergrund, muelleimer;
    Karte karte;
    Kartenstapel kartenstapel;
    Kartenstapel spielkarten = new Kartenstapel();
    int smallPoint, largePoint;
    float cardX, cardY;
    float bdifx = 0.0f;
    float bdify = 0.0f;
    boolean overCard = false, locked = false;
    int gameScreen = 0;
    int mastertest=0;

    public void setModel(MVC1_model m)
    {
        model = m;
    }

    public MVC1_viewer()
    {

    }

    public void settings()
    {
        size(1920, 1080);
    }

    public void setup()
    {
        hintergrund = loadImage("data/background.jpg");
        muelleimer = loadImage("data/trashcan.png");
        Karte[] karten = new Karte[10];
        for (int i = 0; i < 10; i++)
        {
            karten[i] = new Karte(GEBIET.FELD, GEBIET.GEBIRGE, i, this);
        }
        kartenstapel = new Kartenstapel(karten);

        karte = kartenstapel.pop();
        karte.setW(89.5f);
        karte.setH(178.5f);
        karte.setX(200,this);
        setKarte();
        karte.setX(300,this);
        setKarte();
        karte.setX(400,this);
        setKarte();
        karte.setX(500,this);
        karte.setY(686,this);
        spielkarten.push(karte);
    }

    private void setKarte()
    {
        karte.setY(686,this);
        spielkarten.push(karte);

        karte = kartenstapel.pop();
        karte.setW(89.5f);
        karte.setH(178.5f);
    }

    public void draw()
    {
        if (gameScreen == 0) {
            drag_n_drop_Scene();
        } else if (gameScreen == 1) {
            player_change_scene();
        } else if (gameScreen == 2) {
            card_dock_scene();
        }
    }

    private void player_change_scene()
    {
    }

    private void card_dock_scene()
    {
    }

    public void drag_n_drop_Scene(){
        noFill();
        if(spielkarten.getAnzahl()>0)
        {
            karte = spielkarten.getKarten()[spielkarten.getAnzahl() - 1];
            if (karte != null)
            {
                if (overRect(karte.getX(), karte.getY(), karte.getW(), karte.getH()))
                {
                    overCard = true;
                    if (!locked)
                    {
                        stroke(255);
                    }
                } else
                {
                    stroke(153);
                    overCard = false;
                }

                background(hintergrund);
                image(muelleimer, 297, 368, 137, 137);
                drawCards();
                rect(karte.getX(), karte.getY(), karte.getW(), karte.getH());
            } else
            {
                drawCards();
                background(hintergrund);
                image(muelleimer, 297, 368, 137, 137);
            }
        } else
        {
            background(hintergrund);
            image(muelleimer, 297, 368, 137, 137);
        }
    }

    private void drawCards()
    {
        for (int i = 0; i < spielkarten.getAnzahl(); i++)
        {
            shape(spielkarten.getKarten()[i].getRectangle1());
            shape(spielkarten.getKarten()[i].getRectangle2());
        }
    }

    public void mousePressed()
    {
        if(karte!=null)
        {
            locked = overCard;
            bdifx = mouseX - karte.getX();
            bdify = mouseY - karte.getY();
        }
    }

    public void mouseDragged()
    {
        if (locked)
        {
            cardX = mouseX - bdifx;
            cardY = mouseY - bdify;
            karte.setX(cardX,this);
            karte.setY(cardY,this);
        }
        if(overRect(297, 368, 137, 137)){
            stroke(255,0,0);
        }
        else {
            stroke(255);
        }
    }

    public void mouseReleased()
    {
        locked = false;
        if(overRect(297, 368, 137, 137)){
            spielkarten.pop();
        }
    }

    boolean overRect(float x, float y, float width, float height)
    {
        return mouseX > x && mouseX < x + width &&
                mouseY > y&& mouseY < y + height;
    }
}
