package com.sogeti.rental.ui.views;



import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.Rental;
import com.sogeti.rental.core.RentalCoreActivator;
import org.eclipse.swt.widgets.Combo;

public class RentalPropertyView extends ViewPart {

	private Label rentedObjLabel;
	private Label lblCustomerName;
	private Label lblFirstDate;
	private Label lblEndDate;
	
	public RentalPropertyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		parent.setLayout(new GridLayout(1, false));
		Group infoGroup = new Group(parent, SWT.NONE);
		GridData gd_infoGroup = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_infoGroup.widthHint = 158;
		infoGroup.setLayoutData(gd_infoGroup);
		infoGroup.setText("Rental properties");
		infoGroup.setLayout(new GridLayout(2, false));
		
		rentedObjLabel = new Label(infoGroup, SWT.NONE);
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalSpan = 2;
		gd.horizontalAlignment = SWT.FILL;
		rentedObjLabel.setLayoutData(gd);
		
		Label lblStatCustomer = new Label(infoGroup, SWT.NONE);
		lblStatCustomer.setText("Lou\u00E9 \u00E0");
		
		lblCustomerName = new Label(infoGroup, SWT.NONE);
		
		Group grpDates = new Group(parent, SWT.NONE);
		grpDates.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		grpDates.setText("Dates pr\u00E9vues");
		grpDates.setLayout(new GridLayout(2, false));
		
		Label lblStatFirstDate = new Label(grpDates, SWT.NONE);
		lblStatFirstDate.setText("Date d\u00E9but");
		
		lblFirstDate = new Label(grpDates, SWT.NONE);
		lblFirstDate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblStatEndDate = new Label(grpDates, SWT.NONE);
		lblStatEndDate.setText("Date fin");
		
		lblEndDate = new Label(grpDates, SWT.NONE);
		lblEndDate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		this.setRental(RentalCoreActivator.getAgency().getRentals().get(0));
	}

	
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	private void setRental(Rental r) {
		rentedObjLabel.setText(r.getRentedObject().getName());
		lblCustomerName.setText( r.getCustomer().getDisplayName());
		lblFirstDate.setText( r.getStartDate().toString());
		lblEndDate.setText(r.getEndDate().toString());
	}
}
