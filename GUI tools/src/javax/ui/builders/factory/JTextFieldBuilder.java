package javax.ui.builders.factory;

import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.ui.builders.TextFieldBuilder;
import javax.ui.builders.factory.base.AbstractComponentBuilder;
import javax.ui.event.ValueChangeListener;

class JTextFieldBuilder extends AbstractComponentBuilder<JTextField, TextFieldBuilder> implements TextFieldBuilder {

    @Override
    protected JTextField create() {
        return new JTextField();
    }

    @Override
    public TextFieldBuilder setText(String text) {
        source.setText(text);
        return this;
    }

    @Override
    public TextFieldBuilder addChangeListener(ValueChangeListener<JTextField> listener) {
        source.addCaretListener(new CaretListener() {

            @Override
            public void caretUpdate(CaretEvent e) {
                listener.onChange((JTextField) e.getSource());
            }
        });
        return this;
    }

    @Override
    public TextFieldBuilder setColumns(int columns) {
        source.setColumns(columns);
        return this;
    }

    @Override
    public JTextField build() {
        JTextField obj = super.build();
        obj.setText(source.getText());
        for (CaretListener listener : source.getCaretListeners()) {
            obj.addCaretListener(listener);
        }
        obj.setColumns(source.getColumns());
        return obj;
    }

}
