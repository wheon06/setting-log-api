package com.wheon.settinglogapi.domain.center;

import lombok.Getter;

@Getter
public class Center {

    private Long id;
    private String name;

    public Center(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Center(String name) {
        this.name = name;
    }
}
