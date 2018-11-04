package com.manager.direct.jacobshack2018;

/**
 * Created by Nilanchala Panigrahy on 10/25/16.
 */
public class FeedItem {

    private String title;
    private int thumbnail;
    private boolean bool;

    public boolean getBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
