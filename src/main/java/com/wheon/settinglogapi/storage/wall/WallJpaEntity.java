package com.wheon.settinglogapi.storage.wall;

import com.wheon.settinglogapi.storage.center.CenterJpaEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "wall_tb")
public class WallJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "center_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CenterJpaEntity center;

    private String name;

}
