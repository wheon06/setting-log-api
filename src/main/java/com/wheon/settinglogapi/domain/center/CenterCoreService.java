package com.wheon.settinglogapi.domain.center;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CenterCoreService {

    private final CenterAppender centerAppender;

    public Long append(Center center) {
        return centerAppender.append(center);
    }

}
