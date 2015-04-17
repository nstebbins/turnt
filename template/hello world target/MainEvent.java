
package turnt;

/**
 *
 * @author Khetthai
 */
public class MainEvent extends Event {
    
    /* Override constructor with registered directives */
    public MainEvent() {
        super.register(new HelloWorld());
    }
    
    /* Override autoemit with condition body */
    
}
