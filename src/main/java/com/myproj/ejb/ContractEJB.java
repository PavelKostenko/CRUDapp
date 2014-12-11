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
    
    public List<Contract> findContracts(){
        TypedQuery<Contract> query = em.createNamedQuery("Contract.findAll", Contract.class);        
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
}
