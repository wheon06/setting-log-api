package com.wheon.settinglogapi.api.controller.request;

import com.wheon.settinglogapi.domain.center.Center;
import jakarta.validation.constraints.NotEmpty;
import java.util.Set;

public record CenterRequest(
        @NotEmpty(message = "이름을 입력해주세요.")
        String name,

        @NotEmpty(message = "하나 이상의 벽(섹터) 정보를 입력해주세요.")
        Set<WallRequest> walls
) {
    public Center toDomain() {
        Center center = new Center(this.name);
        walls.forEach(wallRequest -> center
                .addWall(wallRequest.toDomain(center))
        );
        return center;
    }
}
