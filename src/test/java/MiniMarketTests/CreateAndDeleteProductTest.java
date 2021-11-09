package MiniMarketTests;

import api.MiniMarketService;
import api.RetrofitUtils;
import model.ProductDto;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.*;

import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

public class CreateAndDeleteProductTest {

    static MiniMarketService miniMarketService;
    ProductDto postProduct;
    int id;

    @BeforeAll
    static void setUp() {
        miniMarketService = RetrofitUtils.getRetrofit().create(MiniMarketService.class);
    }

    @BeforeEach
    void setUpPostProduct() {
        postProduct = ProductDto.builder()
                .title("Apple Juice")
                .categoryTitle("Food")
                .price(20)
                .build();
    }

    @Test
    @DisplayName("Create and Delete Product")
    void PostProduct() throws IOException {
        Response<ProductDto> responsePostProduct = miniMarketService.createProduct(postProduct).execute();
        id = Math.toIntExact(responsePostProduct.body().getId());
        assertThat(responsePostProduct.isSuccessful(), CoreMatchers.is(true));
    }

    @AfterEach
    void tearDown() throws IOException {
        Response<ResponseBody> responseDeleteProduct = miniMarketService.deleteProduct(id).execute();
        assertThat(responseDeleteProduct.isSuccessful(),CoreMatchers.is(true));
    }

}

