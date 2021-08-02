package edu.cnm.deepdive.tilematch.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.tilematch.BuildConfig;
import edu.cnm.deepdive.tilematch.model.entity.Gallery;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;



public interface WebServiceProxy {
    @GET("api")
    Single<Gallery.SearchResult> getHits(
        @Query("key") String key, @Query("per_page") int per_page);

    static WebServiceProxy getInstance() {
      return InstanceHolder.INSTANCE;
    }


    class InstanceHolder {

      private static final WebServiceProxy INSTANCE;

      static {
        Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build();
        Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .build();
        INSTANCE = retrofit.create(WebServiceProxy.class);
      }

    }
  }