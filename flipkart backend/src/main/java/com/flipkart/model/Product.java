package com.flipkart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "catagory_id")
	private String catagoryId;
	@Column(name = "created_on")
	private String createdOn;
	@Column(name = "updated_on")
	private String updatedOn;
	@Column(name = "specifications")
	private String specification;
	@Column(name = "processor")
	private String processor;
	@Column(name = "screensize")
	private String screenSize;
	@Column(name = "storage")
	private String storage;
	@Column(name = "model_number")
	private String modelNumber;
	@Column(name = "battery")
	private String battery;
	@Column(name = "waranty")
	private String waranty;
	@Column(name = "prize")
	private int prize;
	@Column(name = "image")
	private String image;
	
	
	
	public int getId() {
		return id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCatagoryId() {
		return catagoryId;
	}
	public void setCatagoryId(String catagoryId) {
		this.catagoryId = catagoryId;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	public String getWaranty() {
		return waranty;
	}
	public void setWaranty(String waranty) {
		this.waranty = waranty;
	}
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}
	
	
	
	
	
	

}
