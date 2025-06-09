package com.wheon.settinglogapi.domain.center;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CenterCoreService {

    private final CenterAppender centerAppender;
    private final CenterValidator centerValidator;

    public Long append(CenterWithWalls centerWithWalls) {
        Center center = centerWithWalls.getCenter();
        centerValidator.validateNameUnique(center.getName());
        return centerAppender.append(centerWithWalls);
    }

}
