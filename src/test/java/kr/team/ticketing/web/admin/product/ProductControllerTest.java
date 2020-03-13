package kr.team.ticketing.web.admin.product;

import kr.team.ticketing.common.ControllerTests;
import kr.team.ticketing.domain.product.Product;
import kr.team.ticketing.domain.product.category.Category;
import kr.team.ticketing.domain.product.category.CategoryRepository;
import kr.team.ticketing.web.admin.product.request.OptionParam;
import org.junit.jupiter.api.BeforeEach;
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

class ProductControllerTest extends ControllerTests {
    private static final String PRODUCT_URI = getUri(ProductController.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryRepository.save(new Category("공연"));
    }

    @DisplayName("상품 추가")
    @Test
    void saveProduct() throws Exception {
        // given
        Product product = Product.builder()
                .categoryId(1l)
                .description("뮬란 공연입니다.")
                .content("뮬란 공연은 중국 남북조시대 작자 미상의 화목란의 이야기를 바탕으로 개편된 공연입니다.")
                .event("")
                .build();

        // when & then
        mockMvc.perform(post(PRODUCT_URI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(product)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andDo(document("product/save",
                        requestFields(
                                fieldWithPath("id").type(JsonFieldType.NULL).description("상품 ID"),
                                fieldWithPath("createdDate").type(JsonFieldType.NULL).description("상품 생성일"),
                                fieldWithPath("modifiedDate").type(JsonFieldType.NULL).description("상품 수정일"),
                                fieldWithPath("options").type(JsonFieldType.ARRAY).description("상품 옵션"),
                                fieldWithPath("categoryId").type(JsonFieldType.NUMBER).description("카테고리 ID"),
                                fieldWithPath("description").type(JsonFieldType.STRING).description("상품 간략 설명"),
                                fieldWithPath("content").type(JsonFieldType.STRING).description("상품 상세 설명"),
                                fieldWithPath("event").type(JsonFieldType.STRING).description("상품 이벤트")
                        )
                ));
    }

    @DisplayName("상품 옵션 추가")
    @Test
    void saveOption() throws Exception {
        // given
        OptionParam param = OptionParam.builder()
                .productType("ADULT")
                .discountRate(0.2)
                .price(17000)
                .build();

        // when & then
        mockMvc.perform(post(PRODUCT_URI + "/1" + "/options")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(param)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andDo(document("product/saveOption",
                        requestFields(
                                fieldWithPath("productType").type(JsonFieldType.STRING).description("옵션 타입"),
                                fieldWithPath("discountRate").type(JsonFieldType.NUMBER).description("옵션 할인율"),
                                fieldWithPath("price").type(JsonFieldType.NUMBER).description("옵션 가격")
                        )
                ));
    }
}