package ui_task.business_objects;

public class Email {
    private String login;
    private String domain;

    public String getLogin() {
        return login;
    }

    public String getDomain() {
        return domain;
    }

    public Email withLogin(String login) {
        this.login = login;
        return this;
    }

    public Email withDomain(String domain) {
        this.domain = domain;
        return this;
    }
}
