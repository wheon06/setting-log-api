package com.wheon.settinglogapi.api.controller.request;

import com.wheon.settinglogapi.domain.center.Center;
import jakarta.validation.constraints.NotEmpty;

public record CenterRequest(
    @NotEmpty(message = "이름을 입력해주세요.")
    String name
) {
    public Center toDomain() {
        return new Center(this.name);
    }
}
