package com.wheon.settinglogapi.storage.center;

import lombok.RequiredArgsConstructor;
import com.wheon.settinglogapi.domain.center.Center;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
class CenterCoreRepositoryTest {

    @InjectMocks
    private CenterCoreRepository centerCoreRepository;

    @Mock
    private CenterJpaRepository centerJpaRepository;

    @Test
    @DisplayName("센터를 저장할 수 있다.")
    void save() {
        // given
        Center center = new Center("더클라임 문래");

        given(centerJpaRepository.save(any(CenterEntity.class)))
                .willReturn(CenterEntity.of(center));

        // when
        Long successId = centerCoreRepository.save(center);

        // then
        assertEquals(CenterEntity.of(center).getId(), successId);
    }

    @Test
    @DisplayName("이름이 같은 센터 하나를 찾을 수 있다.")
    void findByName() {
        // given
        Center center = new Center("더클라임 문래");

        given(centerJpaRepository.findByName(anyString()))
                .willReturn(Optional.of(CenterEntity.of(center)));

        // when & than
        assertTrue(centerCoreRepository.findByName("더클라임 문래").isPresent());
    }
}