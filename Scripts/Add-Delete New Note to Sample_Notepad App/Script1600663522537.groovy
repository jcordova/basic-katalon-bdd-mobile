import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.internal.PathUtil as PathUtil

def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_AndroidApp, RunConfiguration.getProjectDir())

Mobile.startApplication(appPath, true)

Mobile.tap(findTestObject('ADD_BUTTON'), 5)

Mobile.setText(findTestObject('NOTE_TITLE_TEXTBOX'), 'New Note TITLE', 5)

Mobile.setText(findTestObject('NOTE_DETAILS_TEXTBOX'), 'New Note CONTENT', 5)

Mobile.tap(findTestObject('SAVE_BUTTON'), 5)

Mobile.tap(findTestObject('SELECT_BUTTON'), 5)

Mobile.tap(findTestObject('DELETE_BUTTON'), 5)

def message = Mobile.getText(findTestObject('POPUP_TEXT_MESSAGE'), 5)

Mobile.verifyEqual(message, 'Are you sure you want to delete note \'New Note TITLE\'? The note can\'t be recovered after that.')

Mobile.tap(findTestObject('POPUP_DELETE_BUTTON'), 5)

Mobile.closeApplication()

