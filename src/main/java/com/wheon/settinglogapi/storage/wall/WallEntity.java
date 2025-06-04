package com.wheon.settinglogapi.storage.wall;

import lombok.Getter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import com.wheon.settinglogapi.domain.wall.Wall;
import com.wheon.settinglogapi.storage.center.CenterEntity;
import jakarta.persistence.*;

@Getter
@Entity
@Table(name = "wall_tb")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WallEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "center_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CenterEntity center;

    private String name;

    public static WallEntity of(Wall wall) {
        return new WallEntity(
                CenterEntity.of(wall.getCenter()),
                wall.getName()
        );
    }

    public WallEntity(CenterEntity center, String name) {
        this.center = center;
        this.name = name;
    }
}
