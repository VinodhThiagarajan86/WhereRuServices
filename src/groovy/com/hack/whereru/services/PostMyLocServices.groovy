package com.hack.whereru.services

import groovy.util.logging.Log4j

import java.text.SimpleDateFormat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.index.GeospatialIndex
import org.springframework.stereotype.Service

import com.hack.whereru.collections.CurrentLocation
import com.hack.whereru.repository.CurrentLocationRepository

@Log4j
@Service
class PostMyLocServices {
	
	@Autowired
	CurrentLocationRepository currLocRepo;
	
	@Autowired
	MongoTemplate template;
	
	/**
	 *
	 * @param
	 * @return
	 */
	def insertCurrentLocation(insertModel){
		
		def userId 		=  insertModel.UserID
		def userName 	=  insertModel.UserName
		def latVal 		=  insertModel.Latitude
		def longVal 	=  insertModel.Longitude
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		currLocRepo.save( new CurrentLocation(userId , userName , Double.parseDouble(longVal) ,  Double.parseDouble(latVal) ,timeStamp));

	}

}
