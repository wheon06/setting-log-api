package com.wheon.settinglogapi.domain.wall;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.BDDMockito.given;

import com.wheon.settinglogapi.domain.center.Center;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class WallAppenderTest {

    @InjectMocks
    private WallAppender wallAppender;

    @Mock
    private WallRepository wallRepository;

    @Test
    @DisplayName("벽(섹터) 정보를 추가한 후 wallId를 반환한다.")
    void append() {
        // given
        Center center = new Center("더클라임 문래");
        Wall wall = new Wall(center, "망치");

        given(wallRepository.save(any(Wall.class))).willReturn(1L);

        // when
        Long successId = wallAppender.append(wall);

        // then
        assertThat(successId).isEqualTo(1L);
    }

    @Test
    @DisplayName("여러 벽(섹터) 정보를 추가한 후 wallId 목록을 반환한다.")
    void appendBulk() {
        // given
        Center center = new Center("더클라임 문래");
        Set<Wall> walls = new HashSet<>(Set.of(
                new Wall(center, "망치"),
                new Wall(center, "모루")
        ));

        given(wallRepository.saveBulk(anySet())).willReturn(Set.of(1L, 2L));

        // when
        Set<Long> successIds = wallAppender.appendBulk(walls);

        // then
        assertThat(successIds).isEqualTo(Set.of(1L, 2L));
    }
}