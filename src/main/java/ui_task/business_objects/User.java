package ui_task.business_objects;

public class User {

    private Email email;
    private String password;

    public Email getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public User withEmail(String login, String domain) {
        email = new Email()
                .withLogin(login)
                .withDomain(domain);
        return this;
    }

    @Override
    public String toString() {
        return "login-'" + email.getLogin() + '\''
                + ", domain-'" + email.getDomain() + '\''
                + ", password-'" + password + '\'';
    }
}
