package com.wheon.settinglogapi.domain.wallSettingSchedule;

import com.wheon.settinglogapi.domain.wall.Wall;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class WallSettingSchedule {

    private final Long id;
    private final Wall wall;
    private final LocalDate settingDate;
    private final LocalDate teardownDate;

}
