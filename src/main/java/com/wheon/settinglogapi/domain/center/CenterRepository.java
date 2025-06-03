package com.wheon.settinglogapi.domain.center;

import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository {

    Long save(Center center);

}
