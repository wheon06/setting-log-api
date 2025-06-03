package com.wheon.settinglogapi.api.controller;

import lombok.RequiredArgsConstructor;
import com.wheon.settinglogapi.api.controller.request.CenterRequest;
import com.wheon.settinglogapi.api.support.ApiResponse;
import com.wheon.settinglogapi.api.support.DefaultIdResult;
import com.wheon.settinglogapi.domain.center.CenterCoreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/center")
public class CenterController {

    private final CenterCoreService centerCoreService;

    @PostMapping()
    public ApiResponse<DefaultIdResult> appendCenter(@RequestBody @Valid CenterRequest centerRequest) {
        Long centerId = centerCoreService.append(centerRequest.toDomain());
        return ApiResponse.success(new DefaultIdResult(centerId));
    }

}
