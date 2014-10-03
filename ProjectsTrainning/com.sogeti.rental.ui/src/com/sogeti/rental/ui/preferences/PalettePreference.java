package com.sogeti.rental.ui.preferences;

import java.util.Map;


import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.sogeti.rental.ui.Palette;
import com.sogeti.rental.ui.RentalUICstes;
import com.sogeti.rental.ui.RentalUiActivator;

public class PalettePreference extends FieldEditorPreferencePage implements IWorkbenchPreferencePage, RentalUICstes {

	public PalettePreference() {
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
		Map<String, Palette> palettes = RentalUiActivator.getDefault().getPalette_manager();
		String [][] combo_val = new String[palettes.size()][2];
		int i = 0;
		for (Palette p : palettes.values())
		{
			combo_val[i][0] = p.getName();
			combo_val[i][1] = p.getId();
			i++;

		}
		addField(new ComboFieldEditor(P_PALETTE, "Palette couleur :", combo_val, getFieldEditorParent()));

	}

}
