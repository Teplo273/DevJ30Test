package javax.ui.layouts;

import java.awt.Component;
import java.awt.Container;
import javax.swing.GroupLayout;
import javax.swing.JLabel;

public class TableLayout extends GroupLayout {

    public TableLayout(Container parent) {
        super(parent);
        setAutoCreateGaps(true);
        setAutoCreateContainerGaps(true);
    }
    
    private ParallelGroup createRow() {
        return createParallelGroup(Alignment.BASELINE);
    }
    
    @Override
    public void layoutContainer(Container parent) {
        ParallelGroup labels = createParallelGroup(Alignment.TRAILING);
        ParallelGroup controls = createParallelGroup(Alignment.LEADING);
        SequentialGroup rows = createSequentialGroup();
        setVerticalGroup(rows);
        setHorizontalGroup(
            createSequentialGroup()
                .addGroup(labels)
                .addGroup(controls)
        );
        ParallelGroup row = null;
        int i = 0;
        for (Component component : parent.getComponents()) {
            if (i++ % 2 == 0) rows.addGroup(row = createRow());
            row.addComponent(component);
            if (component instanceof JLabel) {
                labels.addComponent(component);
            } else {
                controls.addComponent(component);
            }
        }
        super.layoutContainer(parent); 
    }
    
}
