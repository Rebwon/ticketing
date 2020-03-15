package kr.team.ticketing.web.admin.product;

import kr.team.ticketing.common.ControllerTests;
import kr.team.ticketing.domain.product.display.Display;
import kr.team.ticketing.domain.product.display.DisplayRepository;
import kr.team.ticketing.web.admin.product.request.DisplayParam;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DisplayControllerTest extends ControllerTests {
    private static final String DISPLAY_URI = getUri(DisplayController.class);

    @Autowired
    private DisplayRepository displayRepository;

    @DisplayName("전시 정보 추가")
    @Test
    void saveDisplay() throws Exception {
        DisplayParam param = DisplayParam.builder()
                .productId(1l)
                .openingHours("2020년 3월 15일부터 2020년 4월 15일까지 진행되는 행사입니다.")
                .place("세종정부청사")
                .placeLot("경기도 세종시 231-31")
                .placeStreet("경기도 세종시 세종로 132번길 34")
                .homePage("www.display.com")
                .tel("010-2331-1233")
                .email("chulsu@naver.com")
                .build();

        mockMvc.perform(post(DISPLAY_URI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(param)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andDo(document("display/saveDisplay",
                        requestFields(
                                fieldWithPath("productId").type(JsonFieldType.NUMBER).description("상품 번호"),
                                fieldWithPath("openingHours").type(JsonFieldType.STRING).description("오프닝 정보"),
                                fieldWithPath("place").type(JsonFieldType.STRING).description("전시 장소"),
                                fieldWithPath("placeLot").type(JsonFieldType.STRING).description("전시 장소 지번 주소"),
                                fieldWithPath("placeStreet").type(JsonFieldType.STRING).description("전시 장소 도로명 주소"),
                                fieldWithPath("homePage").type(JsonFieldType.STRING).description("전시자 홈페이지"),
                                fieldWithPath("tel").type(JsonFieldType.STRING).description("전시자 전화번호"),
                                fieldWithPath("email").type(JsonFieldType.STRING).description("전시자 이메일")
                                )
                ));
    }
}