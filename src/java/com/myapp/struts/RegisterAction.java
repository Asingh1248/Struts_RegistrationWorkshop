/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author studentadmin
 */
public class RegisterAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //extract the data
        RegisterForm registerForm = (RegisterForm) form;
        String name = registerForm.getName();
        String designation=registerForm.getDesignation();
        String organisation=registerForm.getOrganisation();
        String experienceyear=registerForm.getExperienceyear();
        String gender=registerForm.getGender();
        String email=registerForm.getEmail();
        String contactno=registerForm.getContactno();
        
        //Performing the Validation
        if(name==null||
           designation==null||
           organisation==null||
           experienceyear==null||
           gender==null||
           email==null||
           contactno==null     
          )
        {
            registerForm.setError("Enter Details of the Candidate are not appropriate");
            return mapping.findForward(FAILURE);
        }
        else
        {
         //Logic for the Adding the Data in  the  Database;
         System.out.println("jdbc connection");
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/struts_registrationworkshp?useSSL=false", "root", "root");
           
           String sql="INSERT into candidate_detail(designation, Organisation,No_of_years_experience,Gender, EmailId, ContactNo,Name)values(?,?,?,?,?,?,?)";
           PreparedStatement ps=con.prepareStatement(sql);
           ps.setString(1,designation);
           ps.setString(2,organisation);
           ps.setString(3,experienceyear);
           ps.setString(4,gender);
           ps.setString(5,email);
           ps.setString(6,contactno);
           ps.setString(7,name);
           
           ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        return mapping.findForward(SUCCESS);
        }
    }
}
