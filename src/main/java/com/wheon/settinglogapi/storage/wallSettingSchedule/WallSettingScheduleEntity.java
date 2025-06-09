package com.wheon.settinglogapi.storage.wallSettingSchedule;

import com.wheon.settinglogapi.domain.wallSettingSchedule.WallSettingSchedule;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "wall_setting_schedule_tb")
public class WallSettingScheduleEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long wallId;
    private LocalDate lastSettingDate;
    private LocalDate nextSettingDate;
    private LocalDate teardownDate;

    public WallSettingSchedule toDomain() {
        return new WallSettingSchedule(
                this.id,
                this.lastSettingDate,
                this.nextSettingDate,
                this.teardownDate
        );
    }

}
