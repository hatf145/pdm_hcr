package iteso.com.rentstudio;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import iteso.com.rentstudio.beans.Lessor;

public class Adapter_Lessor_Card extends RecyclerView.Adapter<Adapter_Lessor_Card.ViewHolder> {
    ArrayList<Lessor> mDataSet;
    private Context context;

    public Adapter_Lessor_Card(Context context, ArrayList<Lessor> myDataSet) {
        mDataSet = myDataSet;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_lessor, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //public RelativeLayout mEventLayout;

        public TextView mLessorName;
        public TextView mLessorPhone;
        public TextView mLessorEmail;

        public ViewHolder(View v) {
            super(v);
            //mEventLayout = (RelativeLayout) v.findViewById(R.id.item_product_layout);

            mLessorName = v.findViewById(R.id.lessor_card_name_text);
            mLessorPhone = v.findViewById(R.id.lessor_card_phone_text);
            mLessorEmail = v.findViewById(R.id.lessor_card_email_text);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mLessorName.setText(mDataSet.get(position).getName());
        holder.mLessorPhone.setText(mDataSet.get(position).getPhone());
        holder.mLessorEmail.setText(mDataSet.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
