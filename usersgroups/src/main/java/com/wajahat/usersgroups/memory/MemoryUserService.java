package com.wajahat.usersgroups.memory;

import com.wajahat.usersgroups.api.UserService;
import com.wajahat.usersgroups.core.AbstractService;
import com.wajahat.usersgroups.core.Services;
import com.wajahat.usersgroups.domain.User;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

/**
 * An implementation of the user service that stores all users in memory.
 *
 * @author wajahat
 */
public class MemoryUserService extends AbstractService implements UserService {

    private final Map<String, User> users = new ConcurrentHashMap<>();

    public MemoryUserService(Services services) {
        super(services);
    }

    @Nullable
    @Override
    public User findByName(String name) {
        requireNonNull(name, "name");
        return users.get(name);
    }

    @Override
    public void create(User user) {
        requireNonNull(user);
        if (users.containsKey(user.getName())) {
            throw new IllegalArgumentException("Users " + user.getName() + " already exists");
        }
        users.put(user.getName(), user);
    }

    @Override
    public void delete(User user) {
        requireNonNull(user);
        if (!users.containsKey(user.getName())) {
            throw new IllegalArgumentException("Users " + user.getName() + " does not exists");
        }
        users.remove(user);
    }
}
