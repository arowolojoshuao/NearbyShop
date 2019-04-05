package ng.com.silveredgeprojects.nearbyshop.DaggerComponents;



import javax.inject.Singleton;

import dagger.Component;
import ng.com.silveredgeprojects.nearbyshop.CancelledOrders.CancelledByEndUser.FragmentCancelledByUser;
import ng.com.silveredgeprojects.nearbyshop.CancelledOrders.CancelledByShop.FragmentCancelledByShop;
import ng.com.silveredgeprojects.nearbyshop.CancelledOrders.ReturnedByDeliveryGuy.FragmentReturnedByDG;
import ng.com.silveredgeprojects.nearbyshop.Carts.CartItem.CartItemAdapter;
import ng.com.silveredgeprojects.nearbyshop.Carts.CartItem.CartItemListActivity;
import ng.com.silveredgeprojects.nearbyshop.Carts.CartsList.CartsListFragment;
import ng.com.silveredgeprojects.nearbyshop.Carts.PlaceOrderActivity;
import ng.com.silveredgeprojects.nearbyshop.DaggerModules.AppModule;
import ng.com.silveredgeprojects.nearbyshop.DaggerModules.NetModule;
import ng.com.silveredgeprojects.nearbyshop.DeliveryAddress.DeliveryAddressActivity;
import ng.com.silveredgeprojects.nearbyshop.DeliveryAddress.EditAddress.EditAddressFragment;
import ng.com.silveredgeprojects.nearbyshop.DeliveryAddress.Previous.AddAddressActivity;
import ng.com.silveredgeprojects.nearbyshop.DeliveryAddress.Previous.EditAddressActivity;
import ng.com.silveredgeprojects.nearbyshop.EditProfile.ChangeEmail.FragmentChangeEmail;
import ng.com.silveredgeprojects.nearbyshop.EditProfile.ChangeEmail.FragmentVerifyEmailChange;
import ng.com.silveredgeprojects.nearbyshop.EditProfile.ChangePassword.FragmentChangePassword;
import ng.com.silveredgeprojects.nearbyshop.EditProfile.ChangePhone.FragmentChangePhone;
import ng.com.silveredgeprojects.nearbyshop.EditProfile.ChangePhone.FragmentVerifyPhone;
import ng.com.silveredgeprojects.nearbyshop.EditProfile.FragmentEditProfile;
import ng.com.silveredgeprojects.nearbyshop.FilterItemsBySpecifications.FilterItemsFragment;
import ng.com.silveredgeprojects.nearbyshop.FilterShopDialog.FilterShopsDialog;
import ng.com.silveredgeprojects.nearbyshop.Home;
import ng.com.silveredgeprojects.nearbyshop.ItemByCategory.FragmentItem;
import ng.com.silveredgeprojects.nearbyshop.ItemByCategory.FragmentItemCategories;
import ng.com.silveredgeprojects.nearbyshop.ItemDetail.ItemDetail;
import ng.com.silveredgeprojects.nearbyshop.ItemDetail.RateReviewItemDialog;
import ng.com.silveredgeprojects.nearbyshop.ItemImages.ItemImageListFragment;
import ng.com.silveredgeprojects.nearbyshop.Items.ItemsList.FragmentItemsList;
import ng.com.silveredgeprojects.nearbyshop.ItemsByCategoryHorizontal.ItemCategories.ItemCategoriesHorizontal;
import ng.com.silveredgeprojects.nearbyshop.ItemsByCategoryHorizontal.Items.FragmentItemScreenHorizontal;
import ng.com.silveredgeprojects.nearbyshop.ItemsByCategorySwipe.ItemCategories.ItemCategoriesFragmentItem;
import ng.com.silveredgeprojects.nearbyshop.ItemsByCategorySwipe.Items.FragmentItem_ItemByCategory;
import ng.com.silveredgeprojects.nearbyshop.ItemsByCategoryTypeSimple.AdapterSimple;
import ng.com.silveredgeprojects.nearbyshop.ItemsByCategoryTypeSimple.ItemCategoriesFragmentSimple;
import ng.com.silveredgeprojects.nearbyshop.ItemsInShop.ShopItems.FragmentItemsInShop;
import ng.com.silveredgeprojects.nearbyshop.ItemsInShopByCat.AdapterItemsInShop;
import ng.com.silveredgeprojects.nearbyshop.ItemsInShopByCat.ItemsInShopByCatFragment;
import ng.com.silveredgeprojects.nearbyshop.Login.LoginFragment;
import ng.com.silveredgeprojects.nearbyshop.Login.ServiceIndicatorFragment;
import ng.com.silveredgeprojects.nearbyshop.OneSignal.UpdateOneSignalID;
import ng.com.silveredgeprojects.nearbyshop.OrderDetail.FragmentOrderDetail;
import ng.com.silveredgeprojects.nearbyshop.OrderHistoryHD.OrderHistoryHD.Complete.CompleteOrdersFragment;
import ng.com.silveredgeprojects.nearbyshop.OrderHistoryHD.OrderHistoryHD.Pending.PendingOrdersFragment;
import ng.com.silveredgeprojects.nearbyshop.OrderHistoryNew.OrdersFragmentNew;
import ng.com.silveredgeprojects.nearbyshop.ShopDetail.RateReviewDialog;
import ng.com.silveredgeprojects.nearbyshop.ShopDetail.ShopDetail;
import ng.com.silveredgeprojects.nearbyshop.ShopImages.ShopImageListFragment;
import ng.com.silveredgeprojects.nearbyshop.ShopItemByItem.FilledCarts.AdapterFilledCarts;
import ng.com.silveredgeprojects.nearbyshop.ShopItemByItem.FilledCarts.FilledCartsFragment;
import ng.com.silveredgeprojects.nearbyshop.ShopItemByItem.NewCarts.AdapterNewCarts;
import ng.com.silveredgeprojects.nearbyshop.ShopItemByItem.NewCarts.NewCartsFragment;
import ng.com.silveredgeprojects.nearbyshop.ShopItemByItemNew.ShopItemFragment.AdapterShopItem;
import ng.com.silveredgeprojects.nearbyshop.ShopItemByItemNew.ShopItemFragment.ShopItemFragment;
import ng.com.silveredgeprojects.nearbyshop.ShopItemByShop.ItemCategories.ItemCategoriesFragmentShopHome;
import ng.com.silveredgeprojects.nearbyshop.ShopItemByShop.ShopItems.AdapterShopItems;
import ng.com.silveredgeprojects.nearbyshop.ShopItemByShop.ShopItems.FragmentShopItemsByShop;
import ng.com.silveredgeprojects.nearbyshop.ShopReview.ShopReviewAdapter;
import ng.com.silveredgeprojects.nearbyshop.ShopReview.ShopReviewStats;
import ng.com.silveredgeprojects.nearbyshop.ShopReview.ShopReviews;
import ng.com.silveredgeprojects.nearbyshop.Shops.ListFragment.FragmentShopNew;
import ng.com.silveredgeprojects.nearbyshop.ShopsByCatSimple.ShopsByCatFragment;
import ng.com.silveredgeprojects.nearbyshop.ShopsByCategory.ItemCategories.ItemCategoriesFragment;
import ng.com.silveredgeprojects.nearbyshop.ShopsByCategory.Shops.FragmentShop;
import ng.com.silveredgeprojects.nearbyshop.SignUp.ForgotPassword.FragmentCheckResetCode;
import ng.com.silveredgeprojects.nearbyshop.SignUp.ForgotPassword.FragmentEnterCredentials;
import ng.com.silveredgeprojects.nearbyshop.SignUp.ForgotPassword.FragmentResetPassword;
import ng.com.silveredgeprojects.nearbyshop.SignUp.FragmentEmailOrPhone;
import ng.com.silveredgeprojects.nearbyshop.SignUp.FragmentEnterPassword;
import ng.com.silveredgeprojects.nearbyshop.SignUp.FragmentVerifyEmailSignUp;
import ng.com.silveredgeprojects.nearbyshop.TabProfile.ProfileFragment;

