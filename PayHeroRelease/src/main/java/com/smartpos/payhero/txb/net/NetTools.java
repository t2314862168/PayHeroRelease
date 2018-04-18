package com.smartpos.payhero.txb.net;


import com.smartpos.payhero.BuildConfig;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yy520 on 2018-4-9.
 */

public class NetTools {

    static String baseUrl = "http://47.96.163.9/mdyx/";

    public static Retrofit newRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    public static <T> T createService(Class<T> clazz) {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLogger());
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //添加拦截
        if (BuildConfig.LOG_DEBUG) {
            builder.addInterceptor(logInterceptor);
        }
        OkHttpClient client = builder.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        T t = retrofit.create(clazz);

        return t;
    }


    public static void post(String data, Observer<Response<ResponseBody>> processObserver) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), data);
        ApiService service = NetTools.createService(ApiService.class);
        service.post(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(processObserver);
    }

}
