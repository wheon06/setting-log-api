package com.wheon.settinglogapi.domain.wall;

import lombok.RequiredArgsConstructor;
import com.wheon.settinglogapi.domain.center.CenterWithWalls;
import com.wheon.settinglogapi.domain.center.Center;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class WallAppender {

    private final WallRepository wallRepository;

    public Long append(Wall wall, Center center) {
        return wallRepository.save(wall, center);
    }

    public Set<Long> appendBulk(CenterWithWalls centerWithWalls) {
        return wallRepository.saveBulk(centerWithWalls);
    }

}
