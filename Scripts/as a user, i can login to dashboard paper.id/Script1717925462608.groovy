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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Open page'
WebUI.callTestCase(findTestCase('page/open page'), [:], FailureHandling.STOP_ON_FAILURE)

'Input email'
WebUI.callTestCase(findTestCase('page/input email'), [('email'): email], FailureHandling.STOP_ON_FAILURE)

'Wait modal input password visible'
if (WebUI.waitForElementVisible(findTestObject('Object Repository/modal_input_password'), 5, FailureHandling.STOP_ON_FAILURE) == 
true) {
    'Input password'
    WebUI.callTestCase(findTestCase('page/input password'), [('password') : password], FailureHandling.STOP_ON_FAILURE)
}

'Delay to open dashboard'
WebUI.delay(4)

'Assert URL'
WebUI.verifyMatch(WebUI.getUrl(), url, false, FailureHandling.STOP_ON_FAILURE)