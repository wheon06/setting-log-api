package com.wheon.settinglogapi.storage.wallSettingSchedule;

import lombok.RequiredArgsConstructor;
import com.wheon.settinglogapi.domain.wallSettingSchedule.WallSettingScheduleRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WallSettingScheduleCoreRepository implements WallSettingScheduleRepository {

    private final WallSettingScheduleJpaRepository wallSettingScheduleJpaRepository;

}
