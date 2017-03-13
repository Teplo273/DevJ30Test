package javax.ui.builders.factory;

import javax.swing.JButton;
import javax.ui.builders.factory.base.AbstractButtonBuilder;

class JButtonBuilder extends AbstractButtonBuilder<JButton> {

    @Override
    protected JButton create() {
        return new JButton();
    }

}
