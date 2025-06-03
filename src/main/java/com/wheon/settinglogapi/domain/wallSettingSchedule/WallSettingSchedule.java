package com.wheon.settinglogapi.domain.wallSettingSchedule;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.wheon.settinglogapi.domain.wall.Wall;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class WallSettingSchedule {

    private Long id;
    private Wall wall;
    private LocalDate settingDate;
    private LocalDate teardownDate;

}
