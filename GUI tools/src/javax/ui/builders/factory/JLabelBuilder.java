package javax.ui.builders.factory;

import javax.swing.JLabel;
import javax.ui.builders.LabelBuilder;
import javax.ui.builders.factory.base.AbstractComponentBuilder;

class JLabelBuilder extends AbstractComponentBuilder<JLabel, LabelBuilder> implements LabelBuilder {

    private Alignment alignment;

    public JLabelBuilder(Alignment alignment) {
        this.alignment = alignment;
    }
    
    @Override
    protected JLabel create() {
        if (alignment == null) {
            return new JLabel();
        }
        return new JLabel("", alignment.value());
    }

    @Override
    public LabelBuilder setText(String text) {
        source.setText(text);
        return this;
    }

    @Override
    public LabelBuilder setAlignment(Alignment alignment) {
        this.alignment = alignment;
        return this;
    }
    
    @Override
    public JLabel build() {
        JLabel obj = super.build();
        obj.setText(source.getText());
        return obj;
    }

    @Override
    public JLabel build(String text) {
        return setText(text).build();
    }

    @Override
    public JLabel build(String text, Alignment alignment) {
        return setText(text).setAlignment(alignment).build();
    }
    
}
