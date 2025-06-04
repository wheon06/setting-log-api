package com.wheon.settinglogapi.domain.wall;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class WallAppender {

    private final WallRepository wallRepository;

    public Long append(Wall wall) {
        return wallRepository.save(wall);
    }

    public Set<Long> appendBulk(Set<Wall> walls) {
        return wallRepository.saveBulk(walls);
    }

}
