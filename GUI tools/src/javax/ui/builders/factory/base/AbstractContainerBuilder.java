package javax.ui.builders.factory.base;

import java.awt.Component;
import java.awt.LayoutManager;
import java.util.LinkedHashSet;
import java.util.Set;
import javafx.util.Pair;
import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.ui.builders.ContainerBuilder;

public abstract class AbstractContainerBuilder<E extends JComponent> extends AbstractComponentBuilder<E, ContainerBuilder<E>> implements ContainerBuilder<E> {

    private final Set<Pair<Component, Object>> components = new LinkedHashSet<>();

    @Override
    public ContainerBuilder<E> setLayout(LayoutManager layout) {
        source.setLayout(layout);
        return this;
    }

    @Override
    public ContainerBuilder<E> add(Component component) {
        return add(component, null);
    }

    @Override
    public ContainerBuilder<E> add(Component component, Object constraints) {
        components.add(new Pair(source.add(component), constraints));
        return this;
    }

    @Override
    public ContainerBuilder<E> setBorder(Border border) {
        source.setBorder(border);
        return this;
    }

    @Override
    public E build() {
        E obj = super.build();
        obj.setLayout(source.getLayout());
        obj.setBorder(source.getBorder());
        Component component;
        Object constraint;
        for (Pair<Component, Object> pair : components) {
            component = pair.getKey();
            constraint = pair.getValue();
            if (constraint != null) obj.add(component, constraint);
            else obj.add(component);
        }
        return obj;
    }
    
}
