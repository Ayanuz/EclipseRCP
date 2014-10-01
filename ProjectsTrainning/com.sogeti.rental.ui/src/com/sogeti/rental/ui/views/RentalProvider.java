package com.sogeti.rental.ui.views;

import java.util.Collection;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.internal.theme.RangeDrawData;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;
import com.sogeti.rental.ui.RentalUICstes;
import com.sogeti.rental.ui.RentalUiActivator;

public class RentalProvider extends LabelProvider implements
		ITreeContentProvider, RentalUICstes, IColorProvider  {

	@Override
	public Color getForeground(Object element) {

		if (element instanceof Customer)

			return Display.getCurrent().getSystemColor(SWT.COLOR_BLUE);

		else if (element instanceof RentalObject)

			return Display.getCurrent().getSystemColor(SWT.COLOR_GREEN);

		else if (element instanceof RentalAgency)

			return Display.getCurrent().getSystemColor(SWT.COLOR_RED);

		else if (element instanceof Node)

			return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_MAGENTA);

		return null;

	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return Display.getDefault().getSystemColor(SWT.COLOR_INFO_BACKGROUND);
	}
	
	class Node {
		private String lbl_node;
		private RentalAgency agency;
		
		public Node(String lbl_node, RentalAgency agency) {
			super();
			this.lbl_node = lbl_node;
			this.agency = agency;
		}
		
		public boolean hasChildren(Object element) {
			// TODO Auto-generated method stub
			return true;
		}
		
		public String getLbl_node() {
			return lbl_node;
		}

		public void setLbl_node(String lbl_node) {
			this.lbl_node = lbl_node;
		}
		

		@Override
		public String toString() {
			return this.lbl_node;
		}
		
		public Object[] getChildren() {
			if (this.lbl_node.equals(CUSTOMER_NODE))
				return agency.getCustomers().toArray();
			else if (this.lbl_node.equals(LOCATIONS_NODE))
				return agency.getRentals().toArray();
			else if (this.lbl_node.equals(RENTAL_OBJ_NODE))
				return agency.getObjectsToRent().toArray();
			return null;
		}
	}
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object inputElement) {
		// TODO Auto-generated method stub
		if(inputElement instanceof Collection)
			return ((Collection) inputElement).toArray();
		
		return null;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		// TODO Auto-generated method stub
		if (parentElement instanceof RentalAgency)
		{
			RentalAgency a = (RentalAgency) parentElement;
			return new Node[] {new Node(CUSTOMER_NODE, a), new Node(RENTAL_OBJ_NODE, a), new Node(LOCATIONS_NODE, a)};
		}
		else if(parentElement instanceof Node)
			return ((Node)parentElement).getChildren();
		return null;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		// TODO Auto-generated method stub
		if ( (element instanceof RentalAgency) || (element instanceof Node))
			return true;
		
		return false;
	}
	@Override
	public String getText(Object element) {
		// TODO Auto-generated method stub
		if (element instanceof RentalAgency)
			return ((RentalAgency)element).getName();
		else if (element instanceof Customer)
			return ((Customer)element).getDisplayName();
		else if (element instanceof RentalObject)
			return ((RentalObject)element).getName();
		
		return super.getText(element);
	}
	
	@Override
	public Image getImage(Object element) {
		// TODO Auto-generated method stub
		if (element instanceof RentalAgency)
			return RentalUiActivator.getDefault().getImageRegistry().get(AGENCY_IMG);
			
		else if (element instanceof Node)
			if (((Node)element).toString().equals(LOCATIONS_NODE))
				return RentalUiActivator.getDefault().getImageRegistry().get(LOCATIONS_NODE);
			else if (((Node)element).toString().equals(CUSTOMER_NODE))
				return RentalUiActivator.getDefault().getImageRegistry().get(CUSTOMER_NODE);
			else if (((Node)element).toString().equals(RENTAL_OBJ_NODE))
				return RentalUiActivator.getDefault().getImageRegistry().get(RENTAL_OBJ_NODE);
		return null;		
	}
	
}


