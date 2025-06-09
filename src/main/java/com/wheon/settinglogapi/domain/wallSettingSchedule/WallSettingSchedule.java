package com.wheon.settinglogapi.domain.wallSettingSchedule;

import lombok.Getter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WallSettingSchedule {

    private Long id;
    private LocalDate lastSettingDate;
    private LocalDate nextSettingDate;
    private LocalDate teardownDate;

}
