package ng.com.silveredgeprojects.nearbyshop.ImageSlider;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.com.silveredgeprojects.nearbyshop.Model.ItemImage;
import ng.com.silveredgeprojects.nearbyshop.Preferences.PrefGeneral;
import ng.com.silveredgeprojects.nearbyshop.Preferences.UtilityFunctions;
import ng.com.silveredgeprojects.nearbyshop.R;

/**
 * Created by sumeet on 27/6/17.
 */

public class FragmentImage extends Fragment {



    ItemImage itemImageData;
    @BindView(R.id.taxi_image)
    ImageView taxiImage;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.title)
    TextView titleText;
    @BindView(R.id.description) TextView descriptionText;
    @BindView(R.id.copyrights) TextView copyrightText;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);


        setRetainInstance(true);
        View rootView = inflater.inflate(R.layout.fragment_item_image_slider, container, false);
        ButterKnife.bind(this,rootView);




        // decoding the object passed to the activity
        String jsonString = getArguments().getString("item_image");


        Gson gson = UtilityFunctions.provideGson();
        itemImageData = gson.fromJson(jsonString, ItemImage.class);


        Drawable drawable = ContextCompat.getDrawable(getActivity(),R.drawable.ic_nature_people_white_48px);

//        String imagePath = PrefGeneral.getServiceURL(getActivity()) + "/api/v1/TaxiImages/Image/" + "nine_hundred_"+ itemImageData.getImageFilename() + ".jpg";
//        String image_url = PrefGeneral.getServiceURL(getActivity()) + "/api/v1/TaxiImages/Image/" + itemImageData.getImageFilename();

        String imagePathSmall = PrefGeneral.getServiceURL(getActivity()) + "/api/v1/ItemImage/Image/five_hundred_"
                + itemImageData.getImageFilename() + ".jpg";


        String imagePathFullSize = PrefGeneral.getServiceURL(getActivity()) + "/api/v1/ItemImage/Image/"
                + itemImageData.getImageFilename();


        titleText.setText(itemImageData.getCaptionTitle());
        descriptionText.setText(itemImageData.getCaption());
        copyrightText.setText(itemImageData.getImageCopyrights());


        progressBar.setVisibility(View.VISIBLE);



        Picasso.with(getActivity())
                .load(imagePathFullSize)
                .into(taxiImage, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                        progressBar.setVisibility(View.GONE);

                    }

                    @Override
                    public void onError() {

                    }
                });



        return rootView;
    }









    void showLogMessage(String string)
    {
        Log.d("taxi_detail",string);
    }




    void showToastMessage(String message)
    {
        Toast.makeText(getActivity(),message, Toast.LENGTH_SHORT).show();
    }
}
