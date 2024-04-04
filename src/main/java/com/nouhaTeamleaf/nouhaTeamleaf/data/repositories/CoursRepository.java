package com.nouhaTeamleaf.nouhaTeamleaf.data.repositories;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Cours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours,Long> {
    Page<Cours> findAllByModuleContainsAndActiveTrue(Pageable pageable,String module);
}
