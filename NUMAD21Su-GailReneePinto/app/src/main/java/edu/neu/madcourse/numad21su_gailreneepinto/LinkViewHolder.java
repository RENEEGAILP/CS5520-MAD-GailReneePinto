package edu.neu.madcourse.numad21su_gailreneepinto;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class LinkViewHolder extends RecyclerView.ViewHolder{
    public TextView mLinkName;
    public TextView mLinkURL;


    public LinkViewHolder(View itemView) {
        super(itemView);
        mLinkName = itemView.findViewById(R.id.link_name_text_view);
        mLinkURL = itemView.findViewById(R.id.link_url_text_view);
    }
}
