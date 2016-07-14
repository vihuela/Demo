package com.hadlink.design_patterns.observer.update;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ricky.yao on 2016/7/14.
 */
public class EventHandler {
    private List<Event> objects = new ArrayList<>();
    private boolean changed = false;

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public void addEvent(Object object, String methodName, Object... args) {
        synchronized (this) {
            Event event = new Event(object, methodName, args);
            if (!objects.contains(event))
                objects.add(event);
        }
    }

    public void notifyX() throws Exception {
        int size;
        Event[] arrays = null;
        synchronized (this) {
            if (isChanged()) {
                size = objects.size();
                arrays = new Event[size];
                objects.toArray(arrays);
            }
        }
        if (arrays != null) {
            for (Event e : arrays) {
                e.invoke();
            }
        }
    }
}