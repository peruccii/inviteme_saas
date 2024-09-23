package com.Invitemee.Invitemee.infra.repository;

import com.Invitemee.Invitemee.infra.entity.Invite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InviteRepository extends JpaRepository<Invite, Long> {
}
