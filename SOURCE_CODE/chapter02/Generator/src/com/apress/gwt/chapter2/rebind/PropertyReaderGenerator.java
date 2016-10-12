package com.apress.gwt.chapter2.rebind;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

/**
 * This class represents the generator for the PropertyFileReader application
 * The generator reads the values of properties from a file and maps them to the
 * implementation of an interface.
 * 
 * @author Vipul Gupta (vipulgupta.vg@gmail.com)
 */
public class PropertyReaderGenerator extends Generator {

  @Override
  public String generate(TreeLogger logger, GeneratorContext context,
      String typeName) throws UnableToCompleteException {

    String generatedClassQualifiedName = createClass(logger, context, typeName);
    if (generatedClassQualifiedName == null) {
      throw new UnableToCompleteException();
    }
    return generatedClassQualifiedName;
  }

  private String createClass(TreeLogger logger, GeneratorContext context,
      String typeName) throws UnableToCompleteException {

    // We start by retrieving the TypeOracle object from the context
    TypeOracle typeOracle = context.getTypeOracle();
    try {

      // We retrieve the JClassType object and the package name for the
      // original type from the typeOracle
      JClassType originalType = typeOracle.getType(typeName);
      String packageName = originalType.getPackage().getName();

      // We retrieve the name of the properties file to use from the
      // metadata associated with the originalType
      String propertiesFileName = null;
      try {
        propertiesFileName = originalType
            .getMetaData("gwt.properties.filename")[0][0];
      } catch (Exception e) {
        throw new NotFoundException(
            "Properties file name not set using gwt.properties.filename tag");
      }

      // Retrieve the java.util.Properties object associated with the
      // properties file.
      InputStream in = Thread.currentThread().getContextClassLoader()
          .getResourceAsStream(propertiesFileName);
      if (in == null) {
        throw new FileNotFoundException("Property file named "
            + propertiesFileName + " not found in the classpath");
      }
      Properties properties = getProperties(in);

      // Create the name of the generated class from the name of the
      // originalType
      String originalClassName = originalType.getSimpleSourceName();
      String generatedClassName = originalClassName + "Gen";

      // Get a sourceWriter for the generated class
      SourceWriter sourceWriter = getSourceWriter(logger, context,
          originalType, packageName, generatedClassName);

      // Write code for the generated class if the sourceWriter is not null.
      // If it is null then the class has already been created.
      if (sourceWriter != null)
        writeClass(logger, originalType, properties, sourceWriter);

      // Return the fully qualified name of the generated type as this needs
      // to be returned by the overridden generate(...) method
      // of the Generator
      return originalType.getParameterizedQualifiedSourceName() + "Gen";

      // log errors with appropriate messages and return null as the name
      // of the generated class incase of exceptions
    } catch (FileNotFoundException e) {
      logger.log(TreeLogger.ERROR, e.getMessage(), e);
      return null;
    } catch (NotFoundException e) {
      logger.log(TreeLogger.ERROR, e.getMessage(), e);
      return null;
    } catch (IOException e) {
      logger.log(TreeLogger.ERROR, "Problem in reading properties file", e);
      return null;
    }
  }

  private Properties getProperties(InputStream in) throws IOException {
    if (in == null) {
      throw new IOException("Invalid or null stream for the property file");
    }

    // Create a java.util.Properties object from the InputStream passed to the
    // method and returns this object.
    Properties properties = new Properties();
    properties.load(in);
    return properties;
  }

  /**
   * The getSourceWriter(…) method attempts to create a specific class
   * (represented by generatedClassName) in a specified package (represented by
   * packageName). The generated class is then modified so that it implements
   * the Type whose object was asked to be constructed (represented by
   * originalType). If the class attempted to be generated already exists then
   * the method returns null, otherwise an instance of SourceWriter representing
   * the generated class is returned.
   * 
   */
  private SourceWriter getSourceWriter(TreeLogger logger,
      GeneratorContext context, JClassType originalType, String packageName,
      String generatedClassName) {

    ClassSourceFileComposerFactory classFactory = new ClassSourceFileComposerFactory(
        packageName, generatedClassName);

    classFactory.addImplementedInterface(originalType.getName());

    // Initialized as null if the resource already exist
    PrintWriter printWriter = context.tryCreate(logger, packageName,
        generatedClassName);

    // If the resource already exist then return null
    if (printWriter == null) {
      return null;
    }
    SourceWriter sourceWriter = classFactory.createSourceWriter(context,
        printWriter);
    return sourceWriter;
  }

  private void writeClass(TreeLogger logger, JClassType originalType,
      Properties properties, SourceWriter sourceWriter) {

    // We start by retrieving the various methods defined in the originalType
    JMethod[] methods = originalType.getMethods();

    // The source file is then indented by a few spaces
    sourceWriter.indent();

    // We create some local variables to use inside the loop
    JMethod method = null;
    JType type = null;
    String[][] keyNameMetadataArray = null;
    String keyName = null;

    // We loop through all the methods in the originalType and then add
    // an implementation for each of those methods in the generated class.
    for (int i = 0; i < methods.length; i++) {
      method = methods[i];
      type = method.getReturnType();

      // Write the method declaration in the generated class. For example for
      // String year() in the interface, this line will add 
      // public String year(){ in the generated class.
      sourceWriter.println();
      sourceWriter.println("public " + type.getSimpleSourceName() + " "
          + method.getName() + "() {");
      sourceWriter.indent();

      // Retrieve any metadata associated with this method in the original type.
      // We are specifically interested in metadata declared with key as gwt.key
      keyNameMetadataArray = method.getMetaData("gwt.key");

      // If metadata associated with gwt.key exists for this method i.e. if it
      // lists the key that needs to be used for returning the value from this
      // method, then use it. In case the key is missing, then use the
      // name of the method as the key to return the value from the properties
      // file.
      if (keyNameMetadataArray != null && keyNameMetadataArray.length != 0) {

        // Extracting the name of the key into a local variable for brevity
        keyName = keyNameMetadataArray[0][0];
        sourceWriter.println("return \"" + properties.getProperty(keyName)
            + "\" ;");
      } else {
        sourceWriter.println("return \""
            + properties.getProperty(method.getName()) + "\" ;");

      }
      sourceWriter.outdent();
      sourceWriter.println("}");

    }
    // Commits the source generated for this class
    sourceWriter.commit(logger);
  }
}
