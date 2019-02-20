package com.wajahat.usersgroups.memory;

import com.wajahat.usersgroups.api.MembershipService;
import com.wajahat.usersgroups.core.AbstractService;
import com.wajahat.usersgroups.core.Services;
import com.wajahat.usersgroups.domain.Group;
import com.wajahat.usersgroups.domain.User;

import java.util.Collection;

/**
 * MemoryMembershipService
 *
 * @author wajahat
 */
public class MemoryMembershipService extends AbstractService implements MembershipService {
    public MemoryMembershipService(Services services) {
        super(services);
    }
    @Override
    public void addUserToGroup(User user, Group group) {

    }

    @Override
    public void addGroupToGroup(Group child, Group parent) {

    }

    @Override
    public boolean isUserInGroup(User user, Group group) {
        return false;
    }

    @Override
    public boolean isGroupInGroup(Group child, Group parent) {
        return false;
    }

    @Override
    public Collection<User> getUsersInGroup(Group group) {
        return null;
    }

    @Override
    public void removeUserFromGroup(User user, Group group) {

    }

    @Override
    public void removeGroupFromGroup(Group child, Group parent) {

    }

    @Override
    public void removeAllUsers(Group group) {

    }
}
