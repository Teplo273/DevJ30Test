package javax.ui.builders.factory;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.ui.builders.MenuBarBuilder;
import javax.ui.builders.MenuBuilder;
import javax.ui.patterns.AbstractBuilder;
import javax.ui.patterns.Builder;

class JMenuBarBuilder extends AbstractBuilder<JMenuBar, MenuBarBuilder> implements MenuBarBuilder, Builder.BuildListener<JMenu> {
    private final ActionListener listener;

    public JMenuBarBuilder(ActionListener listener) {
        this.listener = listener;
    }

    @Override
    protected JMenuBar create() {
        return new JMenuBar();
    }

    @Override
    public MenuBuilder createMenu(String text) {
        return UiFactory.menuBuilder(text, listener).addBuildListener(this);
    }

    @Override
    public JMenuBar build() {
        return source;
    }

    @Override
    public void onBuild(JMenu item) {
        source.add(item);
    }

}
