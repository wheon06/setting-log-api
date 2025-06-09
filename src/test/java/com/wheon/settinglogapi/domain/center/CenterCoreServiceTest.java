package com.wheon.settinglogapi.domain.center;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import com.wheon.settinglogapi.domain.wall.Wall;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class CenterCoreServiceTest {

    @InjectMocks
    private CenterCoreService centerCoreService;

    @Mock
    private CenterAppender centerAppender;

    @Mock
    private CenterValidator centerValidator;

    @Test
    @DisplayName("센터를 추가할 수 있다.")
    void append() {
        // given
        Center center = new Center("더클라임 문래");
        Set<Wall> walls = new HashSet<>(Set.of(
                new Wall("망치"),
                new Wall("모루")
        ));
        CenterWithWalls centerWithWalls = new CenterWithWalls(center, walls);

        given(centerAppender.append(any(CenterWithWalls.class))).willReturn(1L);

        // when
        Long successId = centerCoreService.append(centerWithWalls);

        // then
        assertThat(successId).isEqualTo(1L);
        verify(centerValidator).validateNameUnique(anyString());
    }
}