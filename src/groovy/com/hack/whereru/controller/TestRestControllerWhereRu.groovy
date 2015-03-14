package com.hack.whereru.controller

import groovy.json.JsonSlurper
import groovy.util.logging.Log4j

import java.text.SimpleDateFormat

import org.json.JSONArray
import org.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.geo.Circle
import org.springframework.data.geo.Distance
import org.springframework.data.geo.Metric;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.index.GeospatialIndex
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper
import com.hack.whereru.Customer
import com.hack.whereru.CustomerRepository
import com.hack.whereru.Location
import com.hack.whereru.LocationRepository
import com.hack.whereru.services.TestServices
import com.mongodb.BasicDBObject;

@Log4j
@RestController
@RequestMapping('/testWhereRu')
class TestRestControllerWhereRu {
	
	@Autowired
	TestServices testServices
	
	@Autowired
	private CustomerRepository repository;
	
	@Autowired 
	LocationRepository repo;
	
	 @Autowired 
	 MongoTemplate template;
	
	
	@RequestMapping(value = '/testing', method = RequestMethod.GET)
	def fetchUserRole(@RequestParam(value='name', required=true) def Name){
		testServices.testService()
	}
	
	@RequestMapping(value = '/testLatLongData', method = RequestMethod.POST)
	def saveDailyForecastData(  @RequestParam(value = 'latLongData', required = true) def latLongData ) {
			  Map mapParams=[ latLongData 			: latLongData  ]
			  def insertValueModel = latLongData
			  JsonSlurper jsonSlurper = new JsonSlurper();
			  Object insertModel = jsonSlurper.parseText(insertValueModel);
			  testServices.testInsertService(insertModel)
		   return true
	   }
	
	@RequestMapping(value = '/showFromMongo', method = RequestMethod.GET)
	def showFromMongoDB() {
		//println 'testit'
		def obj = repository.findByLastName("Vinodh");
		// ensure geospatial index
		template.indexOps(Location.class).ensureIndex( new GeospatialIndex("position") );
		// prepare data
		def a= new Double[2]
		def a1= new Double[2]
		
		a1[0] = -97.322980
		a1[1] = 32.862029
		
		a[0] = -96.626729
		a[1] = 32.930942

		repo.save( new Location("FortWorth", a1 ) );
		repo.save( new Location("Richardson", a ) );
 
		/*ObjectMapper myObjectMapper = new ObjectMapper();
		myObjectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		def temp = []
		obj.collect{
			temp <<  myObjectMapper.writeValueAsString(it)
			}
		Point obj2 = new Point(32.862029,-97.322980);
		List<Location> locations2 = repo.findByPositionNear(obj2 , new Distance(350, Metrics.MILES) );
		List<Location> locations = repo.findByPositionWithin( new Circle(0,0, 0.75) );
		locations*/
		
		"Success"
	}
		
}
