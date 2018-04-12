package data;

public class EmailAddress {

    private String email;

    public EmailAddress(String email) {

        if(!email.contains("@") || email.split("@").length != 2)
            throw new IllegalArgumentException(email + " is an invalid email address!");

        this.email  = email;
    }

    public String toString() {

        return email;
    }

    public String getEmail() {

        return email;
    }

    public String getServer() {

        return email.split("@")[1];
    }
}
