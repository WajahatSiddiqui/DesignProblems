package com.wajahat.usersgroups.core;

import com.wajahat.usersgroups.api.GroupService;
import com.wajahat.usersgroups.api.MembershipService;
import com.wajahat.usersgroups.api.UserService;

/**
 * Provides access to all of the services so that circular dependencies between them can be resolved.
 *
 * @author wajahat
 */
public interface Services {
    GroupService groupService();
    UserService userService();
    MembershipService membershipService();
}
