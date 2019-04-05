package ng.com.silveredgeprojects.nearbyshop.DaggerModules;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ng.com.silveredgeprojects.nearbyshop.MyApplication;
import ng.com.silveredgeprojects.nearbyshop.Preferences.PrefGeneral;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.CartItemService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.CartService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.CartStatsService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.DeliveryAddressService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.FavouriteItemService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.FavouriteShopService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.ItemCategoryService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.ItemImageService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.ItemReviewService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.ItemService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.ItemSpecItemService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.ItemSpecNameService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.ItemSpecValueService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.OrderItemService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.OrderService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.ServiceConfigurationService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.ShopImageService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.ShopItemService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.ShopReviewService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.ShopReviewThanksService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.ShopService;
import ng.com.silveredgeprojects.nearbyshop.RetrofitRESTContract.UserService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sumeet on 14/5/16.
 */

        /*
        retrofit = new Retrofit.Builder()
                .baseUrl(UtilityGeneral.getServiceURL(context))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        */

@Module
public class NetModule {

    String serviceURL;

    // Constructor needs one parameter to instantiate.
    public NetModule() {

    }

    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Singleton
    // Application reference must come from AppModule.class
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    /*
    @Provides
    @Singleton
    Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    */



    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        //gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

//        .setDateFormat("yyyy-MM-dd hh:mm:ss.S")
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {

        // cache is commented out ... you can add cache by putting it back in the builder options
        //.cache(cache)

        //Cache cache

        return new OkHttpClient()
                .newBuilder()
                .build();
    }



    @Provides
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {

//        Log.d("applog","Retrofit: " + PrefGeneral.getServiceURL(MyApplication.getAppContext()));

        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(PrefGeneral.getServiceURL(MyApplication.getAppContext()))
                .client(okHttpClient)
                .build();
    }




    @Provides
    ShopItemService provideShopItemService(Retrofit retrofit)
    {

        ShopItemService shopItemService = retrofit.create(ShopItemService.class);

//        Log.d("applog","ShopItemService : " + PrefGeneral.getServiceURL(MyApplication.getAppContext()));

        return shopItemService;
    }


    @Provides
    CartService provideCartService(Retrofit retrofit)
    {
        CartService cartService = retrofit.create(CartService.class);

//        Log.d("applog","CartService : " + PrefGeneral.getServiceURL(MyApplication.getAppContext()));

        return cartService;
    }


    @Provides
    CartItemService provideCartItemService(Retrofit retrofit)
    {
        CartItemService cartItemService = retrofit.create(CartItemService.class);

//        Log.d("applog","CartItemService : " + PrefGeneral.getServiceURL(MyApplication.getAppContext()));

        return  cartItemService;
    }


    @Provides
    CartStatsService provideCartStatsService(Retrofit retrofit)
    {
        CartStatsService service = retrofit.create(CartStatsService.class);

//        Log.d("applog","CartStatsService : " + PrefGeneral.getServiceURL(MyApplication.getAppContext()));

        return service;
    }

    @Provides
    DeliveryAddressService provideDeliveryAddressService(Retrofit retrofit)
    {

        DeliveryAddressService service = retrofit.create(DeliveryAddressService.class);

//        Log.d("applog","DeliveryAddressService : " + PrefGeneral.getServiceURL(MyApplication.getAppContext()));

        return service;
    }


    @Provides
    OrderService provideOrderService(Retrofit retrofit)
    {
        OrderService service = retrofit.create(OrderService.class);

//        Log.d("applog","OrderServicePFS : " + PrefGeneral.getServiceURL(MyApplication.getAppContext()));

        return service;
    }


    @Provides
    OrderItemService orderItemService(Retrofit retrofit)
    {
        return retrofit.create(OrderItemService.class);
    }



    @Provides
    ItemCategoryService itemCategoryService(Retrofit retrofit)
    {
        ItemCategoryService service = retrofit.create(ItemCategoryService.class);

//        Log.d("applog","ItemCategoryService : " + PrefGeneral.getServiceURL(MyApplication.getAppContext()));

        return service;
    }


    @Provides
    ServiceConfigurationService configurationService(Retrofit retrofit)
    {
        ServiceConfigurationService configurationService = retrofit.create(ServiceConfigurationService.class);
        return configurationService;
    }


    @Provides
    ItemService itemService(Retrofit retrofit)
    {

        return retrofit.create(ItemService.class);
    }


    @Provides
    ItemImageService itemImageService(Retrofit retrofit)
    {
        return retrofit.create(ItemImageService.class);
    }

    @Provides
    ItemSpecNameService itemSpecNameService(Retrofit retrofit)
    {
        return retrofit.create(ItemSpecNameService.class);
    }


    @Provides
    ItemSpecValueService itemSpecValueService(Retrofit retrofit)
    {
        return retrofit.create(ItemSpecValueService.class);
    }


    @Provides
    ItemSpecItemService itemSpecItemService(Retrofit retrofit)
    {
        return retrofit.create(ItemSpecItemService.class);
    }




    @Provides
    ShopService shopService(Retrofit retrofit)
    {

        ShopService shopService = retrofit.create(ShopService.class);
        return shopService;
    }




    @Provides
    ShopReviewService shopReviewService(Retrofit retrofit)
    {

//        EndUserService endUserService = ;
        return retrofit.create(ShopReviewService.class);
    }


    @Provides
    ItemReviewService itemReviewService(Retrofit retrofit)
    {
        return retrofit.create(ItemReviewService.class);
    }



    @Provides
    FavouriteShopService favouriteShopService(Retrofit retrofit)
    {

//        EndUserService endUserService = ;
        return retrofit.create(FavouriteShopService.class);
    }


    @Provides
    FavouriteItemService favouriteItemService(Retrofit retrofit)
    {
        return retrofit.create(FavouriteItemService.class);
    }



    @Provides
    ShopReviewThanksService shopReviewThanksService(Retrofit retrofit)
    {

//        EndUserService endUserService = ;
        return retrofit.create(ShopReviewThanksService.class);
    }


    @Provides
    UserService provideUserService(Retrofit retrofit)
    {
        return retrofit.create(UserService.class);
    }



    @Provides
    ShopImageService provideShopImage(Retrofit retrofit)
    {
        return retrofit.create(ShopImageService.class);
    }


}
