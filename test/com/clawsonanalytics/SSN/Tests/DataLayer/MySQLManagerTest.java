/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.Tests.DataLayer;

import com.clawsonanalytics.SSN.DataLayer.MySQL.MySQLManager;
import com.clawsonanalytics.SSN.DataLayer.MySQL.MySQLDataSource;
import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrewclawson
 */
public class MySQLManagerTest {
    public static MySQLManager SUT;
    public MySQLManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        SUT = new MySQLManager();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        SUT.SetProductionMode();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void DefaultModeIsProduction(){
        
        Assert.assertEquals("SSN_Application", MySQLDataSource.getDatabaseName());
        
    }
    @Test
    public void TestModeSetsDB(){
        //MySQLManager SUT = new MySQLManager();
        SUT.SetTestMode();
        Assert.assertEquals("SSN_Application_Test", MySQLDataSource.getFocusDB());
    }
    
    @Test
    public void ChangeDBStatementIsCorrect(){
        SUT.statementManager.ChangeDBStatement();
        Assert.assertEquals(SUT.statementManager.getStatementString(), "USE SSN_Application_Test");
    }
    
    @Test
    public void DefaultConnectionIsNotNull(){
        Assert.assertNotNull(SUT.Connector.getConnection());
    }
    
    @Test
    public void DefaultStatementIsNotNull(){
        Assert.assertNotNull(SUT.getStatement());
    }
    
    
}
