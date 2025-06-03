package com.wheon.settinglogapi.domain.center;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CenterAppender {

    private final CenterRepository centerRepository;

    public Long append(Center center) {
        return centerRepository.save(center);
    }

}
