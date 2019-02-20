package com.wajahat.usersgroups.domain;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import static java.util.Objects.requireNonNull;

/**
 * A group that may or may not have any users in it.
 *
 * @author {wajahat}
 */
@ParametersAreNonnullByDefault
public class Group implements Comparable<Group> {

    private String name;

    /**
     * Creates a new instance of a group.
     * This does not implicitly register the group with the {@link GroupService}.
     *
     * @param name the unique name that identifies this group; must not be {@code null}.
     */
    public Group(String name) { this.name = requireNonNull(name, "name"); }


    /**
     * Returns the name that identifies this group.
     *
     * @return the name that identifies this group.
     */
    public String getName() { return name; }

    @Override
    public int compareTo(@Nonnull  Group other) {
        return name.compareTo(other.name);
    }
}
