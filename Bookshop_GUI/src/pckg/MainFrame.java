package pckg;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CustomerInfoPanel customerInfoPanel;
    private BookShopPanel bookShopPanel;
    private TextAreaPanel textAreaPanel;
    private ToolBar toolBar;
    private AdminPanel adminPanel;
    private ToolBarListener toolBarListener;


    public MainFrame() {

        super("Bookshop");
        setSize(1100, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        initializeAllComponents();
        setFormLayout();
        activateMainFrame();

    }

    private void initializeAllComponents() {

        adminPanel = new AdminPanel();
        customerInfoPanel = new CustomerInfoPanel();
        bookShopPanel = new BookShopPanel();
        textAreaPanel = new TextAreaPanel(customerInfoPanel);
        toolBar = new ToolBar();
    }

    private void setFormLayout() {

        add(textAreaPanel, BorderLayout.CENTER);
        add(bookShopPanel, BorderLayout.SOUTH);
        add(toolBar, BorderLayout.NORTH);
        add(adminPanel,BorderLayout.EAST);

    }

    private void activateMainFrame() {
        customerInfoPanel.setCustomerInfoPanelFormListener(new CustomerInfoPanelFormListener() {
            @Override
            public void customerInfoPanelFormEventOccurred(CustomerInfoPanelFormEvent customerInfoPanelFormEvent) {
                textAreaPanel.setTextToPanel(customerInfoPanelFormEvent.toString());
            }
        });

        bookShopPanel.setBookShopPanelFormListener(new BookShopPanelFormListener() {
            @Override
            public void bookShopPanelEventOccurred(BookShopPanelFormEvent bookShopPanelFormEvent) {
                textAreaPanel.setTextToPanel(bookShopPanelFormEvent.toString());
            }
        });

        toolBarListener = new ToolBarListener() {
            @Override
            public void clearAllFromPanel() {
                textAreaPanel.clearAllTextFromArea();
            }

            @Override
            public void readObjectTooPanel(String content) {
                textAreaPanel.setTextToPanel(content);
            }

            @Override
            public String saveObjectToFile() {
                return  textAreaPanel.getAll();
            }
        };
        toolBar.setToolBarListener(toolBarListener);

    }
}
