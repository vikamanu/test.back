package ru.manuvika.service;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import ru.manuvika.dto.Category;

public interface CategoryService {
    @GET("categories/{id}")
    Call<Category> getCategory(@Part("id") Integer id);
    Call<Category> getCategory(@Path("id") Integer id) ;
}
