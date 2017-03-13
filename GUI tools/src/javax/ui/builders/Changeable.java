package javax.ui.builders;

import java.awt.Component;
import javax.ui.event.ValueChangeListener;

public interface Changeable<E extends Component, T extends ComponentBuilder<E, T>> {

    T addChangeListener(ValueChangeListener<E> listener);

}
