package com.myproj.ejb;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.myproj.model.Contract;

/**
 * Session Bean implementation class ContractEJB
 */
@Stateless
public class ContractEJB {
	
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ContractEJB() {
        // TODO Auto-generated constructor stub
    	
    }
    
    public List<Contract> findAllContracts(){
        TypedQuery<Contract> query = em.createNamedQuery("Contract.findAll", Contract.class);        
        return query.getResultList();
    }
    
    public List<Contract> findSearchedContracts(String searchPattern){
    	//System.out.println("Search pattern: " + searchPattern);
    	//Query query = em.createQuery("SELECT e FROM Contract AS e WHERE e.name = \"my\"");
        Query query = em.createQuery("SELECT e FROM Contract AS e WHERE e.name = :name").setParameter("name",searchPattern);
    	return query.getResultList();
    }
    
    public void addNew (Contract con) {
    	em.persist(con);
        //return con;
    }
    
    public void removeContract(Contract con){
    	//Contract managedEntity = em.find(Contract.class, con.getContractid());
    	em.remove(em.find(Contract.class, con.getContractid()));
    }
    
    public void editContract(Contract con){
    	System.out.println("Data for the new contract: " + con.getContractid() + " " + con.getName());
    	Contract managedEntity = em.find(Contract.class, con.getContractid());
    	managedEntity.setName(con.getName());
    }
}
