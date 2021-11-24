package ru.manuvika.retrofit.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import ru.manuvika.retrofit.dto.ProductDto;

import java.util.List;

public interface MiniMarketApi {

    @GET("/market/api/v1/products")
    Call<List<ProductDto>> getProducts();

    @GET("/market/api/v1/products/{id}")
    Call<ProductDto> getProduct(@Path("id") long id);

    @POST("/market/api/v1/products")
    Call<ProductDto> createProduct(@Body ProductDto product);

    @PUT("/market/api/v1/products")
    Call<ProductDto> updateProduct(@Body ProductDto product);

    @DELETE("/market/api/v1/products/{id}")
    Call<ResponseBody> deleteProduct(@Path("id") long id);

}
