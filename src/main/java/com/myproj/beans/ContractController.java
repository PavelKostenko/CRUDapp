package com.myproj.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.myproj.ejb.ContractEJB;
import com.myproj.model.Contract;

@ManagedBean

//Container creates a new instance of this bean for each user's request
@RequestScoped


public class ContractController {
	
	@EJB private ContractEJB contractEJB;
	private Contract contract = new Contract();
	private List <Contract> contractList = new ArrayList<Contract>();
	private List <Contract> contractListSearched = new ArrayList<Contract>();
	private String conNameToSearch;
	
	public List <Contract> getContractList(){
		contractList = contractEJB.findAllContracts();
		return contractList;
	}
	
	public List <Contract> getContractListSearched(){
		contractListSearched = contractEJB.findSearchedContracts(conNameToSearch);
		return contractListSearched;
	}
	
	public String findContractListSearched(){
		return "SingleContract.xhtml";
	}
	
	public String addContract(){
		contractEJB.addNew(contract);
		return "ListContracts.xhtml";
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	public String getConNameToSearch() {
		return conNameToSearch;
	}

	public void setConNameToSearch(String conNameToSearch) {
		this.conNameToSearch = conNameToSearch;
	}

	public String removeContract(Contract con){
		contractEJB.removeContract(con);
		return "ListContracts.xhtml";
	}
	
	public String editContract(Contract con){
		setContract(con);
		return "EditContract.xhtml";
	}
	
	public String persistContract(){
		setConNameToSearch(contract.getName());
		contractEJB.editContract(contract);
		return "SingleContract.xhtml";
	}
		
}
