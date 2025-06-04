package com.wheon.settinglogapi.storage.wall;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface WallJpaRepository extends JpaRepository<WallEntity, Long> {
}
