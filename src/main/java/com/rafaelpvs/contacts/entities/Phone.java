package com.rafaelpvs.contacts.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rafaelpvs.contacts.entities.enums.Marker;

@Entity
@Table(name = "tb_phone")
public class Phone implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ddi;
	private String ddd;
	private String number;
	private Integer hierarchy;
	
	private Integer marker;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Contact contact;
	
	public Phone() {
	}

	public Phone(Long id, String ddi, String ddd, String number, Integer hierarchy, Integer marker, Contact contact) {
		super();
		this.id = id;
		this.ddi = ddi;
		this.ddd = ddd;
		this.number = number;
		this.hierarchy = hierarchy;
		this.marker = marker;
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public Marker getHierarchy() {
		return Hierarchy.valueOf(hierarchy);
	}

	public void setHierarchy(Hierarchy hierarchy) {
		if(hierarchy != null) {
			this.hierarchy = hierarchy.getCode();
		}
	}
	
	public Marker getMarker() {
		return Marker.valueOf(marker);
	}

	public void setMarker(Marker marker) {
		if(marker != null) {
			this.marker = marker.getCode();
		}
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
