package javax.ui.builders.factory.base;

import java.awt.Color;
import java.awt.Component;
import javax.ui.patterns.AbstractBuilder;
import java.awt.Dimension;
import java.awt.Point;
import javax.ui.builders.ComponentBuilder;

public abstract class AbstractComponentBuilder<E extends Component, T extends ComponentBuilder> 
                extends AbstractBuilder<E, T> implements ComponentBuilder<E, T> {

    @Override
    public T setEnabled(boolean enabled) {
        source.setEnabled(enabled);
        return (T) this;
    }
    
    @Override
    public T setPreferredSize(Dimension size) {
        source.setPreferredSize(size);
        return (T) this;
    }
    
    @Override
    public T setPreferredSize(int width, int height) {
        return setPreferredSize(new Dimension(width, height));
    }
    
    @Override
    public T setLocation(int x, int y) {
        source.setLocation(x, y);
        return (T) this;
    }
    
    @Override
    public T setLocation(Point location) {
        return setLocation(location.x, location.y);
    }

    @Override
    public T setBackground(Color color) {
        source.setBackground(color);
        return (T) this;
    }

    @Override
    public T setForeground(Color color) {
        source.setForeground(color);
        return (T) this;
    }

    @Override
    public E build() {
        final E obj = create();
        Dimension preferredSize = source.getPreferredSize();
        if (preferredSize != null) obj.setPreferredSize(preferredSize);
        obj.setLocation(source.getLocation());
        obj.setBackground(source.getBackground());
        obj.setForeground(source.getForeground());
        obj.setEnabled(source.isEnabled());
        notifyBuild(obj);
        return obj;
    }
    
}
