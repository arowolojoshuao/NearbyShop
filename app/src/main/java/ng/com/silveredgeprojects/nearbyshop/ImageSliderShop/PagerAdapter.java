package ng.com.silveredgeprojects.nearbyshop.ImageSliderShop;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

import ng.com.silveredgeprojects.nearbyshop.Model.ItemImage;
import ng.com.silveredgeprojects.nearbyshop.Preferences.UtilityFunctions;

/**
 * Created by sumeet on 23/4/17.
 */

public class PagerAdapter extends FragmentPagerAdapter {



    private List<Object> imagesList;


    public PagerAdapter(FragmentManager fm, List<Object> imagesList) {
        super(fm);

        this.imagesList = imagesList;
    }

    @Override
    public Fragment getItem(int position) {

        FragmentShopImage fragment = new FragmentShopImage();

        Bundle bundle = new Bundle();
        ItemImage taxiData = (ItemImage) imagesList.get(position);
        String jsonString = UtilityFunctions.provideGson()
                .toJson(taxiData);


        bundle.putString("shop_image",jsonString);
        fragment.setArguments(bundle);




        showLogMessage("List Size : " + String.valueOf(imagesList.size()));

        return fragment;
    }



    void showLogMessage(String string)
    {
        Log.d("image_slider",string);
    }




    @Override
    public int getCount() {
        return imagesList.size();
    }




}
