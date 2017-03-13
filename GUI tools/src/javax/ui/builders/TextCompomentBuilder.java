package javax.ui.builders;

import java.awt.Component;
import javax.ui.patterns.Builder;

public interface TextCompomentBuilder<E extends Component, T extends TextCompomentBuilder<E, T>> extends Builder<E, T>{

    T setText(String text);
    
}
