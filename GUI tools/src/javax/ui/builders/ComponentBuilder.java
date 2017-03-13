package javax.ui.builders;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import javax.ui.patterns.Builder;

public interface ComponentBuilder<E extends Component,T extends ComponentBuilder> extends Builder<E, T> {
    
    T setLocation(Point location);
    
    T setLocation(int x, int y);
    
    T setPreferredSize(Dimension size);
    
    T setPreferredSize(int width, int height);
    
    T setBackground(Color color);
    
    T setForeground(Color color);
    
    T setEnabled(boolean enabled);

}
