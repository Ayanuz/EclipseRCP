package com.sogeti.rental.ui.palettes;

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalObject;
import com.sogeti.rental.ui.RentalUICstes;
import com.sogeti.rental.ui.RentalUiActivator;

public class DefaultPalette implements IColorProvider, RentalUICstes {

	public DefaultPalette() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getForeground(Object element) {

		if (element instanceof Customer) {
			String str_color = RentalUiActivator.getDefault().getPreferenceStore().getString(P_CUSTOMER_COLOR);
			return getAColor(str_color);
		} else if (element instanceof RentalObject) {
			String str_color = RentalUiActivator.getDefault().getPreferenceStore().getString(P_OBJCTS_COLOR);
			return getAColor(str_color);

		} else if (element instanceof Rental) {
			String str_color = RentalUiActivator.getDefault().getPreferenceStore().getString(P_RENTAL_COLOR);
			return getAColor(str_color);
		}

		return null;

	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return Display.getDefault().getSystemColor(SWT.COLOR_INFO_BACKGROUND);
	}

	private Color getAColor(String rgb_str) {
		ColorRegistry c_reg = JFaceResources.getColorRegistry();

		Color col = c_reg.get(rgb_str);

		if (col == null) {
			c_reg.put(rgb_str, StringConverter.asRGB(rgb_str));
			col = c_reg.get(rgb_str);
		}
		return col;
	}

}
