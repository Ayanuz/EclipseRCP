package com.sogeti.rental.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.RentalAgency;
import com.sogeti.rental.core.RentalCoreActivator;
import com.sogeti.rental.ui.RentalUiActivator;

public class AgencyView extends ViewPart implements IPropertyChangeListener {

	private TreeViewer tv;

	public AgencyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		// TODO Auto-generated method stub
		super.init(site);
		RentalUiActivator.getDefault().getPreferenceStore().addPropertyChangeListener(this);

	}

	@Override
	public void createPartControl(Composite parent) {
		tv = new TreeViewer(parent);
		tv.setContentProvider(new RentalProvider());
		tv.setLabelProvider(new RentalProvider());
		Collection<RentalAgency> agencies = new ArrayList<RentalAgency>();
		agencies.add(RentalCoreActivator.getAgency());
		tv.setInput(agencies);
		getSite().setSelectionProvider(tv);
		MenuManager menu_manager = new MenuManager();
		Menu menu = menu_manager.createContextMenu(tv.getControl());
		tv.getControl().setMenu(menu);
		getSite().registerContextMenu(menu_manager, tv);
		tv.expandAll();

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		// TODO Auto-generated method stub
		tv.refresh();

	}

}
