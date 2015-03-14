import groovy.time.TimeCategory


environments {
    local {
    }

	dev {
		datasource_mysql {
            driverClassName = 'com.mysql.jdbc.Driver'
			url = "jdbc:mysql://107.170.239.124:3306/whereru"
			username = "vinodhs"
			password = "MrithApril9677"
            maxActive = 10
		}
		
		
		cccrAppId { 
			
			cccrAppId = "11599" 
			cccrEndPoint = "http://bnsfwebdv.bnsf.com/bnsf.was6/cccrService/services/CCCRWebService"
			
			}
	}
	
	trial {}
	prod {}
	
}




	