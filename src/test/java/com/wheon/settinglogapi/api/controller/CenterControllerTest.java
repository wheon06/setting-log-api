package com.wheon.settinglogapi.api.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.wheon.settinglogapi.api.controller.request.CenterRequest;
import com.wheon.settinglogapi.domain.center.Center;
import com.wheon.settinglogapi.domain.center.CenterCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@WebMvcTest(CenterController.class)
@AutoConfigureRestDocs(outputDir = "build/generated-snippets")
class CenterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private CenterCoreService centerCoreService;

    @Test
    @DisplayName("센터를 추가할 수 있다.")
    void appendCenter() throws Exception {
        // given
        CenterRequest centerRequest = new CenterRequest("더클라임 문래");

        when(centerCoreService.append(any(Center.class)))
                .thenReturn(1L);

        // when
        ResultActions resultActions = performPostRequest(centerRequest);

        // then
        resultActions.andExpect(status().isOk())
                .andDo(document("center-append",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestFields(
                                fieldWithPath("name").description("추가할 센터 이름")
                        ),
                        responseFields(
                                fieldWithPath("resultType").description("응답 결과 타입"),
                                fieldWithPath("error").description("에러 정보"),
                                fieldWithPath("success").description("성공 시 데이터"),
                                fieldWithPath("success.id").description("추가된 센터의 고유 ID")
                        )
                ));

    }

    private ResultActions performPostRequest(CenterRequest centerRequest) throws Exception {
        return mockMvc.perform(post("/center")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(centerRequest))
        );
    }

}