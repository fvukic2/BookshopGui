package pckg;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JPanel {

    private JTextField adminName;
    private JPasswordField adminPassword;
    private JButton login;
    private static char[] passwordChar = {'a', 'd', 'm', 'i', 'n'};
    private static String adminNameStr = "admin";
    public static JFrame message;

    public AdminPanel() {
        setSizeOfAdminPanel();
        setBorderOfAdminPanel();
        initializeAllComponents();
        layoutAllComponents();
        activateLayout();
    }

    private void initializeAllComponents(){
        adminName = new JTextField(7);
        adminPassword = new JPasswordField(7);
        login = new JButton("Login");
    }

    private void setBorderOfAdminPanel(){
        Border innerBorder = BorderFactory.createTitledBorder("Admin");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
    }

    private void setSizeOfAdminPanel() {
        Dimension dimension = new Dimension();
        dimension.height = 160;
        dimension.width = 200;
        setPreferredSize(dimension);
    }

    private void layoutAllComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0,0,40,0);

        //AdminName field
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Admin name:"),gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(adminName,gbc);

        //LastName field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Admin password:"),gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(adminPassword,gbc);

        // login
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        gbc.insets = new Insets(30,0,0,0);
        add(login,gbc);

    }

    private void activateLayout(){
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] input = adminPassword.getPassword();
                String strInput = adminName.getText();
                if(isAdminPasswordCorrect(input) && isAdminNameCorrect(strInput)) {
                    createFrame();
                }else {
                    createFrameWrongInput();
                }
            }
        });
    }

    private void createFrameWrongInput() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(message, "Wrong password or admin name! Wrong input.", "Pogreška", 1);
            }
        });
    }

    public static void createFrame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                /*AdminPanel frame = new AdminPanel();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);*/
            }
        });
    }

    private boolean isAdminNameCorrect(String input) {
        boolean isCorrect = true;
        String adminName = adminNameStr;

        if (!input.contentEquals(adminName)) {
            isCorrect = false;
        }

        return isCorrect;
    }

    private boolean isAdminPasswordCorrect(char[] input) {
        boolean isCorrect = true;
        char[] password = passwordChar;

        if (input.length != password.length) {
            isCorrect = false;
        } else {
            for (int i = 0; i < input.length; i++) {
                if (input[i] != password[i]) {
                    isCorrect = false;
                }
            }
        }
        return isCorrect;
    }
}
