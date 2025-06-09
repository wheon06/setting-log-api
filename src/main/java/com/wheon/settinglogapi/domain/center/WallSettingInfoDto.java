package com.wheon.settinglogapi.domain.center;

import lombok.Getter;
import lombok.AllArgsConstructor;
import com.wheon.settinglogapi.domain.wall.Wall;
import com.wheon.settinglogapi.domain.wallSettingSchedule.WallSettingSchedule;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class WallSettingInfoDto {

    List<Wall> walls;
    Map<Long, WallSettingSchedule> wallSettingScheduleMap;

}
