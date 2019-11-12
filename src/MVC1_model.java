public class MVC1_model
{

    private MVC1_viewer viewer         = null;// reference to the viewer of the MVC system
    private MVC1_controller controller = null;// reference to the controller of the MVC system

    public MVC1_model( ) {
    }

    public void setController(MVC1_controller c) {
        controller = c;
    }

    public void setViewer( MVC1_viewer v ) {
        viewer = v;
    }
}
