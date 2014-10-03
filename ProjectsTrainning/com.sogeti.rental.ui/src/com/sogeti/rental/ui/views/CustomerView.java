package com.sogeti.rental.ui.views;



import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;
import com.sogeti.rental.core.RentalCoreActivator;

import org.eclipse.swt.widgets.Combo;

public class CustomerView extends ViewPart implements ISelectionListener {
	private Label lblCustomerName;
	
	public CustomerView() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init(IViewSite site) throws PartInitException {
		// TODO Auto-generated method stub
		super.init(site);
		site.getPage().addSelectionListener(this);
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		getSite().getPage().removeSelectionListener(this);
		super.dispose();
	}
	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		parent.setLayout(new GridLayout(1, false));
		Group infoGroup = new Group(parent, SWT.NONE);
		GridData gd_infoGroup = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_infoGroup.widthHint = 158;
		infoGroup.setLayoutData(gd_infoGroup);
		infoGroup.setText("Customer spy");
		infoGroup.setLayout(new GridLayout(1, false));
		
		lblCustomerName = new Label(infoGroup, SWT.NONE);
		this.setCustomer(RentalCoreActivator.getAgency().getCustomers().get(0));
	}

	
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	private void setCustomer(Customer cust) {
		lblCustomerName.setText(cust.getDisplayName());
	}
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		
		if(selection.isEmpty())
			return;
		
		if(selection instanceof IStructuredSelection) {
			Object selected = ((IStructuredSelection) selection).getFirstElement();
			Customer cust = (Customer) Platform.getAdapterManager().getAdapter(selected, Customer.class);
			if (cust != null)
				setCustomer(cust);
		}
			
	}
	
	
}
