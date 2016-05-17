package com.ingenta.cubmvnprac;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty" }, tags = "@browser-stack", monochrome = true)
public class RunTest {
}
