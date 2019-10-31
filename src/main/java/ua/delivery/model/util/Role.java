package ua.delivery.model.util;

public enum Role {
    ADMIN("admin"), USER("user"), GUEST("guest");

    private String value;

    Role(String role) {
        this.value = role;
    }

    public String getValue() {
        return value;
    }
}
