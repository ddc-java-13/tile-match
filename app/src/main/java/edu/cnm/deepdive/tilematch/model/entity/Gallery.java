package edu.cnm.deepdive.tilematch.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

@Entity
public class Gallery {

  @Expose
  @PrimaryKey(autoGenerate = false)
  @ColumnInfo(name = "image_id")
  private long galleryId;

  @Expose
  @SerializedName("image_url")
  private String pageURL;

  @Expose
  @SerializedName("image_web_format_url")
  private String webFormatURL;

  public long getGalleryId() {
    return galleryId;
  }

  public void setGalleryId(long galleryId) {
    this.galleryId = galleryId;
  }

  public String getPageURL() {
    return pageURL;
  }

  public void setPageURL(String pageURL) {
    this.pageURL = pageURL;
  }

  public String getWebFormatURL() {
    return webFormatURL;
  }

  public void setWebFormatURL(String webFormatURL) {
    this.webFormatURL = webFormatURL;
  }



  public static class SearchResult {

    @Expose
    Gallery[] hits;

    public Gallery[] getHits() {
      return hits;
    }

    public void setHits(Gallery[] hits) {
      this.hits = hits;
    }

    @Override
    public String toString() {
      return "SearchResult{" +
          "hits=" + Arrays.toString(getHits());
    }
  }
}
