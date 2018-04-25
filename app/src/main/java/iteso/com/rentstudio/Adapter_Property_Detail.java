package iteso.com.rentstudio;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import iteso.com.rentstudio.beans.Property;

//nuevo
public class Adapter_Property_Detail extends RecyclerView.Adapter<Adapter_Property_Detail.ViewHolder>{
    private ArrayList<Property> mDataSet;
    private Context context;


    public Adapter_Property_Detail(ArrayList<Property> mDataSet, Context context) {
        this.mDataSet = mDataSet;
        this.context = context;
    }


    @Override
    public Adapter_Property_Detail.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_property, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView address;
        public TextView cost;
        public TextView availability;
        public TextView name;
        public TextView payday;
        public TextView state;
        public TextView town;

      public LinearLayout mEventLayout;

        public ViewHolder(View v){
            super(v);
            mEventLayout = (LinearLayout) v.findViewById(R.id.property_card_layout);//////////////////////////
            address = v.findViewById(R.id.property_address);
            cost = v.findViewById(R.id.property_money);
            availability = v.findViewById(R.id.property_availability);
            name = v.findViewById(R.id.property_house);
            payday = v.findViewById(R.id.property_payday);
            state = v.findViewById(R.id.property_state);
            town = v.findViewById(R.id.property_town);
        }
    }

    @Override
    public void onBindViewHolder(final Adapter_Property_Detail.ViewHolder holder,final int position) {
       holder.address.setText(mDataSet.get(position).getAddress());
        holder.cost.setText(String.valueOf(mDataSet.get(position).getCost()));
        holder.availability.setText(mDataSet.get(position).getLessor());
        holder.name.setText(mDataSet.get(position).getName());
        holder.address.setText(mDataSet.get(position).getAddress());
        holder.payday.setText(mDataSet.get(position).getPayday());
        holder.state.setText(mDataSet.get(position).getState());
        holder.town.setText(mDataSet.get(position).getTown());

        holder.mEventLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /* Property iit=new Property();
                iit.setAddress(mDataSet.get(position).getAddress());
                iit.setCost(mDataSet.get(position).getCost());
                iit.setLessor(mDataSet.get(position).getLessor());
                iit.setName(mDataSet.get(position).getName());
                iit.setPayday(mDataSet.get(position).getPayday());
                iit.setState(mDataSet.get(position).getState());
                iit.setTown(mDataSet.get(position).getTown());
                Intent intent = new Intent(context, ActivityPropertyScreen.class);
                intent.putExtra("ITEM", iit);
                ((Activity_Main_Screen) context).startActivityForResult(intent, 1);   */
                Intent intent = new Intent(context, ActivityPropertyScreen.class);
                intent.putExtra("PRODUCT", mDataSet.get(holder.getAdapterPosition()));
                intent.putExtra("ITEM",0);
                ((Activity_Main_Screen) context).startActivityForResult(intent, 9999);   }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
