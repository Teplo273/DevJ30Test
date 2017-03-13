package javax.ui.builders.factory.base;

import javax.swing.text.JTextComponent;
import javax.ui.builders.TextCompomentBuilder;
import javax.ui.patterns.AbstractBuilder;

public abstract class AbstractTextComponentBuilder<E extends JTextComponent, T extends TextCompomentBuilder<E, T>> 
                extends AbstractBuilder<E, T> implements TextCompomentBuilder<E, T> {

    @Override
    public T setText(String text) {
        source.setText(text);
        return (T) this;
    }

    @Override
    public E build() {
        final E obj = create();
        obj.setText(source.getText());
        notifyBuild(obj);
        return obj;
    }
    
}
