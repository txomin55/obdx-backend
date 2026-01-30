import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    id("org.springframework.boot")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation(project(":obdx-backend-infrastructure"))
}

springBoot {
    mainClass.set("com.obdx.ObdxBackendApplication")
}

val springProfilesActive = (findProperty("springProfilesActive") as String?) ?: "develop"
val projectArtifactId: String = project.name
val projectVersion = project.version.toString()

tasks.processResources {
    filesMatching("application.yml") {
        filter<ReplaceTokens>(
            "tokens" to mapOf(
                "spring.profiles.active" to springProfilesActive,
                "project.artifactId" to projectArtifactId,
                "project.version" to projectVersion,
            ),
            "beginToken" to "@",
            "endToken" to "@",
        )
    }
}
