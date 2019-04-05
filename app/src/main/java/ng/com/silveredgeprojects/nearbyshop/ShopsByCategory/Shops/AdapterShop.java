package ng.com.silveredgeprojects.nearbyshop.ShopsByCategory.Shops;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ng.com.silveredgeprojects.nearbyshop.Model.Shop;
import ng.com.silveredgeprojects.nearbyshop.Preferences.PrefGeneral;
import ng.com.silveredgeprojects.nearbyshop.Preferences.PrefShopHome;
import ng.com.silveredgeprojects.nearbyshop.R;
import ng.com.silveredgeprojects.nearbyshop.ShopDetail.ShopDetail;
import ng.com.silveredgeprojects.nearbyshop.ShopHome.ShopHome;

/**
 * Created by sumeet on 25/5/16.
 */
public class AdapterShop extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<Shop> dataset = null;
    private Context context;
    private Fragment fragment;


    public AdapterShop(List<Shop> dataset, Context context, Fragment fragment) {
        this.dataset = dataset;
        this.context = context;
        this.fragment = fragment;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;

        if(viewType==0)
        {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_shops_by_item_category,parent,false);

            return new ViewHolder(view);
        }
        else
        {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_progress_bar,parent,false);

            return new LoadingViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder_given, int position) {

        if(holder_given instanceof ViewHolder) {

            ViewHolder holder = (ViewHolder) holder_given;

            holder.shopName.setText(dataset.get(position).getShopName());

            holder.rating.setText(String.format( "%.2f", dataset.get(position).getRt_rating_avg()));

            holder.distance.setText(String.format( "%.2f", dataset.get(position).getRt_distance() )+ " Km");

//        Log.d("applog","on BInd()");

//            String imagePath = UtilityGeneral.getImageEndpointURL(MyApplication.getAppContext())
//                    + dataset.get(position).getLogoImagePath();


            String imagePath = PrefGeneral.getServiceURL(context) + "/api/v1/Shop/Image/three_hundred_"
                    + dataset.get(position).getLogoImagePath() + ".jpg";

            Picasso.with(context)
                    .load(imagePath)
                    .placeholder(R.drawable.nature_people)
                    .into(holder.shopImage);


        }
        else if(holder_given instanceof LoadingViewHolder)
        {
            LoadingViewHolder viewHolder = (LoadingViewHolder) holder_given;

            int itemCount = 0;

            if(fragment instanceof FragmentShop)
            {
                itemCount = ((FragmentShop) fragment).getItemCount();
            }


            if(position == 0 || position == itemCount)
            {
                viewHolder.progressBar.setVisibility(View.GONE);
            }
            else
            {
                viewHolder.progressBar.setVisibility(View.VISIBLE);
                viewHolder.progressBar.setIndeterminate(true);

            }
        }



    }

    @Override
    public int getItemCount() {

//        Log.d("applog",String.valueOf(dataset.size()));

        return (dataset.size()+1);
    }


    @Override
    public int getItemViewType(int position) {
        super.getItemViewType(position);

        if(position==dataset.size())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public class LoadingViewHolder extends  RecyclerView.ViewHolder{

        @BindView(R.id.progress_bar)
        ProgressBar progressBar;

        public LoadingViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }




    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView shopName;
        ImageView shopImage;
        TextView distance;
        TextView rating;
        RelativeLayout listItem;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);


            listItem = (RelativeLayout) itemView.findViewById(R.id.list_item_shop);
            rating = (TextView) itemView.findViewById(R.id.rating);
            distance = (TextView) itemView.findViewById(R.id.distance);
            shopName = (TextView) itemView.findViewById(R.id.shopName);
            shopImage = (ImageView) itemView.findViewById(R.id.shopImage);

            shopImage.setOnClickListener(this);
            listItem.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            //Toast.makeText(context,"Item Click : " + String.valueOf(getLayoutPosition()),Toast.LENGTH_SHORT).show();

            switch (v.getId())
            {
                case R.id.shopImage:

                    Intent intent = new Intent(context, ShopDetail.class);
                    intent.putExtra(ShopDetail.SHOP_DETAIL_INTENT_KEY,dataset.get(getLayoutPosition()));
                    context.startActivity(intent);

                    break;

                case R.id.list_item_shop:

                    Intent shopHomeIntent = new Intent(context, ShopHome.class);
                    PrefShopHome.saveShop(dataset.get(getLayoutPosition()),context);
                    context.startActivity(shopHomeIntent);

                    break;

                default:
                    break;
            }
        }
    }
}
