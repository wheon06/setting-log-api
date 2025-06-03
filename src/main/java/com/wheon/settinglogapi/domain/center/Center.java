package com.wheon.settinglogapi.domain.center;

import lombok.Getter;

@Getter
public class Center {

    private Long id;
    private String name;

    public Center(String name) {
        this.name = name;
    }
}
