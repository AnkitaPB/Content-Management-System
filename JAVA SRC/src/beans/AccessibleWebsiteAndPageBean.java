package beans;

public class AccessibleWebsiteAndPageBean {
	
	private int websiteKey;
	private String websiteName;
	private String pageName;
	private String createdDate;
	private String modifiedDate;
	

			public String getPageName() {
				return pageName;
			}
			public void setPageName(String pageName) {
				this.pageName = pageName;
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
			public String getCreatedDate() {
				return createdDate;
			}
			public void setCreatedDate(String createdDate) {
				this.createdDate = createdDate;
			}
			public String getModifiedDate() {
				return modifiedDate;
			}
			public void setModifiedDate(String modifiedDate) {
				this.modifiedDate = modifiedDate;
			}
	

}
