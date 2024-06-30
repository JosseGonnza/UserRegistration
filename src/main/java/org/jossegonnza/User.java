package org.jossegonnza;

public class User {
    private final String email;
    private final String id;

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