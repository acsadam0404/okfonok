package hu.okfonok.utils

import org.apache.commons.lang3.StringUtils
import org.springframework.stereotype.Service

@Service("defaultMethods")
class GroovyDefaultMethods {
	static String abbreviate(String self, int maxWidth){
		return StringUtils.abbreviate(self, maxWidth)
	}
}
