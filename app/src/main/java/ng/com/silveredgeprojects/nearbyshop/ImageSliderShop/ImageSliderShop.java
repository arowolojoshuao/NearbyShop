package ng.com.silveredgeprojects.nearbyshop.ImageSliderShop;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.com.silveredgeprojects.nearbyshop.Model.ItemImage;
import ng.com.silveredgeprojects.nearbyshop.Preferences.UtilityFunctions;
import ng.com.silveredgeprojects.nearbyshop.R;

/**
 * Created by sumeet on 23/4/17.
 */

public class ImageSliderShop extends AppCompatActivity {


    @BindView(R.id.view_pager)
    ViewPager viewPager;
    FragmentPagerAdapter pagerAdapter;

    List<Object> listImages;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.image_slider);
        ButterKnife.bind(this);



        Gson gson = UtilityFunctions.provideGson();
        String itemJson = getIntent().getStringExtra("images_list");
        Type listType = new TypeToken<ArrayList<ItemImage>>(){}.getType();
        listImages = gson.fromJson(itemJson, listType);

        int position = getIntent().getIntExtra("position",0);

        showLogMessage(itemJson);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),listImages);
        viewPager.setAdapter(pagerAdapter);

        viewPager.setCurrentItem(position);
    }


    void showToastMessage(String message)
    {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }



    void showLogMessage(String string)
    {
        Log.d("image_slider",string);
    }

}
