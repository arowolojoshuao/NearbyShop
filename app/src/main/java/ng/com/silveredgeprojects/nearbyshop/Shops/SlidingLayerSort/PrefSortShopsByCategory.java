package ng.com.silveredgeprojects.nearbyshop.Shops.SlidingLayerSort;

import android.content.Context;
import android.content.SharedPreferences;

import org.nearbyshops.enduserappnew.OrderHistoryNew.SlidingLayerSort.SlidingLayerSortOrders;
import org.nearbyshops.enduserappnew.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by sumeet on 29/9/16.
 */

public class PrefSortShopsByCategory {



    public static void saveSort(Context context, String sort_by)
    {
        // get a handle to shared Preference
        SharedPreferences sharedPref;

        sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_name),
                MODE_PRIVATE);

        // write to the shared preference
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("sort_shops_by_category", sort_by);
        editor.apply();
    }


    public static String getSort(Context context)
    {
        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);
        String sort_by = sharedPref.getString("sort_shops_by_category", SlidingLayerSortShops.SORT_BY_DISTANCE);

        return sort_by;
    }



    public static void saveAscending(Context context, String descending)
    {

        // get a handle to shared Preference
        SharedPreferences sharedPref;

        sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_name),
                MODE_PRIVATE);

        // write to the shared preference
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("sort_descending_shops_by_category",descending);
        editor.apply();
    }



    public static String getAscending(Context context)
    {

        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);
        String descending = sharedPref.getString("sort_descending_shops_by_category", SlidingLayerSortShops.SORT_ASCENDING);

        return descending;
    }





    public static void saveFilterByDeliveryType(Context context, boolean isHomeDelivery)
    {
        // get a handle to shared Preference
        SharedPreferences sharedPref;

        sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_name),
                MODE_PRIVATE);

        // write to the shared preference
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("filter_shops_by_delivery_type", isHomeDelivery);
        editor.apply();
    }





    public static boolean getFilterByDeliveryType(Context context)
    {
        SharedPreferences sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_name), MODE_PRIVATE);
        return sharedPref.getBoolean("filter_shops_by_delivery_type", true);
    }


}
