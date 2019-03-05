package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.List;

public class UsersUtil {
    public static final List<User> USERS = Arrays.asList(
            new User(null, "User", "user@user.us", "user", Role.ROLE_USER),
            new User(null, "SecondUser", "seconduser@user.us", "seconduser", Role.ROLE_USER),
            new User(null, "Admin", "admin@user.us", "admin", Role.ROLE_ADMIN)
    );
}
