package beans;

import java.io.Serializable;

public class BlurbTypeBean implements Serializable{
  
	private static final long serialVersionUID = 1L;
private int blurbKey;
  private String blurbType;
public int getBlurbKey() {
  return blurbKey;
}
public void setBlurbKey(int blurbKey) {
  this.blurbKey = blurbKey;
}
public String getBlurbType() {
  return blurbType;
}
public void setBlurbType(String blurbType) {
  this.blurbType = blurbType;
}

  }