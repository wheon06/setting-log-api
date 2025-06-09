package com.wheon.settinglogapi.storage.wall;

import com.wheon.settinglogapi.domain.center.Center;
import com.wheon.settinglogapi.domain.center.CenterReader;
import com.wheon.settinglogapi.domain.center.CenterWithWalls;
import com.wheon.settinglogapi.domain.wall.Wall;
import com.wheon.settinglogapi.domain.wall.WallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class WallCoreRepository implements WallRepository {

    private final CenterReader centerReader;
    private final WallJpaRepository wallJpaRepository;

    @Override
    public Long save(Wall wall, Center center) {
        WallEntity wallEntity = WallEntity.of(wall, center);
        WallEntity result = wallJpaRepository.save(wallEntity);
        return result.getId();
    }

    @Override
    public Set<Long> saveBulk(CenterWithWalls centerWithWalls) {
        Center center = centerWithWalls.getCenter();
        Set<Wall> walls = centerWithWalls.getWalls();

        Set<WallEntity> wallEntities = walls.stream()
                .map(wall -> WallEntity.of(wall, center))
                .collect(Collectors.toSet());

        List<WallEntity> results = wallJpaRepository.saveAll(wallEntities);

        return results.stream()
                .map(WallEntity::getId)
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<Wall> findById(Long id) {
        return wallJpaRepository.findById(id)
                .map(wallEntity -> {
                    Center center = centerReader.read(wallEntity.getCenterId());
                    return wallEntity.toDomain();
                });
    }

}
