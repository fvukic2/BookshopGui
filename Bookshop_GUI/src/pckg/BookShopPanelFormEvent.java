package pckg;

import java.util.EventObject;

public class BookShopPanelFormEvent extends EventObject {

    private String bookInShopName;
    private String typeOfCoverOfBook;
    private String masterCardPayment;
    private String visaCardPayment;
    private String americanExpressPayment;
    private String normalDelivery;
    private String ExpressDelivery;

    public BookShopPanelFormEvent(Object source) {
        super(source);
    }

    public String getBookInShopName() {
        return bookInShopName;
    }

    public void setBookInShopName(String bookInShopName) {
        this.bookInShopName = bookInShopName;
    }

    public String getTypeOfCoverOfBook() {
        return typeOfCoverOfBook;
    }

    public void setTypeOfCoverOfBook(String typeOfCoverOfBook) {
        this.typeOfCoverOfBook = typeOfCoverOfBook;
    }

    public String getMasterCardPayment() {
        return masterCardPayment;
    }

    public void setMasterCardPayment(String masterCardPayment) {
        this.masterCardPayment = masterCardPayment;
    }

    public String getVisaCardPayment() {
        return visaCardPayment;
    }

    public void setVisaCardPayment(String visaCardPayment) {
        this.visaCardPayment = visaCardPayment;
    }

    public String getAmericanExpressPayment() {
        return americanExpressPayment;
    }

    public void setAmericanExpressPayment(String americanExpressPayment) {
        this.americanExpressPayment = americanExpressPayment;
    }

    public String getNormalDelivery() {
        return normalDelivery;
    }

    public void setNormalDelivery(String normalDelivery) {
        this.normalDelivery = normalDelivery;
    }

    public String getExpressDelivery() {
        return ExpressDelivery;
    }

    public void setExpressDelivery(String expressDelivery) {
        ExpressDelivery = expressDelivery;
    }

    @Override
    public String toString() {
        return "BookShopPanelFormEvent{" +
                "bookInShopName='" + bookInShopName + '\'' +
                ", typeOfCoverOfBook='" + typeOfCoverOfBook + '\'' +
                ", masterCardPayment='" + masterCardPayment + '\'' +
                ", visaCardPayment='" + visaCardPayment + '\'' +
                ", americanExpressPayment='" + americanExpressPayment + '\'' +
                ", normalDelivery='" + normalDelivery + '\'' +
                ", ExpressDelivery='" + ExpressDelivery + '\'' +
                '}';
    }
}
