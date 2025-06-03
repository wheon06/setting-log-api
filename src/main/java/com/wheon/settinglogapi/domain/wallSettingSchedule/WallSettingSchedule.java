package com.wheon.settinglogapi.domain.wallSettingSchedule;

import com.wheon.settinglogapi.domain.wall.Wall;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class WallSettingSchedule {

    private Long id;
    private Wall wall;
    private LocalDate settingDate;
    private LocalDate teardownDate;

}
