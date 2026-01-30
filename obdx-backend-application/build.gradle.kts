dependencies {
    implementation(project(":obdx-backend-domain"))

    compileOnly("org.springframework:spring-context")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.testng:testng:7.12.0")
    testImplementation("junit:junit")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine")
}
