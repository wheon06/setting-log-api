package com.wheon.settinglogapi.domain.center;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CenterReader {

    private final CenterValidator centerValidator;
    private final CenterRepository centerRepository;

    @Transactional(readOnly = true)
    public Center read(Long id) {
        centerValidator.validateIsExists(id);
        return centerRepository.findById(id).get();
    }

}
