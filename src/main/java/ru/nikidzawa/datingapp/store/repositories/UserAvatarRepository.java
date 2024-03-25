package ru.nikidzawa.datingapp.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nikidzawa.datingapp.store.entities.user.UserAvatar;

public interface UserAvatarRepository extends JpaRepository<UserAvatar, Long> {
}