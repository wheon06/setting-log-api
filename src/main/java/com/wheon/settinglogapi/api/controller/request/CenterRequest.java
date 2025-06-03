package com.wheon.settinglogapi.api.controller.request;

import com.wheon.settinglogapi.domain.center.Center;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

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
