package beans;

import java.io.Serializable;
import com.mysql.jdbc.Clob;

public class BlurbBeanA implements Serializable {
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int blurbAKey;
      private int pageKey;
      private StringBuffer content;
      private String activeFlag;
      private int blurbTypeKey;
      private Clob clobContent;
public Clob getClobContent() {
		return clobContent;
	}
	public void setClobContent(Clob clobContent) {
		this.clobContent = clobContent;
	}
public String getActiveFlag() {
    return activeFlag;
  }
  public void setActiveFlag(String activeFlag) {
    this.activeFlag = activeFlag;
  }
 public StringBuffer getContent() {
    return content;
  }
  public void setContent(StringBuffer content) {
    this.content = content;
  }
  public int getPageKey() {
    return pageKey;
  }
  public void setPageKey(int pageKey) {
    this.pageKey = pageKey;
  }
public int getBlurbAKey() {
	return blurbAKey;
}
public void setBlurbAKey(int blurbAKey) {
	this.blurbAKey = blurbAKey;
}
public int getBlurbTypeKey() {
	return blurbTypeKey;
}
public void setBlurbTypeKey(int blurbTypeKey) {
	this.blurbTypeKey = blurbTypeKey;
}


}