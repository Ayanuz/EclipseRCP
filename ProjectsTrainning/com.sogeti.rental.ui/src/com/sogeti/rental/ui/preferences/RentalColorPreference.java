package com.sogeti.rental.ui.preferences;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.sogeti.rental.ui.RentalUICstes;
import com.sogeti.rental.ui.RentalUiActivator;

public class RentalColorPreference extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage, RentalUICstes{

	public RentalColorPreference() {
		// TODO Auto-generated constructor stub
		super(GRID);
		setPreferenceStore(RentalUiActivator.getDefault().getPreferenceStore());
		setDescription("Préférence page pour l'application Rental");
	}
	

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFieldEditors() {
		// TODO Auto-generated method stub
		addField(new ColorFieldEditor(P_CUSTOMER_COLOR, CUSTOMER_NODE, getFieldEditorParent()));
		addField(new ColorFieldEditor(P_RENTAL_COLOR, LOCATIONS_NODE, getFieldEditorParent()));
		addField(new ColorFieldEditor(P_OBJCTS_COLOR, RENTAL_OBJ_NODE, getFieldEditorParent()));
	}

}