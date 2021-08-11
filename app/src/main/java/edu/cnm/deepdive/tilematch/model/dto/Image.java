package edu.cnm.deepdive.tilematch.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

/**
 * Image class.
 */
public class Image {

  @Expose
  @SerializedName("webformatURL")
  private String webFormatUrl;

  /**
   * Getter for webFormatUrl.
   *
   * @return
   */
  public String getWebFormatUrl() {
    return webFormatUrl;
  }

  /**
   * Setter for webFormatUrl.
   *
   * @param webFormatUrl
   */
  public void setWebFormatUrl(String webFormatUrl) {
    this.webFormatUrl = webFormatUrl;
  }


  /**
   * Subclass of Image get search results from GalleryServiceProxy.
   */
  public static class SearchResult {

    @Expose
    Image[] hits;

    /**
     * Getter for search results.
     *
     * @return
     */
    public Image[] getHits() {
      return hits;
    }

    /**
     * Setter for search results.
     *
     * @param hits
     */
    public void setHits(Image[] hits) {
      this.hits = hits;
    }

    /**
     * toString method converts search results to string array.
     *
     * @return
     */
    @Override
    public String toString() {
      return "SearchResult{" +
          "hits=" + Arrays.toString(getHits());
    }
  }
}
