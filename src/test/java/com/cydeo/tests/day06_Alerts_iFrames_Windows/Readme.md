# Video:45:00

### - What is TestNG - Test Next Generation
### - Test NG is a Unit Testing Framework

### - Is this tool created for Testers? 
### - No, it is created for developers 

###  - Is TestNG the only Unit Testing Framework?
###  - No. JUnit, NUnit

### - How do we create structures or change behaviors of methods using TestNG? 
### - Annotations 

###  - By using annotations we can change the behaviours of the methods

### - Common annotation we will be using:
### - @ Test 
### - BeforeMethod, AfterMethod
### - BeforeClass, AfterClass 
### - BeforeSuite, AfterSuite

### @Test:
       - This annotation will convert a regular Java method into a runnable TestNG
       - Each test run by default in alphabetical order
       - But we can change the running order using priority.
       - Each test is independent from each other UNLESS we create dependency. 
        
        @Test (priority = 1)
        public void test1{

        //code

        //assertion

        //code (this code won't run if assertion above fails)

        // another assertion
        
        }

        @Test (priority = 2)
        public void test1{
        
        }

### - BeforeMethod:
     - This will run once before each test.
     - The number of tests we have will determine the number this method will be running.
     - If I have 10 @Test, this will run 10 times before each one of them.

### - AfterMethod:
    - Same as BeforeMethod, but will run after each test
    - It will just run once after each test

### - BeforeClass:
     - This will run only once in each class, before everything else
     - This does not care the number of @Tests we have in the class
     - Regardless it runs one time.

### - AfterClass:
     - Same as BeforeClass, but it will run after.
     - It will just run once after everythink is done in the class.

### Ex. If we want to open a new browser before each test, and close the browser after each test, where do we put our setup and teardown lines? 
 1 - BeforeMethod : WebDriver driver = WebDriverFactory.getDriver("chrome");
 2 - AfterMethod: driver.close();

### Assertions:
     - What do assertions do?
     - Assertions are used to verify if actual equals expected
     - String, int, List<WebElement>, List<String>
     - Assertions determine if a test passes or fails.

### - Which assertions we have seen so far?
     - Assert.assertEquals
                - Accepts 2 arguements.
                - Both arguments have to be same type
                - It will compare and determine faile or pass

###     - Assert.assertTrue
                - Accepts a boolean value.
                - If boolean returns true -> test passes
                - If boolean returns false -> test fails

###     - Assert.fail()
                - If you call this method is a @Test your test will faile regardless.

### --------------------------------------------------------------------------------------------------------------


### DROPDOWNS: 
### How many types of dropdowns we have?
    - 2

1. HTML Dropdowns (non-select)
    - if the dropdowns are created using anything other than <'select'> tag, it is a "non-select" dropdown 
2. Select Dropdowns
    _ if dropdown is created using <'select'> tag, it is a select dropdown
    - To be able to use the Select class from Selenium, it has to be < 'select'> dropdown.
   
### How do we handle select dropdowns?
#1. I would create Select class object
#2. I would locate the <'select'> dropdown and pas it into the constructor.
#3. Now I can use the Select object with the methods that comes from Select class.

    -getOptions:
        - to get all <'options'>
        - Return type: List<WebElements>

    - getFirstSelectedOption :
        - returns the currently selected option as a single web element
        - Return type: WebElement

- selectByIndex
- selectByValue
- selectByVisibleText
###
###
###
###
###
###
###
###
###
###
###
###
###
###