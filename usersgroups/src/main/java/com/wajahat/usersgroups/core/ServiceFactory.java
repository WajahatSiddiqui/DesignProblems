package com.wajahat.usersgroups.core;

import com.wajahat.usersgroups.api.GroupService;
import com.wajahat.usersgroups.api.MembershipService;
import com.wajahat.usersgroups.api.UserService;
import com.wajahat.usersgroups.memory.MemoryGroupService;
import com.wajahat.usersgroups.memory.MemoryMembershipService;
import com.wajahat.usersgroups.memory.MemoryUserService;

/**
 * Factory for building a new memory-based users-and-groups memory.
 *
 * @author wajahat
 */
public class ServiceFactory implements Services {
    private final UserService userService;
    private final GroupService groupService;
    private final MembershipService membershipService;

    public static Services createServices() {
        return new ServiceFactory();
    }

    private ServiceFactory() {
        userService = new MemoryUserService(this);
        groupService = new MemoryGroupService(this);
        membershipService = new MemoryMembershipService(this);
    }

    @Override
    public GroupService groupService() {
        return groupService;
    }

    @Override
    public UserService userService() {
        return userService;
    }

    @Override
    public MembershipService membershipService() {
        return membershipService;
    }
}
