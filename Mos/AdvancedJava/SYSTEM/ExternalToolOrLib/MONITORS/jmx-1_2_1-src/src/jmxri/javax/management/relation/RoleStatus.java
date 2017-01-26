/*
 * @(#)file      RoleStatus.java
 * @(#)author    Sun Microsystems, Inc.
 * @(#)version   1.10
 * @(#)lastedit      03/07/07
 *
 * Copyright 2000 Sun Microsystems, Inc. All rights reserved.
 * This software is the proprietary information of Sun Microsystems, Inc.
 * Use is subject to license terms.
 * 
 * Copyright 2000 Sun Microsystems, Inc. Tous droits r�serv�s.
 * Ce logiciel est propriet� de Sun Microsystems, Inc.
 * Distribu� par des licences qui en restreignent l'utilisation. 
 */

package javax.management.relation;

/**
 * This class describes the various problems which can be encountered when
 * accessing a role.
 *
 * @since-jdkbundle 1.5
 */
public class RoleStatus {

    //
    // Possible problems
    //

    /**
     * Problem type when trying to access an unknown role.
     */
    public static final int NO_ROLE_WITH_NAME = 1;
    /**
     * Problem type when trying to read a non-readable attribute.
     */
    public static final int ROLE_NOT_READABLE = 2;
    /**
     * Problem type when trying to update a non-writable attribute.
     */
    public static final int ROLE_NOT_WRITABLE = 3;
    /**
     * Problem type when trying to set a role value with less ObjectNames than
     * the minimum expected cardinality.
     */
    public static final int LESS_THAN_MIN_ROLE_DEGREE = 4;
    /**
     * Problem type when trying to set a role value with more ObjectNames than
     * the maximum expected cardinality.
     */
    public static final int MORE_THAN_MAX_ROLE_DEGREE = 5;
    /**
     * Problem type when trying to set a role value including the ObjectName of
     * a MBean not of the class expected for that role.
     */
    public static final int REF_MBEAN_OF_INCORRECT_CLASS = 6;
    /**
     * Problem type when trying to set a role value including the ObjectName of
     * a MBean not registered in the MBean Server.
     */
    public static final int REF_MBEAN_NOT_REGISTERED = 7;

    /**
     * Returns true if given value corresponds to a known role status, false
     * otherwise.
     *
     * @param theRoleStatus a status code.
     *
     * @return true if this value is a known role status.
     */
    public static boolean isRoleStatus(int theRoleStatus) {
	if (theRoleStatus != NO_ROLE_WITH_NAME &&
	    theRoleStatus != ROLE_NOT_READABLE &&
	    theRoleStatus != ROLE_NOT_WRITABLE &&
	    theRoleStatus != LESS_THAN_MIN_ROLE_DEGREE &&
	    theRoleStatus != MORE_THAN_MAX_ROLE_DEGREE &&
	    theRoleStatus != REF_MBEAN_OF_INCORRECT_CLASS &&
	    theRoleStatus != REF_MBEAN_NOT_REGISTERED) {
	    return false;
	}
	return true;
    }
}