package com.hack.whereru.accessor

import org.springframework.stereotype.Component;

import groovy.util.logging.Log4j;
import groovy.sql.Sql
import groovy.util.logging.Log4j

import java.sql.SQLException

import org.apache.tomcat.jdbc.pool.DataSource
import org.apache.tomcat.jdbc.pool.PoolProperties
import org.springframework.stereotype.Component

import com.hack.whereru.ConfigBean

@Log4j
@Component
class MySQLAccessor {

	Sql sqlInstance
	DataSource dataSource

	// Externalize datasource and sql to support unit tests
	def initialize() {
		if (!dataSource) {
			sqlInstance = null

			try {
				def config = ConfigBean.config.datasource_mysql
				//config.password = DESCodec.decode.call(ConfigBean.config.passwordEncrypt.key)
				PoolProperties properties = new PoolProperties(config)
				dataSource = new DataSource(properties)
			} catch (SQLException ex) {
				//this.log.fatal('CFT Database connection Failed!!!', ex)
				println 'WhereRu DB connection Failed!!!'+ex
			}
		}
		sqlInstance = new Sql(dataSource)
	}


	def getSql() {
		if (!sqlInstance) {
			initialize()
		}

		return sqlInstance
	}
	
	/**
	 * 
	 * @param 
	 * @return
	 */
	def fetchUserDetailsDA(){
		
		
		def persons = []
		sql.eachRow('SELECT * FROM whereru.gps_data') {
        persons << it.toRowResult()
		}
		persons
		
		
	}
	
	/**
	 *
	 * @param
	 * @return
	 */
	def insertLatLongValue(insertModel){
		
		def userName =  insertModel.UserName
		def latVal =  insertModel.Latitude
		def longVal =  insertModel.Longitude
		
		sql.execute('insert into whereru.gps_data values (?,?,?,current_timestamp)', [userName, latVal,longVal])
		
		
	}
}
