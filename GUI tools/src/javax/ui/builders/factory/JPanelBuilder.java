package javax.ui.builders.factory;

import javax.swing.JPanel;
import javax.ui.builders.factory.base.AbstractContainerBuilder;

class JPanelBuilder extends AbstractContainerBuilder<JPanel> {

    @Override
    protected JPanel create() {
        return new JPanel();
    }

}
