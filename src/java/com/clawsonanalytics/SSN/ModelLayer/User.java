/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.ModelLayer;
import java.util.ArrayList;
import com.clawsonanalytics.SSN.DataLayer.MySQL.Interface.SQLModel__;
import com.clawsonanalytics.SSN.DataLayer.MySQL.Interface.SqlDAO;

/**
 *
 * @author andrewclawson
 */
public class User {
    // Class variables
    //public String TableName = "User";
    
    
    // Constructor
    public User(){
        
    }
    
    public class UserDAO implements SqlDAO{
        
        
        @Override
        public void GetByID(int id){
            
        }
        
        @Override
        public void Insert(){
            
        }
        
        @Override
        public void Update(){
            
        }
        
        @Override
        public void Delete(){
            
        }
    }
}
