package beans;

import java.io.Serializable;

public class TemplateBean implements Serializable{

 	private static final long serialVersionUID = 1L;
private String templateName;
  private int templateKey;
  private String templateCode;
  private String templatePath;

  public int getTemplateKey() {
    return templateKey;
  }

  public void setTemplateKey(int templateKey) {
    this.templateKey = templateKey;
  }

  public String getTemplateName() {
    return templateName;
  }

  public void setTemplateName(String templateName) {
    this.templateName = templateName;
  }

public String getTemplateCode() {
	return templateCode;
}

public void setTemplateCode(String templateCode) {
	this.templateCode = templateCode;
}

public String getTemplatePath() {
	return templatePath;
}

public void setTemplatePath(String templatePath) {
	this.templatePath = templatePath;
}

}