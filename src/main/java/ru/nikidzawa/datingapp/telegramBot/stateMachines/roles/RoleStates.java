package ru.nikidzawa.datingapp.telegramBot.stateMachines.roles;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class RoleStates {
    public HashSet<String> superRoles;
    public HashSet<String> allRoles;

    public RoleStates() {
        superRoles = new HashSet<>(List.of("creator", "administrator"));
        allRoles = new HashSet<>(List.of("member", "creator", "administrator"));
    }
}
