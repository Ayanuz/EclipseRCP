package com.sogeti.rental.ui;


import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

/**
 * The activator class controls the plug-in life cycle
 */
public class RentalUiActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.sogeti.rental.ui"; //$NON-NLS-1$

	// The shared instance
	private static RentalUiActivator plugin;
	
	/**
	 * The constructor
	 */
	public RentalUiActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		showExtensionsView();
	}

	private void showExtensionsView() {
		// TODO Auto-generated method stub
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		for(IConfigurationElement conf_elmt : reg.getConfigurationElementsFor("org.eclipse.ui.views"))
		{
			String node_inf = conf_elmt.getName();
			if(node_inf != null && node_inf.equals("view"))
			{
				String line_info = "";
				line_info = "Plugin : " + conf_elmt.getNamespaceIdentifier() + "\t";
				line_info += "Vue : " + conf_elmt.getAttribute("name")+ "\t";
				line_info += "description :" + conf_elmt.getChildren("description");
				System.out.println(line_info);
			}
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static RentalUiActivator getDefault() {
		return plugin;
	}
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		// TODO Auto-generated method stub
		Bundle b = FrameworkUtil.getBundle(getClass());
		
		reg.put(RentalUICstes.CUSTOMER_NODE, ImageDescriptor.createFromURL(b.getEntry(RentalUICstes.CUSTOMER_IMG)));
		reg.put(RentalUICstes.LOCATIONS_NODE, ImageDescriptor.createFromURL(b.getEntry(RentalUICstes.LOCATIONS_IMG)));
		reg.put(RentalUICstes.RENTAL_OBJ_NODE, ImageDescriptor.createFromURL(b.getEntry(RentalUICstes.RENTAL_OBJ_IMG)));
		reg.put(RentalUICstes.AGENCY_IMG, ImageDescriptor.createFromURL(b.getEntry(RentalUICstes.AGENCY_IMG)));
	}


}
