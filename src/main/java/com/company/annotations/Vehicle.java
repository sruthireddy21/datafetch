package com.company.annotations;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicle {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VEHICLE_ID")
	private int vehicleId;

	@Column(name="VEHICLE_NAME")
	private String vehicleName;

	@ManyToOne
	@JoinColumn(name ="USER_ID")
	private UserDetails user;

	public UserDetails getUser() {
	return user;
	}
	public void setUser(UserDetails user) {
	this.user = user;
	}
	public int getVehicleId() {
	return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
	this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
	return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
	this.vehicleName = vehicleName;
	}
}
