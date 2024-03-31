package de.thws.lektion18;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

import org.junit.jupiter.api.*;
public class ToUpperCaseWriterTest
{
  ByteArrayOutputStream baos;
  ToUpperCaseWriter writer;
  @BeforeEach
  public void prepareTest()
  {
    baos = new ByteArrayOutputStream();
    OutputStreamWriter osw = new OutputStreamWriter(baos);
    writer = new ToUpperCaseWriter(osw);
  }

  @Test
  private void performWriteTest(char c, String expectedOutput)
  {
    try
    {
      writer.write(c);
      writer.flush();
      assertEquals(baos.toString(), expectedOutput);
    }
    catch (IOException e)
    {
      fail("IOException" + e.getMessage());
    }
  }

  @Test
  public void testConvertLowerCaseToUpperCase() {
    for (char c = 'a'; c <= 'z'; c++) {
      prepareTest();
      performWriteTest(c, String.valueOf(Character.toUpperCase(c)));
      cleanUp();
    }
  }

  @Test
  public void testNonAlphabeticChars() {
    for (char c = 0; c <= 127; c++) {
      if ((c < 65 || c > 90) && (c < 97 || c > 122)) {
        prepareTest();
        performWriteTest(c, String.valueOf(c));
        cleanUp();
      }
    }
  }

  @AfterEach
  public void cleanUp() {
    try {
      writer.close();
    }
    catch (IOException e) {
      fail("IOException" + e.getMessage());
    }
  }
}
