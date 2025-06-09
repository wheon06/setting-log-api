package com.wheon.settinglogapi.api.controller.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import com.wheon.settinglogapi.domain.center.Center;
import com.wheon.settinglogapi.domain.center.CenterWithWalls;
import com.wheon.settinglogapi.domain.wall.Wall;
import java.util.stream.Collectors;
import java.util.Set;

public record CenterRequest(
        @NotEmpty(message = "이름을 입력해주세요.")
        String name,

        @Valid @NotEmpty(message = "하나 이상의 벽(섹터) 정보를 입력해주세요.")
        Set<WallRequest> walls
) {
    public CenterWithWalls toCenterWithWalls() {
        Center center = new Center(this.name);

        Set<Wall> walls = this.walls.stream()
                .map(WallRequest::toDomain)
                .collect(Collectors.toSet());

        return new CenterWithWalls(center, walls);
    }
}
