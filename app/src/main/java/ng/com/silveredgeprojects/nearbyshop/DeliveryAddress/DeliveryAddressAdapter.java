package ng.com.silveredgeprojects.nearbyshop.DeliveryAddress;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.nearbyshops.enduserappnew.ModelStats.DeliveryAddress;
import org.nearbyshops.enduserappnew.R;

import java.util.List;

/**
 * Created by sumeet on 6/6/16.
 */
public class DeliveryAddressAdapter extends RecyclerView.Adapter<DeliveryAddressAdapter.ViewHolder>{


    private List<DeliveryAddress> dataset = null;
    private Context context;
    private NotifyDeliveryAddress notifyDeliveryAddress;



    public DeliveryAddressAdapter(List<DeliveryAddress> dataset, Context context, NotifyDeliveryAddress notifyDeliveryAddress) {

        this.dataset = dataset;
        this.context = context;
        this.notifyDeliveryAddress = notifyDeliveryAddress;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_address_item,parent,false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        DeliveryAddress deliveryAddress = dataset.get(position);

        if(deliveryAddress != null)
        {
            holder.name.setText(deliveryAddress.getName());
            holder.deliveryAddress.setText(deliveryAddress.getDeliveryAddress());
            holder.city.setText(deliveryAddress.getCity());
            holder.pincode.setText(" - " + String.valueOf(deliveryAddress.getPincode()));
            holder.landmark.setText(deliveryAddress.getLandmark());
            holder.phoneNumber.setText(String.valueOf(deliveryAddress.getPhoneNumber()));
        }
    }



    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name;
        TextView deliveryAddress;
        TextView city;
        TextView pincode;
        TextView landmark;
        TextView phoneNumber;
        TextView editButton;
        TextView removeButton;
        RelativeLayout listItemDeliveryAddress;


        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            deliveryAddress = (TextView) itemView.findViewById(R.id.deliveryAddress);
            city = (TextView) itemView.findViewById(R.id.city);
            pincode = (TextView) itemView.findViewById(R.id.pincode);
            landmark = (TextView) itemView.findViewById(R.id.landmark);
            phoneNumber = (TextView) itemView.findViewById(R.id.phoneNumber);

            editButton = (TextView) itemView.findViewById(R.id.editButton);
            removeButton = (TextView) itemView.findViewById(R.id.removeButton);

            listItemDeliveryAddress = (RelativeLayout) itemView.findViewById(R.id.list_item_delivery_address);

            editButton.setOnClickListener(this);
            removeButton.setOnClickListener(this);
            listItemDeliveryAddress.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            switch (v.getId())
            {
                case R.id.editButton:

                    editClick();

                    break;

                case R.id.removeButton:

                    removeClick();

                    break;

                case R.id.list_item_delivery_address:

                    listItemClick();

                    break;


                default:
                    break;
            }

        }


        public void listItemClick()
        {
            notifyDeliveryAddress.notifyListItemClick(dataset.get(getLayoutPosition()));
        }



        public void removeClick()
        {

            notifyDeliveryAddress.notifyRemove(dataset.get(getLayoutPosition()), getLayoutPosition());

        }

        public void editClick()
        {

            notifyDeliveryAddress.notifyEdit(dataset.get(getLayoutPosition()));
        }




    }



    public interface NotifyDeliveryAddress{

        void notifyEdit(DeliveryAddress deliveryAddress);
        void notifyRemove(DeliveryAddress deliveryAddress, int position);
        void notifyListItemClick(DeliveryAddress deliveryAddress);
    }

}
