package com.wheon.settinglogapi.api.controller.request;

import lombok.Getter;
import com.wheon.settinglogapi.domain.center.Center;
import jakarta.validation.constraints.NotEmpty;

@Getter
public class CenterRequest {

    @NotEmpty(message = "이름을 입력해주세요.")
    private String name;

    public Center toDomain() {
        return new Center(
                this.name
        );
    }

}
