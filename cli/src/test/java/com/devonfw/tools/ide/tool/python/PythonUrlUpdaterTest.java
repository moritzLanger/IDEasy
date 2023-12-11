package com.devonfw.tools.ide.tool.python;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.any;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.devonfw.tools.ide.url.model.folder.UrlRepository;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;

/**
 * {@link WireMockTest} using {@link PythonUrlUpdaterMock}.
 */
@WireMockTest(httpPort = 8080)
public class PythonUrlUpdaterTest extends Assertions {

  private final static String testdataRoot = "src/test/resources/integrationtest/PythonJsonUrlUpdater";

  /**
   * Test Python JsonUrlUpdater
   *
   * @param tempPath Path to a temporary directory
   * @throws IOException test fails
   */
  @Test
  public void testPythonURl(@TempDir Path tempPath) throws IOException {

   
  }
}
