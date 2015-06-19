android-commons
===============

This library provides some common classes that i have used in a lot of my projects so far and have decided to move them to a reusable library.

#Features

## Working with application context
 One of the most common things that you need is access to application context from anywhere. The way
 i use Application context has never caused any issues in development or production applications. The
 key thing to remember is not to use the application context inside static initialization blocks or static initialization for variables in general.

    Commons.getContext();

To set it up you need to initialize Commons inside your application class. See the example project for details


## Working with Shared Preferences

This library offers what i consider a great practice when it comes to working with shared preferences.
A good pattern to manage all the access to shared preferences with a single point of contact where you manage all the keys and access to setting, getting or deleting values from preferences.

 You need to create a class extending from BasePreferenceUtil and define all your preference values there.

    public class PreferenceUtil extends BasePreferenceUtil {

      public static BooleanPreference getRememberMePreference() {
        return booleanPreference("key_remember_me");
      }
    }

The operations to change this key for example would be used this way:

    boolean b = PreferenceUtil.getRememberMePreference().get();

    PreferenceUtil.getRememberMePreference().set(true);

    PreferenceUtil.getRememberMePreference().delete();

You can also use the helper methods to serialize whole objects or lists

    PreferenceUtil.modelPreference("test_model", TestModel.class).set(new TestModel("darko", "G"));

    ListPreference<TestModel> testList = PreferenceUtil.listPreference("test_list", TestModel.class);
    List<TestModel> list = new ArrayList<TestModel>();
    list.add(new TestModel("one", "two"));
    list.add(new TestModel("three", "four"));
    testList.set(list);

The model serialization uses google GSON to convert the objects. Also keep in mind that you should avoid using this for more complex
scenarios due to the issues that happen with backwards compatibility and the inability to version the serialized models.

## Working with Intents

A good practice when working with intents is to have a central location where one manages all the operations with intents

This library offers a simple BaseIntentUtil class which one should extend and define their own methods and use the helpers provided

    public class IntentUtil extends BaseIntentUtil {

      public static void startMainActivity(Activity context) {
        startActivity(context, MainActivity.class);
      }
    }


## Working with fragments and progress dialog

`BaseFragmentUtl` provides a few shortcuts when working with fragments and also a way to show and hide a progress dialog for
 the blocking progress for long running operations.

 To show a progress dialog

    BaseFragmentUtil.showProgressDialog(fragmentManager);

 To hide it

    BaseFragmentUtil.clearProgressDialog(fragmentManager);


 Offers an Alert Dialog fragment for showing standard alert messages through a fragmentDialog which is a good way to show dialogs in new android releases

These API's works for Android 4.0+

## Working with notifications

A good practice for the app is to have a central place from which you show Toast messages or any custom toast notifications

just create a class extending `BaseNotificationUtil`

it provides a way to show toasts without the hassle of adding all the parameters and calling show()

    public static void makeToast(String message)
    public static void makeToast(int resId)


## ViewUtil

Some common operations for changing view visibility and a shortcut to convert dp to pixels

    ViewUtil.makeGone(v1,v2,v3,v4,....);
    ViewUtil.makeVisible(v1,v2,v3,v4,....);
    ViewUtil.makeInvisible(v1,v2,v3,v4,....);

    public static int dpToPixels(int dp)

## IOUtils

The most common usages for manipulation with streams, convert to a string, copy from one to another with a buffer etc...

    public static String toString(InputStream input) throws IOException
    public static int copy(Reader input, Writer output) throws IOException

## Network Util

Shortcuts for network connectivity checks

## UDID Generator

# Changelog

## 1.1.3

Updated samples
Small tweaks
Edited readme.md

## 1.1.2

Added More options to preference utils
added IO Utils
Added UDID Generator

## 1.0.0

Initial release

# Features

Some common classes for use in your android projects.


## Minimum SDK version / API level

The minimum API version is set to 11 because of FragmentUtils


## Include in your own project

### As Maven dependency

```java
<dependency>
    <groupId>com.aranea-apps.android.libs</groupId>
    <artifactId>android-commons</artifactId>
    <version>1.1.2</version>
    <type>aar</type>
</dependency>
```

### As Gradle dependency


```
dependencies {
    compile 'com.aranea-apps.android.libs:android-commons:1.1.2'
}
```


## Packaging

This project is packaged as AAR

## Contributors

## License

    Copyright 2014 Darko Grozdanovski

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.