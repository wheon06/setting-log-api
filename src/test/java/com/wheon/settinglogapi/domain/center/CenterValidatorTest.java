package com.wheon.settinglogapi.domain.center;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

import com.wheon.settinglogapi.domain.support.exception.CoreException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CenterValidatorTest {

    @InjectMocks
    private CenterValidator centerValidator;

    @Mock
    private CenterRepository centerRepository;

    @Test
    @DisplayName("추가할 센터 이름이 중복된다면 예외가 발생한다.")
    void validateNameUnique() {
        // given
        Center existingCenter = new Center("더클라임 문래");

        given(centerRepository.findByName(anyString())).willReturn(Optional.of(existingCenter));

        // when & then
        assertThatThrownBy(() -> centerValidator.validateNameUnique("더클라임 문래"))
                .isInstanceOf(CoreException.class)
                .extracting("code")
                .isEqualTo("E2001");
    }

}