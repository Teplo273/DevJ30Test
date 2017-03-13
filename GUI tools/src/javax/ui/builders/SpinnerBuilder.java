package javax.ui.builders;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;

public interface SpinnerBuilder extends ComponentBuilder<JSpinner, SpinnerBuilder>, Changeable<JSpinner, SpinnerBuilder> {

    SpinnerBuilder setModel(SpinnerModel model);
    
    SpinnerBuilder setModel(double value, double min, double max, double step);
    
    SpinnerBuilder setModel(int value, int min, int max, int step);
    
    SpinnerBuilder setValue(Object value);
    
}
