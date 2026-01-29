package com.wishit.auth.dto;

public class VendorSyncRequest {
	 private String vendorUuid;
	    private String vendorName;
	    private String businessEmail;
	    private String businessPhone;
	    private String storeName;
		public String getVendorUuid() {
			return vendorUuid;
		}
		public void setVendorUuid(String vendorUuid) {
			this.vendorUuid = vendorUuid;
		}
		public String getVendorName() {
			return vendorName;
		}
		public void setVendorName(String vendorName) {
			this.vendorName = vendorName;
		}
		public String getBusinessEmail() {
			return businessEmail;
		}
		public void setBusinessEmail(String businessEmail) {
			this.businessEmail = businessEmail;
		}
		public String getBusinessPhone() {
			return businessPhone;
		}
		public void setBusinessPhone(String businessPhone) {
			this.businessPhone = businessPhone;
		}
		public String getStoreName() {
			return storeName;
		}
		public void setStoreName(String storeName) {
			this.storeName = storeName;
		}
}
