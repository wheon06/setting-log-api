package com.wheon.settinglogapi.api.controller.request;

import com.wheon.settinglogapi.domain.center.Center;
import com.wheon.settinglogapi.domain.wall.Wall;
import jakarta.validation.constraints.NotEmpty;

public record WallRequest(
        @NotEmpty(message = "벽(섹터) 이름을 입력해주세요.")
        String name
) {
    public Wall toDomain(Center center) {
        return new Wall(center, this.name);
    }
}
