package com.wheon.settinglogapi.storage.wall;

import static com.wheon.settinglogapi.domain.support.exception.ExceptionCode.NOT_FOUND_WALL;

import lombok.RequiredArgsConstructor;
import com.wheon.settinglogapi.domain.support.exception.CoreException;
import com.wheon.settinglogapi.domain.wall.Wall;
import com.wheon.settinglogapi.domain.wall.WallRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WallReader {

    private final WallRepository wallRepository;

    public Wall read(Long id) {
        return wallRepository.findById(id)
                .orElseThrow(() -> new CoreException(NOT_FOUND_WALL));
    }

}
