package sample

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.util.internal.PathUtil as PathUtil

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When


class AddDeleteNewNoteToSampleNotepadApp {

	// DATA DEFINITION
	def noteTitle = findTestData('New_Note_data_value').getValue('Note\'s TITLE', 1)
	def noteContent = findTestData('New_Note_data_value').getValue('Note\'s CONTENT', 1)

	def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_AndroidApp, RunConfiguration.getProjectDir())

	@Given('I open Sample Notepad App')
	def I_open_Sample_Notepad_App() {
		Mobile.startApplication(appPath, true)
		Mobile.tap(findTestObject('ADD_BUTTON'), 5)
	}

	@When('I add new Note\'s title "(.*)"')
	def I_Add_new_Notes_title(String noteTitle) {
		Mobile.setText(findTestObject('NOTE_TITLE_TEXTBOX'), noteTitle, 5)
	}

	@Then('I add new Note\'s content "(.*)"')
	def I_Add_new_Notes_content(String noteContent) {
		Mobile.setText(findTestObject('NOTE_DETAILS_TEXTBOX'), noteContent, 5)
	}

	@And('I save new Note')
	def I_Save_new_Note() {
		Mobile.tap(findTestObject('SAVE_BUTTON'), 5)
	}

	@And('I delete new Note')
	def I_Delete_new_Note() {
		Mobile.tap(findTestObject('SELECT_BUTTON'), 5)
		Mobile.tap(findTestObject('DELETE_BUTTON'), 5)
		
		def message = Mobile.getText(findTestObject('POPUP_TEXT_MESSAGE'), 5)
		Mobile.verifyEqual(message, 'Are you sure you want to delete note \'New Note TITLE\'? The note can\'t be recovered after that.')
		
		Mobile.tap(findTestObject('POPUP_DELETE_BUTTON'), 5)
		
		Mobile.closeApplication()
	}
}