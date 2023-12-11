package com.devonfw.tools.ide.tool.pip;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.any;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

import java.nio.file.Path;
import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.devonfw.tools.ide.tool.AbstractUrlUpdaterTest;
import com.devonfw.tools.ide.url.model.file.json.StatusJson;
import com.devonfw.tools.ide.url.model.file.json.UrlStatus;
import com.devonfw.tools.ide.url.model.folder.UrlRepository;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;

/**
 * Test of {@link PipUrlUpdater} based on Wiremock.
 */
@WireMockTest(httpPort = 8080)
public class PipUrlUpdaterTest extends AbstractUrlUpdaterTest {

  /**
   * Tests if the {@link com.devonfw.tools.ide.tool.pip.PipUrlUpdater} will successfully resolve a server with a
   * Content-Type:text header response.
   * <p>
   * See: <a href="https://github.com/devonfw/ide/issues/1343">#1343</a> for reference.
   *
   * @param tempDir Temporary directory
   */
  @Test
  public void testPipUrlUpdaterWithTextContentTypeWillSucceed(@TempDir Path tempDir) {

   
  }
}