/**
 * Created by sumeet on 14/5/16.
 */

@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface NetComponent {


    void Inject(FilledCartsFragment shopsForItem);

    void Inject(NewCartsFragment newCartsFragment);

    void Inject(AdapterNewCarts adapterNewCarts);

    void Inject(AdapterFilledCarts adapterFilledCarts);

    void Inject(CartsListFragment cartsListActivity);

    void Inject(CartItemListActivity cartItemListActivity);

    void Inject(DeliveryAddressActivity deliveryAddressActivity);

    void Inject(AddAddressActivity addAddressActivity);

    void Inject(EditAddressActivity editAddressActivity);

    void Inject(PlaceOrderActivity placeOrderActivity);

    void Inject(FragmentItemCategories fragmentItemCategories);

    void Inject(FragmentItem itemFragment);

//    void Inject(FragmentShop shopFragment);


    void Inject(ItemCategoriesFragment itemCategoriesFragment);

    void Inject(FragmentShop fragmentShop);

    void Inject(ItemCategoriesFragmentItem itemCategoriesFragmentItem);

    void Inject(FragmentItem_ItemByCategory fragmentItem_itemByCategory);


    void Inject(ShopDetail shopDetail);

    void Inject(RateReviewDialog rateReviewDialog);

    void Inject(ShopReviews shopReviews);

    void Inject(ItemCategoriesFragmentShopHome itemCategoriesFragmentShopHome);

    void Inject(FragmentShopItemsByShop fragmentShopItemsByShop);

    void Inject(ShopReviewAdapter shopReviewAdapter);

    void Inject(ItemDetail itemDetail);

    void Inject(RateReviewItemDialog rateReviewItemDialog);

    void Inject(ShopReviewStats shopReviewStats);

    void Inject(AdapterShopItems adapterShopItems);

    void Inject(FragmentShopNew fragmentShopTwo);

    void Inject(FragmentItemsList fragmentItemsList);

    void Inject(FragmentItemsInShop fragmentItemsInShop);

    void Inject(AdapterItemsInShop adapterItemsInShop);

    void Inject(ItemCategoriesHorizontal itemCategoriesHorizontal);

    void Inject(FragmentItemScreenHorizontal fragmentItemScreenHorizontal);

    void Inject(FilterShopsDialog filterShopsDialog);

    void Inject(ItemCategoriesFragmentSimple itemCategoriesFragmentSimple);

    void Inject(AdapterSimple adapterSimple);

    void Inject(ItemsInShopByCatFragment itemsInShopByCatFragment);

//    void Inject(AdapterItemsInShop adapterItemsInShop);



    void Inject(ShopsByCatFragment shopsByCatFragment);

    void Inject(CompleteOrdersFragment completeOrdersFragment);

    void Inject(PendingOrdersFragment pendingOrdersFragment);

    void Inject(FragmentOrderDetail fragmentOrderDetail);

    void Inject(FragmentCancelledByUser fragmentCancelledByUser);

    void Inject(FragmentCancelledByShop fragmentCancelledByShop);

    void Inject(FragmentReturnedByDG fragmentReturnedByDG);

    void Inject(EditAddressFragment editAddressFragment);

    void Inject(FilterItemsFragment filterItemsFragment);

    void Inject(LoginFragment loginFragment);

    void Inject(FragmentCheckResetCode fragmentCheckResetCode);

    void Inject(FragmentEmailOrPhone fragmentEmailOrPhone);

    void Inject(FragmentEnterCredentials fragmentEnterCredentials);

    void Inject(FragmentEnterPassword fragmentEnterPassword);

    void Inject(FragmentResetPassword fragmentResetPassword);

    void Inject(FragmentVerifyEmailSignUp fragmentVerifyEmailSignUp);


    void Inject(Home homeNew);

    void Inject(ServiceIndicatorFragment serviceIndicatorFragment);

    void Inject(OrdersFragmentNew pendingOrdersFragmentNew);

    void Inject(CartItemAdapter cartItemAdapter);

    void Inject(FragmentVerifyEmailChange fragmentVerifyEmailChange);

    void Inject(FragmentVerifyPhone fragmentVerifyPhone);

    void Inject(FragmentChangePassword fragmentChangePassword);

    void Inject(FragmentChangePhone fragmentChangePhone);

    void Inject(FragmentEditProfile fragmentEditProfile);

    void Inject(ProfileFragment profileFragment);

    void Inject(FragmentChangeEmail fragmentChangeEmail);

    void Inject(UpdateOneSignalID updateOneSignalID);

    void Inject(ItemImageListFragment imageListFragment);

    void Inject(ShopImageListFragment shopImageListFragment);

    void Inject(ShopItemFragment shopItemFragment);

    void Inject(AdapterShopItem adapterShopItem);
}
