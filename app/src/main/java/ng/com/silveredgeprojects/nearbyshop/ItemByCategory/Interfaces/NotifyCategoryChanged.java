package ng.com.silveredgeprojects.nearbyshop.ItemByCategory.Interfaces;


import ng.com.silveredgeprojects.nearbyshop.Model.ItemCategory;

/**
 * Created by sumeet on 4/7/16.
 */

public interface NotifyCategoryChanged {

    void categoryChanged(ItemCategory currentCategory, boolean isBackPressed);

    void notifySwipeToRight();
}
