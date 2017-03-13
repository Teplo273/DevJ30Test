package javax.ui.patterns;

public interface Builder<E, T extends Builder> {
    
    interface BuildListener<E> {
        void onBuild(E item);
    }
    
    E build();

    T addBuildListener(BuildListener<E> listener);
    
    T removeBuildListener(BuildListener listener);
    
    T notifyBuild(E target);
}
