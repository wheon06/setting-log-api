package com.wheon.settinglogapi.domain.center;

import lombok.Getter;
import com.wheon.settinglogapi.domain.wall.Wall;
import java.util.Set;

@Getter
public class Center {

    private Long id;
    private String name;
    private Set<Wall> walls;

    public void addWall(Wall wall) {
        this.walls.add(wall);
    }

    public Center(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Center(String name) {
        this.name = name;
    }
}
