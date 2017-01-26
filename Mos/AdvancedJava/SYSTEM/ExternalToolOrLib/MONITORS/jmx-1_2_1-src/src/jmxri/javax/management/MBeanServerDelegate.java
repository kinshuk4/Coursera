/*
 * @(#)file      MBeanServerDelegate.java
 * @(#)author    Sun Microsystems, Inc.
 * @(#)version   1.53
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

package javax.management; 

//Jdk import
import java.util.Properties;
import java.util.Random;

//Jmx import
import com.sun.jmx.defaults.JmxProperties;
import com.sun.jmx.defaults.ServiceName;

/**
 * Represents  the MBean server from the management point of view.
 * The MBeanServerDelegate MBean emits the MBeanServerNotifications when 
 * an MBean is registered/unregistered in the MBean server. 
 *
 * @since-jdkbundle 1.5
 */
public class MBeanServerDelegate implements MBeanServerDelegateMBean, 
					    NotificationEmitter   { 
    
    /** The MBean server agent identification.*/
    private String mbeanServerId ;
    
    /** The NotificationBroadcasterSupport object that sends the 
	notifications */
    private final NotificationBroadcasterSupport broadcaster;

    private static long oldStamp = 0;
    private final long stamp;
    private long sequenceNumber = 1;

    private static final MBeanNotificationInfo[] notifsInfo;

    static {
        final String[] types  = { 
	    MBeanServerNotification.UNREGISTRATION_NOTIFICATION,
	    MBeanServerNotification.REGISTRATION_NOTIFICATION
	};
	notifsInfo = new MBeanNotificationInfo[1];
	notifsInfo[0] = 
	    new MBeanNotificationInfo(types, "MBeanServerNotification", 
		    "Notifications sent by the MBeanServerDelegate MBean");
    }

    /**
     * Create a MBeanServerDelegate object.
     */
    public MBeanServerDelegate () {
	stamp = getStamp();
        broadcaster = new NotificationBroadcasterSupport() ;
    }
    

    /**
     * Returns the MBean server agent identity.
     *
     * @return the identity.
     */
    public synchronized String getMBeanServerId() {
	if (mbeanServerId == null) {
	    String localHost;
	    try {
		localHost = java.net.InetAddress.getLocalHost().getHostName();
	    } catch (java.net.UnknownHostException e) {
		localHost = "localhost";
	    }	
	    mbeanServerId = new String(localHost + "_" + stamp);
	}
	return mbeanServerId;
    }
    
    /**
     * Returns the full name of the JMX specification implemented
     * by this product.      
     *
     * @return the specification name.
     */    
    public String getSpecificationName() {
	return ServiceName.JMX_SPEC_NAME;
    }

    /**
     * Returns the version of the JMX specification implemented
     * by this product.
     *
     * @return the specification version.
     */    
    public String getSpecificationVersion() {
	return ServiceName.JMX_SPEC_VERSION;
    }

    /**
     * Returns the vendor of the JMX specification implemented
     * by this product.      
     *
     * @return the specification vendor.
     */    
    public String getSpecificationVendor() {
	return ServiceName.JMX_SPEC_VENDOR;
    }

    /**
     * Returns the JMX implementation name (the name of this product).     
     *
     * @return the implementation name.
     */    
    public String getImplementationName() {
	return ServiceName.JMX_IMPL_NAME;
    }

    /**
     * Returns the JMX implementation version (the version of this product).
     *
     * @return the implementation version.
     */    
    public String getImplementationVersion() {
	return ServiceName.JMX_IMPL_VERSION;
    }

    /**
     * Returns the JMX implementation vendor (the vendor of this product).     
     *
     * @return the implementation vendor.
     */    
    public String getImplementationVendor()  {
	return ServiceName.JMX_IMPL_VENDOR;
    }

    // From NotificationEmitter extends NotificationBroacaster
    //
    public MBeanNotificationInfo[] getNotificationInfo() {
	final int len = MBeanServerDelegate.notifsInfo.length;
        final MBeanNotificationInfo[] infos = 
	new MBeanNotificationInfo[len];
	System.arraycopy(MBeanServerDelegate.notifsInfo,0,infos,0,len);
	return infos;
    }  

    // From NotificationEmitter extends NotificationBroacaster
    //
    public synchronized 
	void addNotificationListener(NotificationListener listener, 
				     NotificationFilter filter, 
				     Object handback) 
        throws IllegalArgumentException {
        broadcaster.addNotificationListener(listener,filter,handback) ;
    }
    
    // From NotificationEmitter extends NotificationBroacaster
    //
    public synchronized 
	void removeNotificationListener(NotificationListener listener,
					NotificationFilter filter,
					Object handback)
	throws ListenerNotFoundException {
        broadcaster.removeNotificationListener(listener,filter,handback) ;
    }
    
    // From NotificationEmitter extends NotificationBroacaster
    //
    public synchronized 
	void removeNotificationListener(NotificationListener listener)
        throws ListenerNotFoundException {
        broadcaster.removeNotificationListener(listener) ;
    }

    /**
     * Enables the MBean server to send a notification.
     * If the passed <var>notification</var> has a sequence number lesser
     * or equal to 0, then replace it with the delegate's own sequence 
     * number.
     * @param notification The notification to send.
     * 
     */
    public void sendNotification(Notification notification) {
	if (notification.getSequenceNumber() < 1) {
	    synchronized (this) {
		notification.setSequenceNumber(this.sequenceNumber++);
	    }
	}
        broadcaster.sendNotification(notification);
    }

    /* Return a timestamp that is monotonically increasing even if
       System.currentTimeMillis() isn't (for example, if you call this
       constructor more than once in the same millisecond, or if the
       clock always returns the same value).  This means that the ids
       for a given JVM will always be distinact, though there is no
       such guarantee for two different JVMs.  */
    private static synchronized long getStamp() {
	long s = System.currentTimeMillis();
	if (oldStamp >= s) {
	    s = oldStamp + 1;
	}
	oldStamp = s;
	return s;
    }
}