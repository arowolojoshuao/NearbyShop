package ng.com.silveredgeprojects.nearbyshop.ModelStats;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sumeet on 26/5/16.
 */
public class ItemStats implements Parcelable {

    private int itemID;
    private double min_price;
    private double max_price;
    private int shopCount;
    private double avg_price;

    private double rating_avg;
    private int ratingCount;


    /*
        Getter and Setter methods


     */


    protected ItemStats(Parcel in) {
        itemID = in.readInt();
        min_price = in.readDouble();
        max_price = in.readDouble();
        shopCount = in.readInt();
        avg_price = in.readDouble();
        rating_avg = in.readDouble();
        ratingCount = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(itemID);
        dest.writeDouble(min_price);
        dest.writeDouble(max_price);
        dest.writeInt(shopCount);
        dest.writeDouble(avg_price);
        dest.writeDouble(rating_avg);
        dest.writeInt(ratingCount);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ItemStats> CREATOR = new Creator<ItemStats>() {
        @Override
        public ItemStats createFromParcel(Parcel in) {
            return new ItemStats(in);
        }

        @Override
        public ItemStats[] newArray(int size) {
            return new ItemStats[size];
        }
    };

    public double getRating_avg() {
        return rating_avg;
    }

    public void setRating_avg(double rating_avg) {
        this.rating_avg = rating_avg;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public double getAvg_price() {
        return avg_price;
    }

    public void setAvg_price(double avg_price) {
        this.avg_price = avg_price;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public double getMin_price() {
        return min_price;
    }

    public void setMin_price(double min_price) {
        this.min_price = min_price;
    }

    public double getMax_price() {
        return max_price;
    }

    public void setMax_price(double max_price) {
        this.max_price = max_price;
    }

    public int getShopCount() {
        return shopCount;
    }

    public void setShopCount(int shopCount) {
        this.shopCount = shopCount;
    }



    // Parcelable Implementation

}
