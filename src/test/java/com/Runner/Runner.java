package com.Runner;
import org.testng.*;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.testng.xml.XmlPackage;
import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	TestNG testng = new TestNG();
	XmlSuite xmlSuite = new XmlSuite();
	xmlSuite.setName("My TestNG TEST");
	xmlSuite.setVerbose(1);
	
	XmlTest xmlTest = new XmlTest(xmlSuite);
	xmlTest.setName("My Regression Tests");
	xmlTest.addIncludedGroup("e2e");
	XmlPackage xmlPackage = new XmlPackage("com.api.tests");
	
	List<XmlPackage> xmlPackagelist = new ArrayList<XmlPackage>();
	 xmlPackagelist.add(xmlPackage);
	 xmlTest.setPackages(xmlPackagelist);
	 
	 List<XmlTest> testList = new ArrayList<XmlTest>();
	 testList.add(xmlTest);
	 
	 xmlSuite.setTests(testList);
	 
	 List<XmlSuite> suitelist = new ArrayList<XmlSuite>();
	 suitelist.add(xmlSuite);
	 testng.setXmlSuites(suitelist);
	 
	 testng.run();
	}

}
