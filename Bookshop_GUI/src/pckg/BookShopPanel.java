package pckg;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookShopPanel extends JPanel {

    private JList<String> booksInShop;
    private JComboBox<String> coverOfBooks;
    private JCheckBox masterCardPayment;
    private JCheckBox visaCardPayment;
    private JCheckBox americanExpressCardPayment;
    private JRadioButton normalDelivery;
    private JRadioButton expressDelivery;
    private JButton submitButton;
    private ButtonGroup checkboxGroup;
    private ButtonGroup radioButtonGroup;
    private BookShopPanelFormListener bookShopPanelFormListener;

    public BookShopPanel() {
        setSizeOfBookShopPanel();
        setBorderOfBookShopPanel();
        initializeAllComponents();
        layoutAllComponents();
        activateBookShopPanel();
    }

    private void initializeAllComponents(){
        booksInShop = new JList<>();
        coverOfBooks = new JComboBox<>();
        masterCardPayment = new JCheckBox("MasterCard");
        visaCardPayment = new JCheckBox("Visa");
        americanExpressCardPayment = new JCheckBox("American Express");
        normalDelivery = new JRadioButton("Normal delivery");
        expressDelivery = new JRadioButton("Express delivery");
        submitButton = new JButton("Submit");

        // Adding checkBoxItems to group
        checkboxGroup = new ButtonGroup();
        checkboxGroup.add(masterCardPayment);
        checkboxGroup.add(visaCardPayment);
        checkboxGroup.add(americanExpressCardPayment);

        // Adding buttons to group
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(normalDelivery);
        radioButtonGroup.add(expressDelivery);

        // Creating list and adding list items
        DefaultListModel<String> listOfBooks = new DefaultListModel<>();
        listOfBooks.add(0,"In Search of Lost Time by Marcel Proust");
        listOfBooks.add(1,"Ulysses by James Joyce");
        listOfBooks.add(2,"Don Quixote by Miguel de Cervantes");
        listOfBooks.add(3,"One Hundred Years of Solitude by Gabriel Garcia Marquez");
        listOfBooks.add(4,"The Great Gatsby by F. Scott Fitzgerald");
        listOfBooks.add(5,"War and Peace by Leo Tolstoy");
        listOfBooks.add(6,"Hamlet by William Shakespeare");
        booksInShop.setModel(listOfBooks);
        booksInShop.setBorder(BorderFactory.createEtchedBorder());
        booksInShop.setVisibleRowCount(3);
        booksInShop.setSelectedIndex(0);
        Dimension dimension = booksInShop.getPreferredSize();
        dimension.width = 100;
        booksInShop.setPreferredSize(dimension);

        //Creating comboBox and adding comboBox elements
        DefaultComboBoxModel<String> typeOfBookCover = new DefaultComboBoxModel<>();
        typeOfBookCover.addElement("Softcover");
        typeOfBookCover.addElement("Hardcover with ImageWrap");
        typeOfBookCover.addElement(" Hardcover with Dust Jacket");
        coverOfBooks.setModel(typeOfBookCover);
        coverOfBooks.setSelectedIndex(0);
    }

    private void setSizeOfBookShopPanel(){
        Dimension dimension = new Dimension();
        dimension.width = 700;
        dimension.height = 260;
        setPreferredSize(dimension);
    }

    private void setBorderOfBookShopPanel(){

        Border innerBorder = BorderFactory.createTitledBorder("Bookshop");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);

        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));
    }

    private void layoutAllComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,20,6,50);

        //BooksInShop List
        //First Column
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(new JLabel("List of books in shop:"),gbc);

        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JScrollPane(booksInShop,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),gbc);

        //CoverOfBooks ComboBox
        //Second Column
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Choose cover of book:"),gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(coverOfBooks,gbc);

        //JCheckBoxes
        //Third Column
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Choose card payment:"),gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(masterCardPayment,gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(visaCardPayment,gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(americanExpressCardPayment,gbc);

        //JRadioButtons
        //Forth Column
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(new JLabel("Choose way of delivery:"),gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(normalDelivery,gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(expressDelivery,gbc);

        //SubmitButton
        //Fifth Column
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        add(submitButton,gbc);

    }

    private void activateBookShopPanel(){

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bksInShp = booksInShop.getSelectedValue();
                String typeOfBkCvr = (String) coverOfBooks.getSelectedItem();
                String masterCardPnt = masterCardPayment.getText();
                String vsCrdPnt = visaCardPayment.getText();
                String amrCrdPnt = americanExpressCardPayment.getText();
                String nrmDel = normalDelivery.getText();
                String espDel = expressDelivery.getText();

                BookShopPanelFormEvent bspfe = new BookShopPanelFormEvent(this);
                bspfe.setBookInShopName(bksInShp);
                bspfe.setTypeOfCoverOfBook(typeOfBkCvr);
                bspfe.setMasterCardPayment(masterCardPnt);
                bspfe.setVisaCardPayment(vsCrdPnt);
                bspfe.setAmericanExpressPayment(amrCrdPnt);
                bspfe.setNormalDelivery(nrmDel);
                bspfe.setAmericanExpressPayment(espDel);

                if (bookShopPanelFormListener != null){
                    bookShopPanelFormListener.bookShopPanelEventOccurred(bspfe);
                    resetAllDataFields();
                }
            }
        });
    }

    private void resetAllDataFields(){
        booksInShop.setSelectedIndex(0);
        coverOfBooks.setSelectedIndex(0);
        normalDelivery.setSelected(true);
        masterCardPayment.setSelected(true);
    }

    public void setBookShopPanelFormListener(BookShopPanelFormListener bookShopPanelFormListener) {
        this.bookShopPanelFormListener = bookShopPanelFormListener;
    }
}


