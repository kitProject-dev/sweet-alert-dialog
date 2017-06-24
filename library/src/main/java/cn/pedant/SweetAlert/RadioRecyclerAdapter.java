package cn.pedant.SweetAlert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class RadioRecyclerAdapter extends RecyclerView.Adapter<RadioRecyclerAdapter.ViewHolder> {

    public static int mSelectedItem;
    private LayoutInflater mInflater;
    private ArrayList<String> mData;
    private int mTextSize;

    public RadioRecyclerAdapter(Context context, ArrayList<String> data, int textSize, int position) {
        mInflater = LayoutInflater.from(context);
        mData = data;
        mTextSize = textSize;
        mSelectedItem = position;
    }

    @Override
    public RadioRecyclerAdapter.ViewHolder  onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.radio_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView.setText(mData.get(position));
        holder.radio.setChecked(position == mSelectedItem);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RadioButton radio;
        TextView textView;
        public ViewHolder(View view) {
            super(view);
            radio  = (RadioButton) view.findViewById(R.id.item_radio);
            textView = (TextView) view.findViewById(R.id.item_text);
            textView.setTextSize(mTextSize);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mSelectedItem = getAdapterPosition();
                    notifyItemRangeChanged(0, mData.size());
                }
            });
            radio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mSelectedItem = getAdapterPosition();
                    notifyItemRangeChanged(0, mData.size());
                }
            });
        }
    }

}
