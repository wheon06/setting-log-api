package com.wheon.settinglogapi.domain.wall;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class Wall {

    private Long id;
    private String name;

    public Wall(String name) {
        this.name = name;
    }
}
