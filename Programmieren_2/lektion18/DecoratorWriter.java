package de.thws.lektion18;

import java.io.*;

public abstract class DecoratorWriter extends Writer
{
  protected Writer writer;
  
  @Override
  public abstract void write(char[] cbuf, int off, int len) throws IOException;

  @Override
  public abstract void flush() throws IOException;

  @Override
  public abstract void close() throws IOException;
}
