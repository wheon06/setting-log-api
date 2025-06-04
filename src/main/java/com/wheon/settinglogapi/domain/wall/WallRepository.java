package com.wheon.settinglogapi.domain.wall;

import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface WallRepository {

    Long save(Wall wall);

    Set<Long> saveBulk(Set<Wall> walls);

}
