package ru.nikidzawa.datingapp.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nikidzawa.datingapp.store.entities.event.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

}
