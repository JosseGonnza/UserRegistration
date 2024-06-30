package org.jossegonnza;

public class User {
    private String email;
    private String id;

    public User(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
}