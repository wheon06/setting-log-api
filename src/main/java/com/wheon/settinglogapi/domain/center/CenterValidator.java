package com.wheon.settinglogapi.domain.center;

import static com.wheon.settinglogapi.domain.support.exception.ExceptionCode.DUPLICATED_CENTER_NAME;
import static com.wheon.settinglogapi.domain.support.exception.ExceptionCode.NOT_FOUND_CENTER;

import lombok.RequiredArgsConstructor;
import com.wheon.settinglogapi.domain.support.exception.CoreException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CenterValidator {

    private final CenterRepository centerRepository;

    public void validateIsExists(Long id) {
        centerRepository.findById(id).orElseThrow(() -> new CoreException(NOT_FOUND_CENTER));
    }


    public void validateNameUnique(String name) {
        if (centerRepository.findByName(name).isPresent()) {
            throw new CoreException(DUPLICATED_CENTER_NAME);
        }
    }
}
