package hw_04_todo.cucumber.steps

import io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME
import io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME
import org.junit.platform.suite.api.ConfigurationParameter
import org.junit.platform.suite.api.IncludeEngines
import org.junit.platform.suite.api.SelectClasspathResource
import org.junit.platform.suite.api.Suite

@Suite
@SelectClasspathResource("todo")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "hw_04_todo/cucumber/steps" )
@IncludeEngines("cucumber")
@ConfigurationParameter(
    key = PLUGIN_PROPERTY_NAME,
    value = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
)
class TodoTest