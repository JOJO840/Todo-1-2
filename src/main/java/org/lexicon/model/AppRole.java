package org.lexicon.model;

public enum AppRole {
    ROLE_APP_USER("User "),
    ROLE_APP_ADMIN("Admin ");

    private final String roleName;

    AppRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
