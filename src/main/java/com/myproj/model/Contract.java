package com.myproj.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CONTRACT database table.
 * 
 */
@Entity
@NamedQuery(name="Contract.findAll", query="SELECT c FROM Contract c")
public class Contract implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
	private int contractid;

	private String name;

	public Contract() {
	}

	public int getContractid() {
		return this.contractid;
	}

	public void setContractid(int contractid) {
		this.contractid = contractid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}