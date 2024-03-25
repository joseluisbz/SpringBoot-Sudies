package org.bz.app.mspeople.repositories;

import org.bz.app.mspeople.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    Optional<User> findFirstByEmailIgnoreCase(String email);

    List<User> findByEmailIgnoreCaseAndIdNot(String email, UUID id);
}