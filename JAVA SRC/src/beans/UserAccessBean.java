package beans;

import java.io.Serializable;

public class UserAccessBean implements Serializable{

private static final long serialVersionUID = 1L;

private int userKey;
  private int websiteKey;

  public int getUserKey() {
    return userKey;
  }

  public void setUserKey(int userKey) {
    this.userKey = userKey;
  }

  public int getWebsiteKey() {
    return websiteKey;
  }

  public void setWebsiteKey(int websiteKey) {
    this.websiteKey = websiteKey;
  }

}