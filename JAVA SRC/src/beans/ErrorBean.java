package beans;

import java.io.Serializable;

public class ErrorBean implements Serializable {

	private static final long serialVersionUID = 1L;
private String errorKey;
  private String errorMsg;

  public String getErrorKey() {
    return errorKey;
  }

  public void setErrorKey(String errorKey) {
    this.errorKey = errorKey;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }
}