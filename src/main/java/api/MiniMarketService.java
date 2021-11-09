package api;

import model.CategoryDto;
import model.ProductDto;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;


import java.util.List;

public interface MiniMarketService {

    @GET("api/v1/categories/{id}")
    Call<CategoryDto> getCategory(@Path("id") long id);

    @GET("api/v1/products/{id}")
    Call<ProductDto> getProduct (@Path("id") long id);

    @GET ("api/v1/products")
    Call<List<ProductDto>> getProducts();

    @POST("api/v1/products")
    Call<ProductDto> createProduct (@Body ProductDto postProduct);

    @PUT("api/v1/products")
    Call<ProductDto> updateProduct(@Body ProductDto putProduct);

    @DELETE("api/v1/products/{id}")
    Call<ResponseBody> deleteProduct (@Path("id") long id);





}
