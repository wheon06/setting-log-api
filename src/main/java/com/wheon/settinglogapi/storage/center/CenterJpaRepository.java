package com.wheon.settinglogapi.storage.center;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterJpaRepository extends JpaRepository<CenterJpaEntity, Long> {
}
