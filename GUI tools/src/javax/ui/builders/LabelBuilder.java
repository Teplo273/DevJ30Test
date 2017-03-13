package javax.ui.builders;

import javax.swing.JLabel;

public interface LabelBuilder extends ComponentBuilder<JLabel, LabelBuilder>, TextCompomentBuilder<JLabel, LabelBuilder> {

    enum Alignment {
        Left(JLabel.LEFT),
        Right(JLabel.RIGHT),
        Center(JLabel.CENTER);

        private final int alignment;
        
        private Alignment(int alignment) {
            this.alignment = alignment;
        }
            
        public int value() { return alignment; }
        
    }
    
    LabelBuilder setAlignment(Alignment alignment);
    
    JLabel build(String text);
    
    JLabel build(String text, Alignment alignment);
    
}
