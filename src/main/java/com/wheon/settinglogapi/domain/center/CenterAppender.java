package com.wheon.settinglogapi.domain.center;

import lombok.RequiredArgsConstructor;
import com.wheon.settinglogapi.domain.wall.WallAppender;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CenterAppender {

    private final WallAppender wallAppender;
    private final CenterRepository centerRepository;

    @Transactional
    public Long append(CenterWithWalls centerWithWalls) {
        Center center = centerRepository.save(centerWithWalls.getCenter());
        CenterWithWalls hasSavedCenter = new CenterWithWalls(center, centerWithWalls.getWalls());
        wallAppender.appendBulk(hasSavedCenter);
        return center.getId();
    }

}
