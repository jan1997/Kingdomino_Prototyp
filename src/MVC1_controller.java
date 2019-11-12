import processing.core.PApplet;

public class MVC1_controller
{
    MVC1_viewer viewer = null;
    MVC1_model model = null;

    public MVC1_controller() {
    }
    public void setViewer( MVC1_viewer v ) {
        viewer = v;
    }
    public void setModel( MVC1_model m ) {
        model = m;
    }

    public void run()
    {
        viewer = new MVC1_viewer();
        model = new MVC1_model();
        PApplet.main("MVC1_viewer");
    }
}
