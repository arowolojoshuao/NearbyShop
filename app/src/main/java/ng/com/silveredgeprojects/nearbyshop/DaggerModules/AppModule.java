package ng.com.silveredgeprojects.nearbyshop.DaggerModules;

import android.app.Application;



import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ng.com.silveredgeprojects.nearbyshop.MyApplication;

/**
 * Created by sumeet on 14/5/16.
 */

@Module
public class AppModule {

    MyApplication mApplication;

    public AppModule(MyApplication application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

}
