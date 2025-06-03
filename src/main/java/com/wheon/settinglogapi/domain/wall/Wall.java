package com.wheon.settinglogapi.domain.wall;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.wheon.settinglogapi.domain.center.Center;

@Getter
@RequiredArgsConstructor
public class Wall {

    private final Long id;
    private final Center center;
    private final String name;

}
