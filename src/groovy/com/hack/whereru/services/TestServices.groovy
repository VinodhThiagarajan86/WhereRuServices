package com.hack.whereru.services

import com.hack.whereru.accessor.MySQLAccessor
import groovy.util.logging.Log4j

import java.rmi.RemoteException

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Log4j
@Service
class TestServices {
	
	@Autowired
	MySQLAccessor mySqlAccessor
	
	def testService(){
		mySqlAccessor.fetchUserDetailsDA()
	}
	
	def testInsertService(insertModel){
		mySqlAccessor.insertLatLongValue(insertModel)
	}

}
