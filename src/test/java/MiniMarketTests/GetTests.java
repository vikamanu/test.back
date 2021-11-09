package MiniMarketTests;

import api.MiniMarketService;
import api.RetrofitUtils;
import model.CategoryDto;
import model.ProductDto;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetTests {

    static MiniMarketService miniMarketService;

    @BeforeAll
    static void setUp(){
        miniMarketService = RetrofitUtils.getRetrofit().create(MiniMarketService.class);
    }

    @Test
    @DisplayName("Get Categories Info")
    void GetCategoryById() throws IOException {

        Response<CategoryDto> responseCategory = miniMarketService.getCategory(1).execute();
        assertThat (responseCategory.isSuccessful(), CoreMatchers.is(true));
    }


    @Test
    @DisplayName("Get Products Info")
    void getProducts() throws IOException {

        List<ProductDto> responseProducts = miniMarketService.getProducts().execute().body();
        assertThat(responseProducts.get(1).getCategoryTitle(),equalTo("Food"));
    }

    @Test
    @DisplayName("Get Product Info")
    void GetProductById() throws IOException {

        Response<ProductDto> responseProduct = miniMarketService.getProduct(3).execute();
        assertThat(responseProduct.body().getTitle(), equalTo("Cheese"));
    }
}
