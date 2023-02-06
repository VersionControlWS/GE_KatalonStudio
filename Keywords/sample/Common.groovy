
package sample

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class Common {

	public static JsonSlurper jsonSlurper = new JsonSlurper()

	@Keyword
	def int createNewUser(int age, String username, String password, String gender, int expectedStatus) {
//		def response = WS.sendRequestAndVerify(findTestObject("Object Repository/POST a new user",
//				["age": age, "username": username, "password": password, "gender": gender]))
//
//		def jsonResponse = jsonSlurper.parseText(response.getResponseText())
//		return jsonResponse.id
		WebUI.openBrowser('')
		
		WebUI.navigateToUrl('https://staging.peppertree.ai/login')
		
		WebUI.setText(findTestObject('Object Repository/Page_GIROPie/input_Sign Up_r0'), 'uthukpnt@gmail.com')
		
		WebUI.setEncryptedText(findTestObject('Object Repository/Page_GIROPie/input__MuiInputBase-input MuiOutlinedInput-_047092'),
			'QWaBvTLiu9ZovX8NOeYSWg==')
		
		WebUI.click(findTestObject('Object Repository/Page_GIROPie/div_Continue'))
		
		WebUI.closeBrowser()
		
		return 1
	}

	@Keyword
	def static void findUserById(int id, int age, String username, String password, String gender, int expectedStatus) {
		WS.sendRequestAndVerify(findTestObject('Object Repository/GET user by id', [('id') : id]))
	}
}
