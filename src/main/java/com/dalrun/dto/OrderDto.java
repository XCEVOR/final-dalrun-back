package com.dalrun.dto;

import java.io.Serializable;

public class OrderDto implements Serializable{
	
	private String id;
	private String name;
	private String addres;
	private String phone;
	private String requir; // 주문 요청 사항
	private int totalprice; // 총 구매 금액
	private String date;
	private int amount;
	private String ostate; // 주문 상태
	private String dstate; // 배송상태
	
	public OrderDto() {
		// TODO Auto-generated constructor stub
	}

	public OrderDto(String id, String name, String addres, String phone, String requir, int totalprice, String date,
			int amount, String ostate, String dstate) {
		super();
		this.id = id;
		this.name = name;
		this.addres = addres;
		this.phone = phone;
		this.requir = requir;
		this.totalprice = totalprice;
		this.date = date;
		this.amount = amount;
		this.ostate = ostate;
		this.dstate = dstate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRequir() {
		return requir;
	}

	public void setRequir(String requir) {
		this.requir = requir;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getOstate() {
		return ostate;
	}

	public void setOstate(String ostate) {
		this.ostate = ostate;
	}

	public String getDstate() {
		return dstate;
	}

	public void setDstate(String dstate) {
		this.dstate = dstate;
	}

	@Override
	public String toString() {
		return "OrderDto [id=" + id + ", name=" + name + ", addres=" + addres + ", phone=" + phone + ", requir="
				+ requir + ", totalprice=" + totalprice + ", date=" + date + ", amount=" + amount + ", ostate=" + ostate
				+ ", dstate=" + dstate + "]";
	}
	
	
	

}
