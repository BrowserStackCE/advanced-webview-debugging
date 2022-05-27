# Advanced Webview Debugging

This repository demonstrates how you can enable debugging and test your apps use WebViews.

The main branch contains sample app for [Android-AdvancedWebView](https://github.com/delight-im/Android-AdvancedWebView) app and the [default](https://github.com/browserstackCE/advanced-webview-debugging/tree/default) branch contains code for the default webview.

## Prerequisites

* Android SDK and tools

## Enable Android Debugging

1. You are using Android API 19 or higher for development. 
2. `minSdkVersion=19` for your app. 
3. In the OnCreate function of your application add the following code:
   ```java
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        WebView.setWebContentsDebuggingEnabled(true);
    }
   ```

You can find more on this from [Google's documentation](https://developer.chrome.com/docs/devtools/remote-debugging/webviews/#configure_webviews_for_debugging).

## Test your apps

Once you have followed the above process, you can build your application and test them on BrowserStack. For example, considering sample app of this repository:

1. Build the application. This should give you a `.apk` or `.aab`. You can find sample apps in the [dist](dist/) folder in the repository.
2. [Upload them on BrowserStack.](https://www.browserstack.com/docs/app-automate/appium/upload-app-from-filesystem)
3. Start a session using your desired framework with the app capability as app_url obtained from the above step. Sample capabilities:
   ```json
   {
      "app": "bs://<app_url>",
      "deviceName": "Google Pixel 5",
      "platformVersion": "11.0",
      "platformName": "android",
      "autoGrantPermissions": "true"
   }
   ```
4. When you call the [getContexts](https://appium.io/docs/en/commands/context/get-contexts/) of Appium, it will return an array containing "WEBVIEW_com.browserstack.webview" as one of the contexts.