package com.wheon.settinglogapi.storage.center;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.wheon.settinglogapi.domain.center.Center;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
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
        Long successId = centerCoreRepository.save(center).getId();

        // then
        assertThat(successId).isEqualTo(CenterEntity.of(center).getId());
    }

    @Test
    @DisplayName("이름이 같은 센터 하나를 찾을 수 있다.")
    void findByName() {
        // given
        Center center = new Center("더클라임 문래");

        given(centerJpaRepository.findByName(anyString()))
                .willReturn(Optional.of(CenterEntity.of(center)));

        // when & than
        assertThat(centerCoreRepository.findByName("더클라임 문래"))
                .isPresent();
    }
}