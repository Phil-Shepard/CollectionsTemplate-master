package ru.naumen.collection.task1;

import java.util.Arrays;

/**
 * Пользователь
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class User {
    private String username;
    private String email;
    private byte[] passwordHash;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Arrays.equals(passwordHash, user.passwordHash);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(passwordHash);
    }
}
