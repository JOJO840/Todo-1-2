package org.lexicon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    @Test
    void testAppUserCreation() {
        AppUser user = new AppUser("testUser", "password123", AppRole.ROLE_APP_USER);
        assertEquals("testUser", user.getUsername());
        assertEquals(AppRole.ROLE_APP_USER, user.getRole());
    }

    @Test
    void testToStringExcludesPassword() {
        AppUser user = new AppUser("testUser", "password123", AppRole.ROLE_APP_USER);
        assertFalse(user.toString().contains("password123"));
    }

    @Test
    void testEqualsAndHashCode() {
        AppUser user1 = new AppUser("testUser", "password123", AppRole.ROLE_APP_USER);
        AppUser user2 = new AppUser("testUser", "differentPassword", AppRole.ROLE_APP_USER);
        assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    void testInvalidUsernameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new AppUser(null, "password123", AppRole.ROLE_APP_USER));
    }

    @Test
    void testInvalidPasswordThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new AppUser("testUser", null, AppRole.ROLE_APP_USER));
    }
}