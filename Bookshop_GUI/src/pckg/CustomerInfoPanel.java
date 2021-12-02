package pckg;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerInfoPanel extends JPanel {

    private JTextField customerName;
    private JTextField lastName;
    private JTextField address;
    private JTextField email;
    private JButton submitButton;
    private CustomerInfoPanelFormListener customerInfoPanelFormListener;

    public CustomerInfoPanel() {
        setSizeOfCustomerInfoPanel();
        setBorderOfCustomerInfoPanel();
        initializeAllComponents();
        layoutAllComponents();
        activateCustomerInfoPanel();

    }

    private void initializeAllComponents(){
        customerName = new JTextField(10);
        lastName = new JTextField(10);
        address = new JTextField(10);
        email = new JTextField(10);
        submitButton = new JButton("Submit");
    }

    private void setSizeOfCustomerInfoPanel(){
        Dimension dimension = new Dimension();
        dimension.width = 250;
        dimension.height = 250;
        setPreferredSize(dimension);
    }

    private void setBorderOfCustomerInfoPanel(){

        Border innerBorder = BorderFactory.createTitledBorder("Customer information");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);

        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
    }

    private void layoutAllComponents(){

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,0,15,0);

        //customerName field
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Customer name:"),gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(customerName,gbc);

        //lastName field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Last name:"),gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(lastName,gbc);

        //address field
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Address:"),gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(address,gbc);

        //email field
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Email:"),gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(email,gbc);

        // button
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(submitButton,gbc);


    }

    private void activateCustomerInfoPanel(){

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cstName = customerName.getText();
                String cstLastName = lastName.getText();
                String cstAddress = address.getText();
                String cstEmail = email.getText();

                CustomerInfoPanelFormEvent cEvent = new CustomerInfoPanelFormEvent(this);
                cEvent.setCstName(cstName);
                cEvent.setCstLastName(cstLastName);
                cEvent.setCstAddress(cstAddress);
                cEvent.setCstEmail(cstEmail);
                if (customerInfoPanelFormListener != null){
                    customerInfoPanelFormListener.customerInfoPanelFormEventOccurred(cEvent);
                    resetAllDataFields();
                }
            }
        });
    }

    private void resetAllDataFields(){
        customerName.setText("");
        lastName.setText("");
        address.setText("");
        email.setText("");
    }

    public void setCustomerInfoPanelFormListener(CustomerInfoPanelFormListener customerInfoPanelFormListener) {
        this.customerInfoPanelFormListener = customerInfoPanelFormListener;
    }
}
