package edu.neu.madcourse.numad21su_gailreneepinto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LinkAdapter extends RecyclerView.Adapter<LinkViewHolder> {

    private ArrayList<CardItem> mItemList;
    private ItemClickListener mListener;

    public LinkAdapter() {
        this.mItemList = new ArrayList<CardItem>();
    }
    public LinkAdapter(ArrayList<CardItem> itemList) {
        this.mItemList = itemList;
    }

    public void setOnLinkClickListener(ItemClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public LinkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.link_cardview, parent, false);
        return new LinkViewHolder(view, mListener );
    }

    @Override
    public void onBindViewHolder(LinkViewHolder holder, int position) {
        CardItem currentItem = mItemList.get(position);

        holder.mLinkName.setText(currentItem.getLinkName());
        holder.mLinkURL.setText(currentItem.getLinkURL());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }


}
