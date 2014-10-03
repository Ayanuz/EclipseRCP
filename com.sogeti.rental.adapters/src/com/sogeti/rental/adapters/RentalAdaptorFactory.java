package com.sogeti.rental.adapters;

import org.eclipse.core.runtime.IAdapterFactory;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;

public class RentalAdaptorFactory implements IAdapterFactory {

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		// TODO Auto-generated method stub
		if((adaptableObject instanceof Rental) && (adapterType == Customer.class)) {
			return ((Rental)adaptableObject).getCustomer();
		}
		
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		// TODO Auto-generated method stub
		return new Class[] {Customer.class};
	}

}
