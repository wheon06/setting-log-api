package com.wheon.settinglogapi.storage.wall;

import com.wheon.settinglogapi.storage.center.CenterEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "wall_tb")
public class WallEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "center_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CenterEntity center;

    private String name;

}
