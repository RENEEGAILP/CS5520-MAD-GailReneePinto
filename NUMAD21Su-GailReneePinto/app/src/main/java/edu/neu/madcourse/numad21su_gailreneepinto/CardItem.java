package edu.neu.madcourse.numad21su_gailreneepinto;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Patterns;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class CardItem{
    private final String mLinkName;
    private final String mLinkURL;

    public CardItem(String mLinkName, String mLinkURL) {
        this.mLinkName = mLinkName;
        this.mLinkURL = mLinkURL;
    }

    public boolean checkValidity() {
        try {
            new URL(mLinkURL).toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
        return Patterns.WEB_URL.matcher(mLinkURL).matches();
    }

    public String getLinkURL() {
        return mLinkURL;
    }

    public String getLinkName() {
        return mLinkName;
    }

    public void onLinkClick(Context context) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mLinkURL));
        context.startActivity(browserIntent);
    }
}
