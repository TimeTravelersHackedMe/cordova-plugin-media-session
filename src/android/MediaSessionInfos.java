package com.timetravelers.hackedme;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaSessionInfos {
  public String artist;
  public String track;
  public String album;
  public String date;
  public long duration;
  public String ticker;
  public String genre;
  public String cover;
  public String trackid;
  public String mediauri;
  public boolean rating;
  public boolean isPlaying;
  public boolean hasPrev;
  public boolean hasNext;
  public boolean hasClose;
  public boolean dismissable;
  public String playIcon;
  public String pauseIcon;
  public String prevIcon;
  public String nextIcon;
  public String closeIcon;
  public String notificationIcon;

  public MediaSessionInfos(JSONArray args) throws JSONException {
    final JSONObject params = args.getJSONObject(0);

    this.track = params.getString("track");
    this.artist = params.getString("artist");
    this.album = params.getString("album");
    this.date = params.getString("date");
    this.duration = params.getLong("duration");
    this.trackid = params.getString("trackid");
    this.genre = params.getString("genre");
    this.rating = params.getBoolean("rating");
    this.mediauri = params.getString("mediauri");
    this.ticker = params.getString("ticker");
    this.cover = params.getString("cover");
    this.isPlaying = params.getBoolean("isPlaying");
    this.hasPrev = params.getBoolean("hasPrev");
    this.hasNext = params.getBoolean("hasNext");
    this.hasClose = params.getBoolean("hasClose");
    this.dismissable = params.getBoolean("dismissable");
    this.playIcon = params.getString("playIcon");
    this.pauseIcon = params.getString("pauseIcon");
    this.prevIcon = params.getString("prevIcon");
    this.nextIcon = params.getString("nextIcon");
    this.closeIcon = params.getString("closeIcon");
    this.notificationIcon = params.getString("notificationIcon");
  }

}
