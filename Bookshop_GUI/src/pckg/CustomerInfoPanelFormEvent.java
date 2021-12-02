package pckg;

import java.util.EventObject;

public class CustomerInfoPanelFormEvent extends EventObject {

    String cstName;
    String cstLastName;
    String cstAddress;
    String cstEmail;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public CustomerInfoPanelFormEvent(Object source) {
        super(source);
    }

    public String getCstName() {
        return cstName;
    }

    public void setCstName(String cstName) {
        this.cstName = cstName;
    }

    public String getCstLastName() {
        return cstLastName;
    }

    public void setCstLastName(String cstLastName) {
        this.cstLastName = cstLastName;
    }

    public String getCstAddress() {
        return cstAddress;
    }

    public void setCstAddress(String cstAddress) {
        this.cstAddress = cstAddress;
    }

    public String getCstEmail() {
        return cstEmail;
    }

    public void setCstEmail(String cstEmail) {
        this.cstEmail = cstEmail;
    }

    @Override
    public String toString() {
        return "CustomerInfoFormPanelEvent{" +
                "cstName='" + cstName + '\'' +
                ", cstLastName='" + cstLastName + '\'' +
                ", cstAddress='" + cstAddress + '\'' +
                ", cstEmail='" + cstEmail + '\'' +
                '}';
    }
}
