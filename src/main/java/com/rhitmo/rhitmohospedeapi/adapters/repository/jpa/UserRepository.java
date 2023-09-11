package com.rhitmo.rhitmohospedeapi.adapters.repository.jpa;

import com.rhitmo.rhitmohospedeapi.adapters.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}