package com.wkt.boost.service.api;

import java.util.Date;

import com.wkt.boost.exception.ServiceException;

public interface SyncService {

	//get all user data
	String getUserData(int companyId, Date lastSyncDate) throws ServiceException;
	
}
