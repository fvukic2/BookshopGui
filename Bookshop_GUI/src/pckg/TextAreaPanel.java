package pckg;

import javax.swing.*;
import java.awt.*;

public class TextAreaPanel extends JPanel {

    private JTextArea textArea;

    public TextAreaPanel(CustomerInfoPanel customerInfoPanel){

        setSizeOfTextAreaPanel();
        setLayout(new BorderLayout());
        initializeAllComponents();
        add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS), BorderLayout.CENTER);
        textArea.setEditable(false);
        add(customerInfoPanel,BorderLayout.WEST);
    }

    private void initializeAllComponents(){
        textArea = new JTextArea();
    }

    private void setSizeOfTextAreaPanel() {
        Dimension dimension = new Dimension();
        dimension.height = 260;
        dimension.width = 400;
        setPreferredSize(dimension);
    }

    public void setTextToPanel(String text){
        textArea.append(text + "\n");
    }

    public void clearAllTextFromArea(){
        textArea.selectAll();
        textArea.replaceSelection(null);
    }

    public String getAll(){
        textArea.selectAll();
        return textArea.getSelectedText();
    }
}
