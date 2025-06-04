package com.wheon.settinglogapi.domain.wall;

import lombok.Getter;
import com.wheon.settinglogapi.domain.center.Center;

@Getter
public class Wall {

    private Long id;
    private Center center;
    private String name;

    public Wall(Center center, String name) {
        this.center = center;
        this.name = name;
    }
}
