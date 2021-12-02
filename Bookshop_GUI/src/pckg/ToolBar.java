package pckg;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ToolBar extends JPanel implements ActionListener {

    private JButton clearButton;
    private JButton saveObjectButton;
    private JButton readObjectButton;
    private ToolBarListener toolBarListener;

    public ToolBar() {
        clearButton = new JButton("Clear all");
        saveObjectButton = new JButton("Save object");
        readObjectButton = new JButton("Read object");
        // Dodajemo elemente poravnate sa lijeve strane
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(clearButton);
        add(saveObjectButton);
        add(readObjectButton);
        activateToolBar();
        setBorderOfToolBar();

    }

    public void setBorderOfToolBar(){
        Border outerBorder = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(BorderFactory.createTitledBorder(outerBorder));
    }

    public void activateToolBar() {
        clearButton.addActionListener(this);
        saveObjectButton.addActionListener(this);
        readObjectButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        if (e.getSource() == clearButton){
            toolBarListener.clearAllFromPanel();
        } else if (e.getSource() == readObjectButton){
            int val = fileChooser.showOpenDialog(this);
            if (val == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                    String line = null;
                    StringBuilder sb = new StringBuilder();
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                    toolBarListener.readObjectTooPanel(sb.toString());
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        } else if (e.getSource() == saveObjectButton) {
            int val = fileChooser.showSaveDialog(this);
            if (val == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                    String content = toolBarListener.saveObjectToFile();
                    bw.write(content);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        } else {
            System.out.println(e.toString());
        }
    }

    public void setToolBarListener(ToolBarListener toolBarListener) {
        this.toolBarListener = toolBarListener;
    }
}
