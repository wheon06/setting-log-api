package com.wheon.settinglogapi.domain.center;

import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CenterRepository {

    Center save(Center center);

    Optional<Center> findById(Long id);

    Optional<Center> findByName(String name);

}
