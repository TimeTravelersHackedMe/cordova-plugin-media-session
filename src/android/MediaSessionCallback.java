package com.homerours.musiccontrols;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.RatingCompat;
import android.view.KeyEvent;

import org.apache.cordova.CallbackContext;

public class MediaSessionCallback extends MediaSessionCompat.Callback {

  private CallbackContext cb;

  public void setCallback(CallbackContext cb){
    this.cb = cb;
  }

  @Override
  public void onPlay() {
    super.onPlay();
    if(this.cb != null) {
      this.cb.success("{\"message\": \"music-controls-media-button-play\"}");
      this.cb = null;
    }
  }

  @Override
  public void onPrepare() {
    super.onPrepare();
    if(this.cb != null) {
      this.cb.success("{\"message\": \"on-prepare\"}");
      this.cb = null;
    }
  }

  @Override
  public void onPause() {
    super.onPause();
    if(this.cb != null) {
      this.cb.success("{\"message\": \"music-controls-media-button-pause\"}");
      this.cb = null;
    }
  }

  @Override
  public void onStop() {
    super.onStop();
    if(this.cb != null) {
      this.cb.success("{\"message\": \"music-controls-media-button-pause\"}");
      this.cb = null;
    }
  }

  @Override
  public void onSkipToNext() {
    super.onSkipToNext();
    if(this.cb != null) {
      this.cb.success("{\"message\": \"music-controls-media-button-next\"}");
      this.cb = null;
    }
  }

  @Override
  public void onSkipToPrevious() {
    super.onSkipToPrevious();
    if(this.cb != null) {
      this.cb.success("{\"message\": \"music-controls-media-button-previous\"}");
      this.cb = null;
    }
  }

  @Override
  public void onSeekTo(long position) {
    super.onSeekTo(position);
    if(this.cb != null) {
      this.cb.success("{\"message\": \"seek-to\", \"position\": \"" + position + "\"}");
      this.cb = null;
    }
  }

  @Override
  public void onPlayFromSearch(String query, Bundle extras) {
    super.onPlayFromSearch(query, extras);
    if(this.cb != null) {
      this.cb.success("{\"message\": \"play-from-search\", \"query\": \"" + query + "\"}");
      this.cb = null;
    }
  }

  @Override
  public void onPrepareFromSearch(String query, Bundle extras) {
    super.onPrepareFromSearch(query, extras);
    if(this.cb != null) {
      this.cb.success("{\"message\": \"prepare-from-search\", \"query\": \"" + query + "\"}");
      this.cb = null;
    }
  }

  @Override
  public void onSetRating(RatingCompat rating) {
    super.onSetRating(rating);
    if(this.cb != null) {
      this.cb.success("{\"message\": \"set-rating\", \"rating\": \"" + rating + "\"}");
      this.cb = null;
    }
  }

  @Override
  public void onPlayFromMediaId(String mediaId, Bundle extras) {
    super.onPlayFromMediaId(mediaId, extras);
  }

  @Override
  public boolean onMediaButtonEvent(Intent mediaButtonIntent) {
    final KeyEvent event = (KeyEvent) mediaButtonIntent.getExtras().get(Intent.EXTRA_KEY_EVENT);

    if (event == null) {
      return super.onMediaButtonEvent(mediaButtonIntent);
    }

    if (event.getAction() == KeyEvent.ACTION_DOWN) {
      final int keyCode = event.getKeyCode();
      switch (keyCode) {
        case KeyEvent.KEYCODE_MEDIA_PAUSE:

          if(this.cb != null) {
            this.cb.success("{\"message\": \"music-controls-media-button-pause\"}");
            this.cb = null;
          }
          break;
        case KeyEvent.KEYCODE_MEDIA_PLAY:

          if(this.cb != null) {
            this.cb.success("{\"message\": \"music-controls-media-button-play\"}");
            this.cb = null;
          }
          break;
        case KeyEvent.KEYCODE_MEDIA_PREVIOUS:

          if(this.cb != null) {
            this.cb.success("{\"message\": \"music-controls-media-button-previous\"}");
            this.cb = null;
          }
          break;
        case KeyEvent.KEYCODE_MEDIA_NEXT:

          if(this.cb != null) {
            this.cb.success("{\"message\": \"music-controls-media-button-next\"}");
            this.cb = null;
          }
          break;
        case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:

          if(this.cb != null) {
            this.cb.success("{\"message\": \"music-controls-media-button-play-pause\"}");
            this.cb = null;
          }
          break;
        case KeyEvent.KEYCODE_MEDIA_STOP:

          if(this.cb != null) {
            this.cb.success("{\"message\": \"music-controls-media-button-stop\"}");
            this.cb = null;
          }
          break;
        case KeyEvent.KEYCODE_MEDIA_FAST_FORWARD:

          if(this.cb != null) {
            this.cb.success("{\"message\": \"music-controls-media-button-forward\"}");
            this.cb = null;
          }
          break;
        case KeyEvent.KEYCODE_MEDIA_REWIND:

          if(this.cb != null) {
            this.cb.success("{\"message\": \"music-controls-media-button-rewind\"}");
            this.cb = null;
          }
          break;
        default:
          if(this.cb != null) {
            this.cb.success("{\"message\": \"music-controls-media-button-unknown-" + keyCode + "\"}");
            this.cb = null;
          }
          return super.onMediaButtonEvent(mediaButtonIntent);
      }
    }

    return true;
  }
}
