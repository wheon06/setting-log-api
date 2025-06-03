package com.wheon.settinglogapi.storage.center;

import com.wheon.settinglogapi.domain.center.Center;
import com.wheon.settinglogapi.domain.center.CenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CenterCoreRepository implements CenterRepository {

    private final CenterJpaRepository centerJpaRepository;

    @Override
    public Long save(Center center) {
        CenterJpaEntity centerJpaEntity = centerJpaRepository.save(CenterJpaEntity.of(center));
        return centerJpaEntity.getId();
    }

}
