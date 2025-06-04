package com.wheon.settinglogapi.domain.center;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

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

        given(centerAppender.append(any(Center.class))).willReturn(1L);

        // when
        Long successId = centerCoreService.append(center);

        // then
        assertThat(successId).isEqualTo(1L);
        verify(centerValidator).validateNameUnique(anyString());
    }
}