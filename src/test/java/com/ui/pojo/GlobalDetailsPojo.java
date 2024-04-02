package com.ui.pojo;

public class GlobalDetailsPojo {
	    private String oem;
	    private String jobNumber;
	    private String imeiOrSerialNumber;
	    private String product;
	    private String model;
	    private String warrantyStatus;
	    private String actionStatus;

	    // Constructor
	    public GlobalDetailsPojo(String oem, String jobNumber, String imeiOrSerialNumber, String product, String model, String warrantyStatus, String actionStatus) {
	        this.oem = oem;
	        this.jobNumber = jobNumber;
	        this.imeiOrSerialNumber = imeiOrSerialNumber;
	        this.product = product;
	        this.model = model;
	        this.warrantyStatus = warrantyStatus;
	        this.actionStatus = actionStatus;
	    }

	    // Getters and setters
	    public String getOem() {
	        return oem;
	    }

	    public void setOem(String oem) {
	        this.oem = oem;
	    }

	    public String getJobNumber() {
	        return jobNumber;
	    }

	    public void setJobNumber(String jobNumber) {
	        this.jobNumber = jobNumber;
	    }

	    public String getImeiOrSerialNumber() {
	        return imeiOrSerialNumber;
	    }

	    public void setImeiOrSerialNumber(String imeiOrSerialNumber) {
	        this.imeiOrSerialNumber = imeiOrSerialNumber;
	    }

	    public String getProduct() {
	        return product;
	    }

	    public void setProduct(String product) {
	        this.product = product;
	    }

	    public String getModel() {
	        return model;
	    }

	    public void setModel(String model) {
	        this.model = model;
	    }

	    public String getWarrantyStatus() {
	        return warrantyStatus;
	    }

	    public void setWarrantyStatus(String warrantyStatus) {
	        this.warrantyStatus = warrantyStatus;
	    }

	    public String getActionStatus() {
	        return actionStatus;
	    }

	    public void setActionStatus(String actionStatus) {
	        this.actionStatus = actionStatus;
	    }

	    // toString method for easy printing
	    @Override
	    public String toString() {
	        return "GlobalDetailsPojo{" +
	                "oem='" + oem + '\'' +
	                ", jobNumber='" + jobNumber + '\'' +
	                ", imeiOrSerialNumber='" + imeiOrSerialNumber + '\'' +
	                ", product='" + product + '\'' +
	                ", model='" + model + '\'' +
	                ", warrantyStatus='" + warrantyStatus + '\'' +
	                ", actionStatus='" + actionStatus + '\'' +
	                '}';
	    }
}
