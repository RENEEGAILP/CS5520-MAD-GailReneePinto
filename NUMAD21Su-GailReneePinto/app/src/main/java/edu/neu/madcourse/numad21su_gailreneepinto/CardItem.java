package edu.neu.madcourse.numad21su_gailreneepinto;

import android.content.Intent;
import android.net.Uri;

public class CardItem implements ItemClickListener{
    private final String mLinkName;
    private final String mLinkURL;

    public CardItem(String mLinkName, String mLinkURL) {
        this.mLinkName = mLinkName;
        this.mLinkURL = mLinkURL;
    }

    public String getLinkURL() {
        return mLinkURL;
    }

    public String getLinkName() {
        return mLinkName;
    }

    @Override
    public void onItemClick(int position) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mLinkURL));
        //context.startActivity(browserIntent);
    }
}
