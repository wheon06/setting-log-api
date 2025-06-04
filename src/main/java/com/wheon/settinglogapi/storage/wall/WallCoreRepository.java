package com.wheon.settinglogapi.storage.wall;

import com.wheon.settinglogapi.domain.wall.Wall;
import com.wheon.settinglogapi.domain.wall.WallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class WallCoreRepository implements WallRepository {

    private final WallJpaRepository wallJpaRepository;

    @Override
    public Long save(Wall wall) {
        WallEntity wallEntity = wallJpaRepository.save(WallEntity.of(wall));
        return wallEntity.getId();
    }

    @Override
    public Set<Long> saveBulk(Set<Wall> walls) {
        Set<WallEntity> wallEntities = walls.stream()
                .map(WallEntity::of)
                .collect(Collectors.toSet());

        List<WallEntity> results = wallJpaRepository.saveAll(wallEntities);

        return results.stream()
                .map(WallEntity::getId)
                .collect(Collectors.toSet());
    }

}
