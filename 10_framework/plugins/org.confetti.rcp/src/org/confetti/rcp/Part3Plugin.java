package org.confetti.rcp;


import org.confetti.core.DataProvider;
import org.confetti.dummy.DataProviderImpl;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class Part3Plugin extends AbstractUIPlugin {

	//The shared instance.
	private static Part3Plugin plugin;
	private DataProvider dp;
	
	/**
	 * The constructor.
	 */
	public Part3Plugin() {
		plugin = this;
		dp = createDummyModel();
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static Part3Plugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path.
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.ui.tutorials.rcp.part3", path);
	}
	
	private DataProvider createDummyModel() {
		return new DataProviderImpl();
	}

	public DataProvider getDummyModel() {
		return dp;
	}
}
