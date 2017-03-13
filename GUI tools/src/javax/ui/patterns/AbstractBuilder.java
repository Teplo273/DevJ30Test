package javax.ui.patterns;

import java.util.Collection;
import java.util.HashSet;

public abstract class AbstractBuilder<E, T extends Builder> implements Builder<E, T> {

    protected final E source;
    
    private final Collection<BuildListener<E>> listeners = new HashSet<>();
    
    protected AbstractBuilder() {
        source = create();
    }
    
    @Override
    public T addBuildListener(BuildListener<E> listener) {
        if (listener != null && !listeners.contains(listener)) listeners.add(listener);
        return (T) this;
    }
    
    @Override
    public T removeBuildListener(BuildListener listener) {
        listeners.remove(listener);
        return (T) this;
    }
    
    @Override
    public T notifyBuild(E target) {
        for (BuildListener<E> listener : listeners) listener.onBuild(target);
        return (T) this;
    }
    
    protected abstract E create();
    
}
