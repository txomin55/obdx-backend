pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven {
            url = uri("https://repo.spring.io/milestone")
        }
    }
}

rootProject.name = "obdx-backend"

include(
    "obdx-backend-domain",
    "obdx-backend-application",
    "obdx-backend-infrastructure",
    "obdx-backend-loader",
)
