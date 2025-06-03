package com.wheon.settinglogapi.storage.wallSettingSchedule;

import com.wheon.settinglogapi.storage.wall.WallEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "wall_setting_schedule_tb")
public class WallSettingScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "wall_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private WallEntity wall;

    private LocalDate settingDate;

    private LocalDate teardownDate;

}
