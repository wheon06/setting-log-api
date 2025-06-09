package com.wheon.settinglogapi.api.controller.request;

import jakarta.validation.constraints.NotEmpty;
import com.wheon.settinglogapi.domain.wall.Wall;

public record WallRequest(
        @NotEmpty(message = "벽(섹터) 이름을 입력해주세요.")
        String name
) {
    public Wall toDomain() {
        return new Wall(this.name);
    }
}
