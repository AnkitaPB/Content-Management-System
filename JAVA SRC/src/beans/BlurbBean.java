package beans;

import java.io.Serializable;

public class BlurbBean implements Serializable {
   
	private static final long serialVersionUID = 1L;
private int blurbKey;
     private int pageKey;
     private String content;
     private String activeFlag;
  public String getActiveFlag() {
    return activeFlag;
  }
  public void setActiveFlag(String activeFlag) {
    this.activeFlag = activeFlag;
  }
  public int getBlurbKey() {
    return blurbKey;
  }
  public void setBlurbKey(int blurbKey) {
    this.blurbKey = blurbKey;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public int getPageKey() {
    return pageKey;
  }
  public void setPageKey(int pageKey) {
    this.pageKey = pageKey;
  }

}