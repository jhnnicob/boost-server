package com.wkt.boost.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "order")
public class Order extends UUIDModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	
	
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "serving_type")
	private ServingType servingType;
	
	@Column(name = "order_start_date")
	private Date orderStartDate;
	
	@Column(name = "discount_id")
	private Discount discount;
	
	@Column(name = "discount_rate")
	private double discountRate;
	
	@Column(name = "total_discount_amount")
	private double totalDiscountAmount;
	
	@Column(name = "total_payable")
	private double totalPayable;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "order_status")
	private OrderStatus status;
	
	@Column(name = "serve_date")
	private Date serveDate;
	
	@ManyToOne
	@JoinColumn(name = "payment_option_id")
	private PaymentOption paymentOption;
	
	@Column(name = "payment_date")
	private Date paymentDate;
	
	@Column(name = "device_id")
	private String deviceId;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "order_id")
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	@JsonManagedReference
	private List<OrderItem> orderItems;
	
	public enum ServingType {
		DINE_IN, TAKE_OUT, DELIVERY, PICKUP
	}
	
	public enum OrderStatus {
		DRAFT, WAITING, COMPLETE, CANCEL
	}
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public ServingType getServingType() {
		return servingType;
	}

	public void setServingType(ServingType servingType) {
		this.servingType = servingType;
	}

	public Date getOrderStartDate() {
		return orderStartDate;
	}

	public void setOrderStartDate(Date orderStartDate) {
		this.orderStartDate = orderStartDate;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public double getTotalDiscountAmount() {
		return totalDiscountAmount;
	}

	public void setTotalDiscountAmount(double totalDiscountAmount) {
		this.totalDiscountAmount = totalDiscountAmount;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Date getServeDate() {
		return serveDate;
	}

	public void setServeDate(Date serveDate) {
		this.serveDate = serveDate;
	}

	public PaymentOption getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(PaymentOption paymentOption) {
		this.paymentOption = paymentOption;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
}
