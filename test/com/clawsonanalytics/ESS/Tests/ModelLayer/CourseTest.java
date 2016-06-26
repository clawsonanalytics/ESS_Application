/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.Tests.ModelLayer;

import com.clawsonanalytics.ESS.App.ModelLayer.Academics.Course;
import com.clawsonanalytics.ESS.App.ModelLayer.Account;
import com.clawsonanalytics.ESS.App.ModelLayer.Campus;
import com.clawsonanalytics.ESS.App.DataLayer.MySQL.TestEnvironment;
import com.clawsonanalytics.ESS.App.ModelLayer.User;
import com.clawsonanalytics.ESS.Test.ValidAccount;
import com.clawsonanalytics.ESS.Test.ValidCampus;
import com.clawsonanalytics.ESS.Test.ValidUser;
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
public class CourseTest {
    private static Course SUT;
    private static TestEnvironment environment;
    private static Account account;
    
    private String sutDepartment = "testDepartment";
    private String sutTitle = "testTitle";
    private String sutDescription = "A test description";
    
    
    
    // Class properties
    
    public CourseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        environment = new TestEnvironment();
        SetupEmptyTestDatabases();
        account = new ValidAccount();
        account.Insert();
    }
    
    @AfterClass
    public static void tearDownClass() {
        TearDownTestDatabases();
    }
    
    @Before
    public void setUp() {
        SUT = new Course();
        
    }
    
    @After
    public void tearDown() {
        environment.DropRecordsForTestTable(Course.getTablename());
        //environment.DropRecordsForTestTable(User.getTablename());
        //environment.DropRecordsForTestTable(Account.getTablename());
    }
    
    public static void SetupEmptyTestDatabases(){
        environment.Setup();
        try{
            environment.CreateTestTableForModelByTablename(Account.getTablename());
            environment.CreateTestTableForModelByTablename(User.getTablename());
            environment.CreateTestTableForModelByTablename(Course.getTablename());
        }catch(Exception e){}
    }
    
    public static void TearDownTestDatabases(){
        //Drop records
        environment.DropRecordsForTestTable(User.getTablename());
        environment.DropRecordsForTestTable(Course.getTablename());
        environment.DropRecordsForTestTable(Account.getTablename());
        
        //Drop Tables
        environment.DropTestTableForModelByTablename(User.getTablename());
        environment.DropTestTableForModelByTablename(Course.getTablename());
        environment.DropTestTableForModelByTablename(Account.getTablename());
        
        environment.TearDown();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void TablenameIsCorrect(){
        Assert.assertEquals(Course.getTablename(),"COURSES");
    }
    
    @Test
    public void CanSetAccountID(){
        SUT.setAccountID(account.getID());
        Assert.assertEquals(SUT.getAccountID(), account.getID());
    }
    
    @Test
    public void CanRetreiveAccount(){
        SUT.setAccountID(account.getID());
        Assert.assertNotNull(SUT.Account());
        Assert.assertEquals(SUT.Account().getID(),account.getID());
    }
    
    @Test
    public void CanSetDepartment(){
        SUT.setAccountID(account.getID());
        SUT.setDepartment(sutDepartment);
        Assert.assertEquals(sutDepartment,SUT.getDepartment());
    }
    
    @Test
    public void CanSetTitle(){
        SUT.setAccountID(account.getID());
        SUT.setTitle(sutTitle);
        Assert.assertEquals(sutTitle,SUT.getTitle());
    }
    
    @Test
    public void CanSetDescription(){
        SUT.setAccountID(account.getID());
        SUT.setDescription(sutDescription);
        Assert.assertEquals(sutDescription,SUT.getDescription());
    }
    
    @Test
    public void MissingDepartmentHasMessage(){
        SUT.setAccountID(account.getID());
        SUT.setTitle(sutTitle);
        SUT.setDescription(sutDescription);
        Assert.assertTrue(SUT.GetValidationErrors().contains(Course.MISSING_DEPARTMENT));
        
    }
    
    @Test
    public void MissingDepartmentIsInvalid(){
        SUT.setAccountID(account.getID());
        SUT.setTitle(sutTitle);
        SUT.setDescription(sutDescription);
        Assert.assertFalse(SUT.IsValid());
        
    }
    
    @Test
    public void MissingTitleHasMessage(){
        SUT.setAccountID(account.getID());
        SUT.setDepartment(sutDepartment);
        SUT.setDescription(sutDescription);
        Assert.assertTrue(SUT.GetValidationErrors().contains(Course.MISSING_TITLE));
    }
    
    @Test
    public void MissingTitleIsInvalid(){
        SUT.setAccountID(account.getID());
        SUT.setDepartment(sutDepartment);
        SUT.setDescription(sutDescription);
        Assert.assertFalse(SUT.IsValid());
    }
    
    @Test
    public void MissingDescriptionHasMessage(){
        SUT.setAccountID(account.getID());
        SUT.setDepartment(sutDepartment);
        SUT.setTitle(sutTitle);
        Assert.assertTrue(SUT.GetValidationErrors().contains(Course.MISSING_DESCRIPTION));
    }
    
    @Test
    public void MissingDescriptionIsInvalid(){
        SUT.setAccountID(account.getID());
        SUT.setDepartment(sutDepartment);
        SUT.setTitle(sutTitle);
        Assert.assertFalse(SUT.IsValid());
    }
    
    @Test
    public void CanInsert(){
        int firstCount = Course.Count();
        SUT.setAccountID(account.getID());
        SUT.setDepartment(sutDepartment);
        SUT.setTitle(sutTitle);
        SUT.setDescription(sutDescription);
        SUT.Insert();
        Assert.assertEquals(Course.Count(),firstCount+1);
    }
    
    
    
    
}
