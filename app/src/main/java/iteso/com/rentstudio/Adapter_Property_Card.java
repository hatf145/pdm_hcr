package iteso.com.rentstudio;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import iteso.com.rentstudio.beans.Property;

public class Adapter_Property_Card extends RecyclerView.Adapter<Adapter_Property_Card.ViewHolder>{
    ArrayList<Property> mDataSet;
    private Context context;

    public Adapter_Property_Card(Context context, ArrayList<Property> myDataSet){
        mDataSet = myDataSet;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_property, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        //public RelativeLayout mEventLayout;

        public TextView mHouseName;
        public TextView mRent;

        public ViewHolder(View v){
            super(v);
            //mEventLayout = (RelativeLayout) v.findViewById(R.id.item_product_layout);

            mHouseName = v.findViewById(R.id.property_card_house_text);
            mRent = v.findViewById(R.id.property_card_rent_text);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mHouseName.setText(mDataSet.get(position).getAddress());
        holder.mRent.setText(String.valueOf(mDataSet.get(position).getCost()));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
