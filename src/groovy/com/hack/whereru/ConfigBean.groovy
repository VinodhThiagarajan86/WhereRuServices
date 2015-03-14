package com.hack.whereru

import groovy.util.logging.Log4j

import org.springframework.stereotype.Component

// TODO: Convert to @Singleton

@Log4j
@Component
class ConfigBean {
    static configBean
    static env

	static getEnv() {
        env = env ?: System.getProperty('cft.env') ?: System.getenv('cft.env') ?: 'dev'
		return env
	}

    static setEnv(env) {
        this.env = env
    }

    static initializeConfigBean() {
		this.log.warn "Loading configuration for environment: ${getEnv()}"
        new ConfigSlurper(getEnv()).parse(ConfigBean.classLoader.loadClass('Config'))
		
    }

	static def getConfig() {
        configBean = configBean ?: initializeConfigBean()
        return configBean
	} 
	
}
