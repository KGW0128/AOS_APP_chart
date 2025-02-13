pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        //차트 의존성 추가
        maven("https://jitpack.io")

    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
       //차트 의존성 추가
        maven("https://jitpack.io")
    }
}

rootProject.name = "My Application"
include(":app")
 