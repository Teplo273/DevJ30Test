package javax.ui.builders;

import javax.swing.JTextField;

public interface TextFieldBuilder extends TextCompomentBuilder<JTextField, TextFieldBuilder>, ComponentBuilder<JTextField, TextFieldBuilder>, Changeable<JTextField, TextFieldBuilder> {
    
    TextFieldBuilder setColumns(int columns);
    
}
