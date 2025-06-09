package com.wheon.settinglogapi.storage.wall;

import lombok.*;
import com.wheon.settinglogapi.domain.wall.Wall;
import com.wheon.settinglogapi.domain.center.Center;
import jakarta.persistence.*;

@Getter
@Entity
@Table(name = "wall_tb")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WallEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long centerId;
    private String name;

    public Wall toDomain() {
        return new Wall(
                this.id,
                this.name
        );
    }

    public static WallEntity of(Wall wall, Center center) {
        return new WallEntity(
                wall.getId(),
                center.getId(),
                wall.getName()
        );
    }

    public WallEntity(Long centerId, String name) {
        this.centerId = centerId;
        this.name = name;
    }

}
