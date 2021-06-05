package edu.neu.madcourse.numad21su_gailreneepinto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

public class LinkAdapter extends RecyclerView.Adapter<LinkViewHolder> {

    @Override
    public LinkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.link_cardview, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(LinkViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
