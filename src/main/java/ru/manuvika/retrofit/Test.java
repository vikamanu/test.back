package ru.manuvika.retrofit;
import retrofit2.Response;
import retrofit2.Retrofit;
import ru.manuvika.retrofit.api.MiniMarketApi;
import ru.manuvika.retrofit.dto.ProductDto;
import ru.manuvika.retrofit.utils.RetrofitGetter;

import java.io.IOException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
        RetrofitGetter getter = new RetrofitGetter();

        Retrofit retrofit = getter.getInstance();

        MiniMarketApi marketApi = retrofit.create(MiniMarketApi.class);

        Response<List<ProductDto>> productsResp = marketApi.getProducts().execute();
//        List<ProductDto> products = productsResp.body();
//
//        System.out.println(products);

//        ProductDto newProduct = ProductDto.builder()
//                .id(6L)
//                .price(227L)
//                .build();

        // marketApi.updateProduct(newProduct).execute();
//        System.out.println("New product created!");
//        Call<ResponseBody> productsCall = marketApi.getProducts();
//        Response<ResponseBody> productsResponse = productsCall.execute();// block
//
//        System.out.println(productsResponse);
//        System.out.println(productsResponse.body());
//        System.out.println(productsResponse.body().string());

//        productsCall.enqueue(new Callback<>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
//
//            }
//        });

    }
}
