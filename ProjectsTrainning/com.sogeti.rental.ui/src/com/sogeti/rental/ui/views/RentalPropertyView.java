package com.sogeti.rental.ui.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
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

import com.opcoach.training.rental.Rental;
import com.sogeti.rental.core.RentalCoreActivator;

public class RentalPropertyView extends ViewPart implements ISelectionListener {

	private Label rentedObjLabel;
	private Label lblCustomerName;
	private Label lblFirstDate;
	private Label lblEndDate;

	public RentalPropertyView() {
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
		infoGroup.setText("Rental properties");
		infoGroup.setLayout(new GridLayout(2, false));

		rentedObjLabel = new Label(infoGroup, SWT.NONE);
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalSpan = 2;
		gd.horizontalAlignment = SWT.FILL;
		rentedObjLabel.setLayoutData(gd);
		this.setLblAsDragSrc(this.rentedObjLabel);
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
		lblCustomerName.setText(r.getCustomer().getDisplayName());
		lblFirstDate.setText(r.getStartDate().toString());
		lblEndDate.setText(r.getEndDate().toString());
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		if (selection instanceof IStructuredSelection) {
			Object selected = ((IStructuredSelection) selection).getFirstElement();
			if (selected instanceof Rental)
				this.setRental((Rental) selected);
		}

	}

	public void setLblAsDragSrc(final Label lbl) {
		DragSource dg_src = new DragSource(lbl, DND.DROP_MOVE | DND.DROP_COPY);
		dg_src.setTransfer(new Transfer[] { TextTransfer.getInstance() });
		dg_src.addDragListener(new DragSourceAdapter() {
			@Override
			public void dragSetData(DragSourceEvent event) {
				// TODO Auto-generated method stub
				if (TextTransfer.getInstance().isSupportedType(event.dataType))
					event.data = lbl.getText();
			}
		});

	}

}
