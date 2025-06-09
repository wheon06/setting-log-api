package com.wheon.settinglogapi.domain.wall;

import static com.wheon.settinglogapi.domain.support.exception.ExceptionCode.NOT_FOUND_WALL;

import lombok.RequiredArgsConstructor;
import com.wheon.settinglogapi.domain.support.exception.CoreException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WallValidator {

    private final WallRepository wallRepository;

    public void validateIsExists(Long id) {
        wallRepository.findById(id).orElseThrow(() -> new CoreException(NOT_FOUND_WALL));
    }

}
