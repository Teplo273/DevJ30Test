package javax.ui.builders.factory;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.ui.builders.SpinnerBuilder;
import javax.ui.builders.factory.base.AbstractComponentBuilder;
import javax.ui.event.ValueChangeListener;

class JSpinnerBuilder extends AbstractComponentBuilder<JSpinner, SpinnerBuilder> implements SpinnerBuilder {

    @Override
    protected JSpinner create() {
        return new JSpinner();
    }

    @Override
    public SpinnerBuilder setModel(SpinnerModel model) {
        source.setModel(model);
        return this;
    }

    @Override
    public SpinnerBuilder setValue(Object value) {
        source.setValue(value);
        return this;
    }

    @Override
    public SpinnerBuilder addChangeListener(final ValueChangeListener listener) {
        source.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                listener.onChange(e.getSource());
            }
        });
        return this;
    }

    @Override
    public SpinnerBuilder setModel(double value, double min, double max, double step) {
        return setModel(new SpinnerNumberModel(value, min, max, step));
    }

    @Override
    public SpinnerBuilder setModel(int value, int min, int max, int step) {
        return setModel(new SpinnerNumberModel(value, min, max, step));
    }

    @Override
    public JSpinner build() {
        JSpinner obj = super.build();
        obj.setModel(source.getModel());
        for (ChangeListener listener : source.getChangeListeners()) {
            obj.addChangeListener(listener);
        }
        obj.setValue(source.getValue());
        return obj;
    }
    
}
