
package turnt;

import java.util.HashMap;

/**
 *
 * @author Khetthai
 */
public class State {
    private static HashMap<String, Object> state = new HashMap<>();
    
    public static void changeState(String name, Object toAdd) {
        state.put(name, toAdd);
    }
    
    public static void removeState(String name) {
        state.remove(name);
    }
    
    public static Object getState(String name) {
        return state.get(name);
    }
}
