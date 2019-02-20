package com.wajahat.usersgroups.memory;

import com.wajahat.usersgroups.api.GroupService;
import com.wajahat.usersgroups.core.AbstractService;
import com.wajahat.usersgroups.core.Services;
import com.wajahat.usersgroups.domain.Group;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

/**
 * An implementation of the group service that stores all groups in memory.
 *
 * @author wajahat
 */
public class MemoryGroupService extends AbstractService implements GroupService {

    private final Map<String, Group> groups = new ConcurrentHashMap<>();

    public MemoryGroupService(Services services) {
        super(services);
    }

    @Override
    public Group findByName(String name) {
        requireNonNull(name);

        return groups.get(name);
    }

    @Override
    public void create(Group group) {
        requireNonNull(group);
        if (groups.containsKey(group.getName())) {
            throw new IllegalArgumentException("Groups " + group.getName() + " already exists");
        }
        groups.put(group.getName(), group);
    }

    @Override
    public void delete(Group group) {
        requireNonNull(group);
        if (!groups.containsKey(group.getName())) {
            throw new IllegalArgumentException("Groups " + group.getName() + " doesnt exists");
        }
        // ToDo(wajahat) remove all users which are part of this group
        groups.remove(group);
    }
}
