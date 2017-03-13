package javax.ui.builders;

import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

public interface ListBuilder<E> extends ComponentBuilder<JList<E>, ListBuilder<E>> {
    
    enum SelectionMode {
        Single(ListSelectionModel.SINGLE_SELECTION),
        Interval(ListSelectionModel.SINGLE_INTERVAL_SELECTION),
        Multiple(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        private final int value;

        private SelectionMode(int value) {
            this.value = value;
        }
        
        public int value() { return value; }
    }

    ListBuilder<E> setModel(ListModel<E> model);
    
    ListBuilder<E> setSelectionMode(SelectionMode mode);
    
    ListBuilder<E> addSelectionListener(ListSelectionListener listener);
    
    ListBuilder<E> setCellRenderer(ListCellRenderer<E> renderer);
    
}
