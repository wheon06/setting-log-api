package com.wheon.settinglogapi.domain.center;

import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CenterRepository {

    Long save(Center center);

    Optional<Center> findByName(String name);

}
