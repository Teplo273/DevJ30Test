package javax.ui.builders.factory;

import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.ui.builders.ButtonBuilder;
import javax.ui.builders.ContainerBuilder;
import javax.ui.builders.LabelBuilder;
import javax.ui.builders.ListBuilder;
import javax.ui.builders.MenuBarBuilder;
import javax.ui.builders.MenuBuilder;
import javax.ui.builders.SpinnerBuilder;
import javax.ui.builders.TextFieldBuilder;

public final class UiFactory {

    private UiFactory() {
    }

    public static ButtonBuilder<JMenuItem> menuItemBuilder() {
        return new JMenuItemBuilder();
    }
    
    public static ButtonBuilder<JMenuItem> menuItemBuilder(ActionListener listener) {
        return new JMenuItemBuilder().addActionListener(listener);
    }

    public static MenuBuilder menuBuilder(String text, ActionListener listener) {
        return new JMenuBuilder(text, listener);
    }

    public static ButtonBuilder<JButton> buttonBuilder() {
        return new JButtonBuilder();
    }
    
    public static SpinnerBuilder spinnerBuilder() {
        return new JSpinnerBuilder();
    }
    
    public static SpinnerBuilder spinnerBuilder(double value, double min, double max, double step) {
        return new JSpinnerBuilder().setModel(value, min, max, step);
    }

    public static SpinnerBuilder spinnerBuilder(int value, int min, int max, int step) {
        return new JSpinnerBuilder().setModel(value, min, max, step);
    }
    
    public static MenuBarBuilder menuBarBuilder(ActionListener listener) {
        return new JMenuBarBuilder(listener);
    }
    
    public static ContainerBuilder<JPanel> panelBuilder() {
        return new JPanelBuilder();
    }
    
    public static ContainerBuilder<JPanel> panelBuilder(LayoutManager layout) {
        return new JPanelBuilder().setLayout(layout);
    }
    
    public static ListBuilder listBuilder() {
        return new JListBuilder();
    }
    
    public static <E> ListBuilder<E> listBuilder(ListModel<E> model) {
        return new JListBuilder<E>().setModel(model);
    }

    public static <E> ListBuilder<E> listBuilder(ListModel<E> model, ListCellRenderer<E> renderer) {
        return new JListBuilder<E>().setModel(model).setCellRenderer(renderer);
    }
    
    public static TextFieldBuilder textFieldBuilder() {
        return new JTextFieldBuilder();
    }

    public static TextFieldBuilder textFieldBuilder(int columns) {
        return textFieldBuilder().setColumns(columns);
    }
    
    public static LabelBuilder labelBuilder(LabelBuilder.Alignment alignment) {
        return new JLabelBuilder(alignment);
    }
    
    public static LabelBuilder labelBuilder() {
        return labelBuilder(LabelBuilder.Alignment.Left);
    }

}
