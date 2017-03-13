package javax.ui.builders;

import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import javax.swing.border.Border;

public interface ContainerBuilder<E extends Container> extends ComponentBuilder<E, ContainerBuilder<E>> {

    ContainerBuilder<E> setLayout(LayoutManager layout);
    
    ContainerBuilder<E> add(Component component);
    
    ContainerBuilder<E> add(Component component, Object constraints);
    
    ContainerBuilder<E> setBorder(Border border);
    
}
