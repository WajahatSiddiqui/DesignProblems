package com.wajahat.usersgroups.core;

/**
 * AbstractService
 *
 * @author wajahat
 */
public abstract class AbstractService {
    private final Services services;

    public AbstractService(Services services) {
        this.services = services;
    }
}
