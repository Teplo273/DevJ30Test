package javax.ui.builders.factory;

import javax.swing.JMenuItem;
import javax.ui.builders.factory.base.AbstractButtonBuilder;

class JMenuItemBuilder extends AbstractButtonBuilder<JMenuItem> {

    @Override
    protected JMenuItem create() {
        return new JMenuItem();
    }

}
