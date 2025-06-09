package com.wheon.settinglogapi.domain.wall;

import com.wheon.settinglogapi.domain.center.Center;
import com.wheon.settinglogapi.domain.center.CenterWithWalls;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.Set;

@Repository
public interface WallRepository {

    Long save(Wall wall, Center center);

    Set<Long> saveBulk(CenterWithWalls centerWithWalls);

    Optional<Wall> findById(Long id);

}
