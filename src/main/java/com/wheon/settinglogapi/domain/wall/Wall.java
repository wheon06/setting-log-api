package com.wheon.settinglogapi.domain.wall;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.wheon.settinglogapi.domain.center.Center;

@Getter
@RequiredArgsConstructor
public class Wall {

    private Long id;
    private Center center;
    private String name;

}
