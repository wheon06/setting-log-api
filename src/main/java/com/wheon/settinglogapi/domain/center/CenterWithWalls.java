package com.wheon.settinglogapi.domain.center;

import lombok.Getter;
import lombok.AllArgsConstructor;
import com.wheon.settinglogapi.domain.wall.Wall;
import java.util.Set;

@Getter
@AllArgsConstructor
public class CenterWithWalls {

    private Center center;
    private Set<Wall> walls;

}
