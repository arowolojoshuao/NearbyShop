package ng.com.silveredgeprojects.nearbyshop.ShopsByCategory.Interfaces;


import ng.com.silveredgeprojects.nearbyshop.Model.ItemCategory;

/**
 * Created by sumeet on 22/9/16.
 */

public interface NotifyCategoryChanged {

    void itemCategoryChanged(ItemCategory currentCategory, Boolean isBackPressed);
}
