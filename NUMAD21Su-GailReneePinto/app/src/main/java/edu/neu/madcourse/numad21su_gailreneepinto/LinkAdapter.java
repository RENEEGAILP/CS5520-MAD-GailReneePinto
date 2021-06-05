package edu.neu.madcourse.numad21su_gailreneepinto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LinkAdapter extends RecyclerView.Adapter<LinkViewHolder> {

    private ArrayList<CardItem> itemList;

    public LinkAdapter() {
        this.itemList = new ArrayList<CardItem>();
    }
    public LinkAdapter(ArrayList<CardItem> itemList) {

        this.itemList = itemList;
    }
    @Override
    public LinkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.link_cardview, parent, false);
        return new LinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LinkViewHolder holder, int position) {
        CardItem currentItem = itemList.get(position);

        holder.mLinkName.setText(currentItem.getLinkName());
        holder.mLinkURL.setText(currentItem.getLinkURL());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


}
