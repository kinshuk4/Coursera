/*
 * @(#)file      NamedObject.java
 * @(#)author    Sun Microsystems, Inc.
 * @(#)version   1.27
 * @(#)lastedit      03/07/15
 *
 * Copyright 2000-2003 Sun Microsystems, Inc.  All rights reserved.
 * This software is the proprietary information of Sun Microsystems, Inc.
 * Use is subject to license terms.
 * 
 * Copyright 2000-2003 Sun Microsystems, Inc.  Tous droits r�serv�s.
 * Ce logiciel est propriet� de Sun Microsystems, Inc.
 * Distribu� par des licences qui en restreignent l'utilisation. 
 */

package com.sun.jmx.mbeanserver;

import javax.management.* ; 
 


/**
 * This class is used for storing a pair (name, object) where name is
 * an object name and object is a reference to the object.
 *
 * @since-jdkbundle 1.5
 * @since JMX RI 1.2
 */
public class NamedObject  { 


    /**
     * Object name.
     */
    private ObjectName name;
    
    /**
     * Object reference.
     */
    private Object object= null;
    

    /**
     * Allows a named object to be created.
     *
     *@param objectName The object name of the object.     
     *@param object A reference to the object.
     */
    public NamedObject(ObjectName objectName, Object object)  { 
	if (objectName.isPattern()) {
	    throw new RuntimeOperationsException(new IllegalArgumentException("Invalid name->"+ objectName.toString()));
	}	
	this.name= objectName;
	this.object= object;
    } 

    /**
     * Allows a named object to be created.
     *
     *@param objectName The string representation of the object name of the object.
     *@param object A reference to the object.
     *
     *@exception MalformedObjectNameException The string passed does not have the format of a valid ObjectName
     */
    public NamedObject(String objectName, Object object) throws MalformedObjectNameException{ 
	ObjectName objName= new ObjectName(objectName);
	if (objName.isPattern()) {
	    throw new RuntimeOperationsException(new IllegalArgumentException("Invalid name->"+ objName.toString()));
	}	
	this.name= objName;
	this.object= object;	
    } 
  
    /**
     * Compares the current object name with another object name.
     *
     * @param object  The Named Object that the current object name is to be 
     *        compared with.
     *
     * @return  True if the two named objects are equal, otherwise false.
     */
    public boolean equals(Object object)  {
        if (this == object) return true;
        if (object == null) return false;
        if (!(object instanceof NamedObject)) return false;
        NamedObject no = (NamedObject) object;
        return name.equals(no.getName());
    }


    /**
     * Returns a hash code for this named object.
     *
     */   
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * Get the object name.
     */
    public ObjectName getName()  { 
	return name;
    } 
   
    /**
     * Get the object
     */
    public Object getObject()  { 
	return object;
   } 
    
 }