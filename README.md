# TestAutomationDemo
Step by step guide how to prepare and setup environment for automated testing android application with Appium.

1.	Install Android Studio. We need Android/sdk/tools/bin/uiautomatorviewer from here to get app elements by (ID, class..)
2.	Setup Appium

*  brew install node // get node.js
*  npm install –g appium // get appium
*  npm install wd // get appium client
*  appium $ // start appium

3.	Set ANDROID_HOME environment
`
* nano ~/.bash_profile 
* export ANDROID_HOME=/YOUR_PATH_TO/android-sdk
* export PATH=$ANDROID_HOME/platform-tools:$PATH
* export PATH=$ANDROID_HOME/tools:$PATH
`
4.	Create new Java project. I use IntelliJ IDEA as editor.
5.	Import all dependencies. You can see dependencies on pom.xml file. Make sure that “Import Maven projects automatically” checkbox is selected in Preferences/Build, Execution, Deployment/Build Tools/Maven/Importing.
6.	For Appium desired capabilities I created AndroidSetup file. The apk file, appPackage and appActivity can be found by using 3rd party apps from store (e.g. MyAppShare or Apk Info). This AndroidSetup file will work as our BeforeClass method in our Test Class. For specific android device to run, we have to give udid, deviceName and platformName. I got udid and deviceName by “adb devices –l” command in terminal, and platformName from device settings. More about desired capabilities you can see here (https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/caps.md)
7.	For making life easy it’s better to have separate screens folder in our project. Each screen will contain its elements found by id/class/xpath/.. and appropriate action methods (clickBy, isDisplayed and etc)
8.	Finally we can start our first Test by creating new java file, in my case it is AppTest, which extends AndroidSetup file. BeforeClass we shall call our AndroidSetup in our setup method. After that I created my first test, which verifies if the item is added in my list manually.
9.	AfterClass we need to quit driver, otherwise, it will bring error, trying to run test 2nd time.
10.	 In my Test I verify if adding new item manually works. It skips the signup, clicks OK on Version popup, if it is displayed, adds an item to shopping list, and lastly it asserts if the there is an item with the same name.
11.	Please Run >appium in terminal before starting the test.
