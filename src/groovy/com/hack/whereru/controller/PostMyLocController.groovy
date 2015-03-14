package com.hack.whereru.controller

	
	
	import groovy.json.JsonSlurper
import groovy.util.logging.Log4j

import java.text.SimpleDateFormat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.index.GeospatialIndex
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import com.hack.whereru.Location
import com.hack.whereru.collections.CurrentLocation
import com.hack.whereru.repository.CurrentLocationRepository
import com.hack.whereru.services.PostMyLocServices
	
	@Log4j
	@RestController
	@RequestMapping("/postMyLoc")
	public class PostMyLocController {
	
		@Autowired
		CurrentLocationRepository currLocRepo;
		
		@Autowired
		PostMyLocServices postMyLocServices;
		
		@Autowired
		MongoTemplate template;
		
		@RequestMapping(value = "/WhereRu", method = RequestMethod.GET)
		public String showFromMogoDB() {
			
	
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			
			template.indexOps(Location.class).ensureIndex( new GeospatialIndex("position") );
	
			currLocRepo.save( new CurrentLocation("Srivat","Srivats" ,-97.322980,32.862029,timeStamp));
			currLocRepo.save( new CurrentLocation("Vino" ,,-96.626729, 32.930942 ,timeStamp));
		 
			return "Success";
		}
		
		@RequestMapping(value = "/postIt", method = RequestMethod.POST)
		def postMyCurrentLocation(  @RequestParam(value = "latLongData", required = true) def latLongData ) {
				  Map mapParams=[ latLongData 			: latLongData  ]
				  def insertValueModel = latLongData
				  JsonSlurper jsonSlurper = new JsonSlurper();
				  Object insertModel = jsonSlurper.parseText(insertValueModel);
				  postMyLocServices.insertCurrentLocation(insertModel)
		   }
	}
	
