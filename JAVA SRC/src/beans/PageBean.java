package beans;

import java.io.Serializable;

public class PageBean implements Serializable{

  	private static final long serialVersionUID = 1L;
private int websiteKey;
  private String pageName;
  private int pageKey;
  //private String templateName;
  private int templateKey;
  private String activeFlag;
  
  /*private String templateFileName;

  public String getTemplateFileName() {
    return templateFileName;
  }
  public void setTemplateFileName(String templateFileName) {
    this.templateFileName = templateFileName;
  }*/

  public String getActiveFlag() {
	return activeFlag;
}

public void setActiveFlag(String activeFlag) {
	this.activeFlag = activeFlag;
}

public String getPageName() {
    return pageName;
  }

  public int getWebsiteKey() {
    return websiteKey;
  }

  public void setWebsiteKey(int websiteKey) {
    this.websiteKey = websiteKey;
  }

  public void setPageName(String pgName) {
    this.pageName = pgName;
  }

  public int getPageKey() {
    return pageKey;
  }

  public void setPageKey(int pageKey) {
    this.pageKey = pageKey;
  }

  public int getTemplateKey() {
    return templateKey;
  }

  public void setTemplateKey(int templateKey) {
    this.templateKey = templateKey;
  }
}