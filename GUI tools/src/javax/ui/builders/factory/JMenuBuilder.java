package javax.ui.builders.factory;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.ui.builders.ButtonBuilder;
import javax.ui.builders.MenuBuilder;
import javax.ui.patterns.AbstractBuilder;

class JMenuBuilder extends AbstractBuilder<JMenu, MenuBuilder> implements MenuBuilder {
    private final ButtonBuilder<JMenuItem> builder;

    public JMenuBuilder(String text, ActionListener listener) {
        setText(text);
        builder = UiFactory.menuItemBuilder().addActionListener(listener);
    }

    @Override
    protected JMenu create() {
        return new JMenu();
    }

    @Override
    public JMenuBuilder setText(String text) {
        source.setText(text);
        return this;
    }

    @Override
    public MenuBuilder addItem(JMenuItem item) {
        source.add(item);
        return this;
    }

    @Override
    public JMenuBuilder addItem(String text, Enum command) {
        builder.setText(text).setActionCommand(command);
        source.add(builder.build());
        return this;
    }

    private JMenuItem copy(JMenuItem item) {
        return builder
            .setText(item.getText())
            .setActionCommand(item.getActionCommand())
            .setEnabled(item.isEnabled())
            .build();
    }
    
    @Override
    public JMenu build() {
        final JMenu menu = create();
        menu.setText(source.getText());
        for (int i = 0; i < source.getItemCount(); i++) {
            menu.add(copy(source.getItem(i)));
        }
        notifyBuild(menu);
        return menu;
    }

    @Override
    public JPopupMenu buildPopup() {
        final JPopupMenu menu = new JPopupMenu(source.getText());
        for (int i = 0; i < source.getItemCount(); i++) {
            menu.add(copy(source.getItem(i)));
        }
        return menu;
    }

}
