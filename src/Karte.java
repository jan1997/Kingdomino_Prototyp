import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PApplet;
import processing.core.PShape;

import static processing.core.PConstants.RECT;

enum GEBIET
{
    FELD, WIESE, SUMPF, WALD, GEBIRGE, SEE
}
public class Karte
{
    private float x,y,w,h;
    public static final int MAXKARTE = 48;
    private GEBIET gebiet_oben, gebiet_unten;
    private PShape rectangle1, rectangle2;
    private int nummer;

    public Karte(GEBIET gebiet_oben, GEBIET gebiet_unten, int nummer, PApplet parent){
        this.gebiet_oben = gebiet_oben;
        this.gebiet_unten = gebiet_unten;
        this.nummer = nummer;
        parent.shapeMode(PConstants.CENTER);
        this.rectangle1 = parent.createShape(RECT,x,y,w,h/2);
        this.rectangle2 = parent.createShape(RECT,x,y+h/2,w,h/2);
    }

    public Karte(float x, float y, float w, float h, PApplet parent)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public PShape getRectangle1()
    {
        return rectangle1;
    }

    public PShape getRectangle2()
    {
        return rectangle2;
    }

    public static Karte[] alleKarten(PApplet parent){
        Karte[] arr = new Karte[48];
        int counter = 0;
        for (int i = 0; i < 48; i++)
        {
            arr[counter++] = new Karte(GEBIET.FELD,GEBIET.GEBIRGE,i,parent);
        }
        return arr;
    }
    public GEBIET getGebiet_oben()
    {
        return gebiet_oben;
    }

    public GEBIET getGebiet_unten()
    {
        return gebiet_unten;
    }


    public float getX()
    {
        return x;
    }

    public void setX(float x, PApplet parent)
    {
        this.x = x;
        upateRectangle(x, parent, y);
    }

    private void upateRectangle(float x, PApplet parent, float y)
    {
        parent.fill(120,255,0);
        this.rectangle2 = parent.createShape(RECT,x, y +h/2,w,h/2);
        parent.fill(255,255,0);
        this.rectangle1 = parent.createShape(RECT,x, y,w,h/2);
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y, PApplet parent)
    {
        this.y = y;
        upateRectangle(x, parent, y);
    }

    public float getW()
    {
        return w;
    }

    public void setW(float w)
    {
        this.w = w;
    }

    public float getH()
    {
        return h;
    }

    public void setH(float h)
    {
        this.h = h;
    }
}
