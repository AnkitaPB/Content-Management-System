package beans;

import java.io.Serializable;

public class WebsiteBean implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int websiteKey;
  private String websiteName;
  private String activeFlag;
  private String cssPath;
  private String javascriptPath;
  
  public String getCssPath() {
	return cssPath;
}
public String getJavascriptPath() {
	return javascriptPath;
}
public void setJavascriptPath(String javascriptPath) {
	this.javascriptPath = javascriptPath;
}
public void setCssPath(String cssPath) {
	this.cssPath = cssPath;
}
public String getActiveFlag() {
	return activeFlag;
}
public void setActiveFlag(String activeFlag) {
	this.activeFlag = activeFlag;
}
public int getWebsiteKey() {
    return websiteKey;
  }
  public void setWebsiteKey(int websiteKey) {
    this.websiteKey = websiteKey;
  }
  public String getWebsiteName() {
    return websiteName;
  }
  public void setWebsiteName(String websiteName) {
    this.websiteName = websiteName;
  }

}