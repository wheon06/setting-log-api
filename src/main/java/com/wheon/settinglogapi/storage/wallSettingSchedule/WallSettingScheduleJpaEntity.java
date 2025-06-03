package com.wheon.settinglogapi.storage.wallSettingSchedule;

import com.wheon.settinglogapi.domain.wall.Wall;
import com.wheon.settinglogapi.storage.wall.WallJpaEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "wall_setting_schedule_tb")
public class WallSettingScheduleJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "wall_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private WallJpaEntity wall;

    private LocalDate settingDate;

    private LocalDate teardownDate;

}
