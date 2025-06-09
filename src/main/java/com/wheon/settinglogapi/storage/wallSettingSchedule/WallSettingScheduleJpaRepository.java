package com.wheon.settinglogapi.storage.wallSettingSchedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WallSettingScheduleJpaRepository extends JpaRepository<WallSettingScheduleEntity, Long> {

}
