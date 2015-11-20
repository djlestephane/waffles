Setup
=====

* Git clone the waffles repository
* Launch SpringSource STS
* Click **Dashboard** Toolbar Icon
* Click **Extensions** Tab
* Select **Gradle Support**
* Click **Install** and proceed with the prompts
* Right-click the **waffles** project
* Select **Configure / Convert to Gradle Project...**
* Press **Shift+Ctrl+Alt+R** to open the gradle task launcher
* Type **init**, and press **Enter**
* Open **build.gradle** and remove the /* and */ comment markers
* Add

        apply plugin: 'java'
        apply plugin: 'eclipse'

        sourceCompatibility = 1.8
        targetCompatibility = 1.8

        repositories { jcenter() }

        dependencies {
            testCompile "junit:junit:4.11"
        }

For more information
====================

* Select **File / New / Import Spring Getting Started Content...**
* Select **Gradle**

