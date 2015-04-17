
package turnt;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author Khetthai
 */
public class Engine {
    private PriorityQueue<Directive> directiveQueue;
    private HashMap<String, Event> eventMap;

    public Engine() {
        directiveQueue = new PriorityQueue();
        eventMap = new HashMap<>();
        eventMap.put("MainEvent", new MainEvent());
    }
    
    public void push(Directive directive) {
        directiveQueue.add(directive);
    }
    
    public Directive pop() {
        return directiveQueue.poll();
    }
    
    public boolean hasNext() {
        return !directiveQueue.isEmpty();
    }
    
    public void emitEvent(String event) {
        for(Directive directive : eventMap.get(event).evt()) {
            push(directive);
        }
    }
}
