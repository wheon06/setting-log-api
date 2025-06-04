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
    public Long append(Center center) {
        Long successId = centerRepository.save(center);
        wallAppender.appendBulk(center.getWalls());
        return successId;
    }

}
