package ui_task.business_objects;

public class Letter {

    private String address;
    private String subject;
    private String text;

    public String getAddress() {
        return address;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public Letter withAddress(String address) {
        this.address = address;
        return this;
    }

    public Letter withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Letter withText(String text) {
        this.text = text;
        return this;
    }

}
