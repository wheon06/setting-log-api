package com.wheon.settinglogapi.storage.center;

import lombok.RequiredArgsConstructor;
import com.wheon.settinglogapi.domain.center.Center;
import com.wheon.settinglogapi.domain.center.CenterRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CenterCoreRepository implements CenterRepository {

    private final CenterJpaRepository centerJpaRepository;

    @Override
    public Center save(Center center) {
        CenterEntity result = centerJpaRepository.save(CenterEntity.of(center));
        centerJpaRepository.flush();
        return result.toDomain();
    }

    @Override
    public Optional<Center> findById(Long id) {
        return centerJpaRepository.findById(id)
                .map(CenterEntity::toDomain);
    }

    @Override
    public Optional<Center> findByName(String name) {
        return centerJpaRepository.findByName(name)
                .map(CenterEntity::toDomain);
    }

}
