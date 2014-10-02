package com.sogeti.rental.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import com.sogeti.rental.ui.RentalUICstes;
import com.sogeti.rental.ui.RentalUiActivator;

public class RentalPreferenceInitializer extends AbstractPreferenceInitializer implements RentalUICstes{

	public RentalPreferenceInitializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initializeDefaultPreferences() {
		// TODO Auto-generated method stub
		Color c = Display.getCurrent().getSystemColor(SWT.COLOR_BLUE);
		
		IPreferenceStore store = RentalUiActivator.getDefault().getPreferenceStore();
		store.setDefault(P_CUSTOMER_COLOR, StringConverter.asString(c.getRGB()));
		store.setDefault(P_OBJCTS_COLOR, StringConverter.asString(new RGB(255,0,0)));
		store.setDefault(P_RENTAL_COLOR, StringConverter.asString(new RGB(0,255,0)));
	}

}
