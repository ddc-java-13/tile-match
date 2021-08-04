package edu.cnm.deepdive.tilematch.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

public class Image {

  @Expose
  @SerializedName("webformatURL")
  private String webFormatUrl;

  public String getWebFormatUrl() {
    return webFormatUrl;
  }

  public void setWebFormatUrl(String webFormatUrl) {
    this.webFormatUrl = webFormatUrl;
  }



  public static class SearchResult {

    @Expose
    Image[] hits;

    public Image[] getHits() {
      return hits;
    }

    public void setHits(Image[] hits) {
      this.hits = hits;
    }

    @Override
    public String toString() {
      return "SearchResult{" +
          "hits=" + Arrays.toString(getHits());
    }
  }
}
