/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.MAX.App.Tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
/**
 *
 * @author andrewclawson
 */
public class AppName extends SimpleTagSupport{
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("MAX S.S.");
    }
}
