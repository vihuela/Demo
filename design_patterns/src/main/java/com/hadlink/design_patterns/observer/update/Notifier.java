package com.hadlink.design_patterns.observer.update;

/**
 * @author ricky.yao on 2016/7/14.
 */
public abstract class Notifier {
    private EventHandler eventHandler = new EventHandler();

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public void setChange(boolean change) {
        eventHandler.setChanged(change);
    }

    /**
     * @param object     要执行方法的对象
     * @param methodName 执行方法 的方法名
     * @param args       执行方法的参数
     */
    public abstract void addListener(Object object, String methodName,
                                     Object... args);

    public abstract void notifyX();
}
