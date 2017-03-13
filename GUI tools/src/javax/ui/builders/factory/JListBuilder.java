package javax.ui.builders.factory;

import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionListener;
import javax.ui.builders.ListBuilder;
import javax.ui.builders.factory.base.AbstractComponentBuilder;

class JListBuilder<E> extends AbstractComponentBuilder<JList<E>, ListBuilder<E>> implements ListBuilder<E> {

    @Override
    protected JList<E> create() {
        return new JList<>();
    }

    @Override
    public ListBuilder<E> setModel(ListModel<E> model) {
        source.setModel(model);
        return this;
    }

    @Override
    public ListBuilder<E> setSelectionMode(SelectionMode mode) {
        source.setSelectionMode(mode.value());
        return this;
    }

    @Override
    public ListBuilder<E> addSelectionListener(ListSelectionListener listener) {
        source.addListSelectionListener(listener);
        return this;
    }

    @Override
    public ListBuilder<E> setCellRenderer(ListCellRenderer<E> renderer) {
        source.setCellRenderer(renderer);
        return this;
    }

    @Override
    public JList<E> build() {
        JList<E> obj = super.build();
        obj.setModel(source.getModel());
        obj.setSelectionMode(source.getSelectionMode());
        for (ListSelectionListener listener : source.getListSelectionListeners()) {
            obj.addListSelectionListener(listener);
        }
        obj.setCellRenderer(source.getCellRenderer());
        return obj;
    }
    
}
