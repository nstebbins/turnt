
package turnt;

/**
 *
 * @author Khetthai
 */
public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.emitEvent("MainEvent");
        while(engine.hasNext()) {
            engine.pop().dir();
        }
    }
}
