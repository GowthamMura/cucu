package com.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassAdactinHotel {
	public static WebDriver driver;
	public static Object value;

	// 1. Get Driver
	public static void getdriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// 2. Get Url
	public static void getUrl(String url) {
		driver.get(url);
	}

	// 3. Maximize
	public static void maximize() {
		driver.manage().window().maximize();

	}

	// 4. Sendkeys
	public static void sendKeys(WebElement element,String value) {
		element.sendKeys(value);

	}

	// 5. Click
	public static void click(WebElement element) {
		element.click();

	}

	// 6. Click OK in Alert
	public void clickOkAlert() {
		Alert a = driver.switchTo().alert();
		a.accept();

	}

	// 7. Click Cancel in Alert 
	public void clickDismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();


	}

	// 8. Get Text ( Get Text From WebPage )
	public String getText(WebElement element) {
		String string = element.getText();
		return string;
	}

	// 9. Close All Windows
	public void closeAllWindows() {
		driver.quit();
	}

	// 10. Close Current Window
	public void closeCurrentWindow() {
		driver.close();
	}

	// 11. Get Attribute ( Inserted Value From TextBox )
	public String getAttribute(WebElement element) {
		String string = element.getAttribute("value");
		return string;
	}

	// 12. currentUrl(entered url)
	public String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	// 13. Get Title
	public String getTitle() {
		String title = driver.getTitle();
		return title;	
	}

	// 14. select by visible text(Dropdown By text)
	public void selectByTextDropdown(WebElement element,String value) {
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}

	// 15. Select By Get Options(DropDown By Attribute)
	public List<WebElement> getOptions(WebElement element,String value) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement webElement : options) {
			String attribute = webElement.getAttribute(value);
		}
		return options;
	}

	// 16. Select by index(dropDown)
	public void selectByIndex(WebElement element,int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}	

	// 17. JavaScript(Insert Value in Text box)
	public void sendKeysjs(WebElement element,String value) {
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("arguments[0].setAttribute('value')", element); 
	}

	// 18. JavaScript Click(Clilk Button)
	public void clickJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);

	}

	// 19. DriversetProperty(Launch Chromebrowser)
	public void setProperty(String key,String value) {
		System.setProperty(key, value);
	}

	// 20. Switch to Child Window(Windows handling)
	public  String switchToChildWindow(WebElement element,int index) {
		String parentwindow = driver.getWindowHandle();
		Set<String> allwindowsId = driver.getWindowHandles();
		List<String> li = new ArrayList();
		li.addAll(allwindowsId);
		String childwindowId = li.get(index);
		driver.switchTo().window(childwindowId);
		return parentwindow;		
	}

	// 21. Switch To Frame By Index
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	// 22. Switch To Frame By Id
	public void switchToFrameById(String value) {
		driver.switchTo().frame(value);

	}

	// 23. Find Element By Id
	public static WebElement findElementById(String value) {
		WebElement findElement = driver.findElement(By.id(value));
		return findElement;
	}

	// 24. Find Element By Name
	public static  WebElement findElementByName(String value) {
		WebElement findElement = driver.findElement(By.name(value));
		return findElement;
	}

	// 25. Find Element By Class
	public static WebElement findElementByClass(String value) {
		WebElement findElement = driver.findElement(By.className(value));
		return findElement;
	}

	// 26. Find Element By Xpath
	public static WebElement xPath(String value) {
		WebElement findElement = driver.findElement(By.xpath(value));
		return findElement;
	}

	// 27. Get All Options As Text ( Drop Down )
	public List<WebElement> getAllOptionFromDropDownAsText(WebElement element ) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement eachoptions : options) {
			String text = eachoptions .getText();
			System.out.println(text);
		}
		return options;
	}

	// 28. Get All Options As AttributeValue ( drop Down )
	public List<WebElement> getAllOptionsFromDropdownAsAttribute(WebElement element,String value) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement webElement : options) {
			String attribute = webElement.getAttribute(value);
			System.out.println(attribute);
		}
		return options;
	}

	// 29. First Selected Option Text ( Drop Down )
	public WebElement firstSelectedOptionText(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		System.out.println(text);
		return firstSelectedOption;
	}

	// 30. Verify Multi Select Option ( Drop Down )
	public boolean verifyMultiSelectOption(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		return multiple;

	}

	// 31. Implicity Wait
	public void implicityWait(int index) {
		driver.manage().timeouts().implicitlyWait(index, TimeUnit.SECONDS);
	}

	// 32. Explicit Wait
	public void explicitWait(WebElement element,int index) {
		WebDriverWait w = new WebDriverWait(driver, index);
		w.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	}

	// 33. DeSelect By Index
	public void deSelectByIndex(WebElement element,int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}

	// 34. DeSelect By Attribute
	public void deSelectByAttribute(WebElement element,String value) {
		Select s = new Select(element);
		s.deselectByValue(value);
	}

	// 35. DeSelect By Text
	public void deSelectByText(WebElement element,String value) {
		Select s = new Select(element);
		s.deselectByVisibleText(value);
	}

	// 36. DeSelect All
	public void deSelectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	// 37. Parent Window(windowsHandling)
	public String parentWindow(WebElement element) {
		String ParentWindowId = driver.getWindowHandle();
		driver.switchTo().window(ParentWindowId);
		return ParentWindowId;
	}
	//38.Allwindow(WindowsHandling)
	public Set<String> allWindow(WebElement element) {
		Set<String> allWindowsId = driver.getWindowHandles();
		List<String> li = new  ArrayList();
		li.addAll(allWindowsId);
		return allWindowsId;


	}

	//39.clear(Clear Text Box)
	public void clear(WebElement element) {
		element.clear();
	}
	//40.TakeScreenShot
	public File takeScreenShot(String pathname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(pathname);
		FileUtils.copyFile(src, dest);
		return src;
	}

	//41.Takescreenshot For Element
	public static File screenShotForElement(WebElement element,String pathname) throws IOException  {
		TakesScreenshot ts = (TakesScreenshot)element;
		File elementsrc = ts.getScreenshotAs(OutputType.FILE);
		File elementdest = new File(pathname);
		FileUtils.copyFile(elementsrc, elementdest);
		return elementdest;
	}
	//42.Singleoption(MouseOverAction)
	public void singleOption(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	//43.Drag and Drop
	public void dragAndDrop(WebElement element) {
		Actions a = new Actions(driver);
		a.dragAndDrop(element, element).perform();
	}

	//44.RickClick(Mouse Over Action)
	public void rightClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick().perform();

	}
	//45.DoubleClick(Mouse Over Action)
	public void doubleClick() {
		Actions a = new Actions(driver);
		a.doubleClick().perform();
	}

	//46. Insert Value sendKEys)
	public void insertValue(WebElement element,String value) {
		element.sendKeys(value+Keys.ENTER);
	}
	//47.RefreshPage(Navigation Method)
	public void refreshpage() {
		driver.navigate().refresh();
	}
	// 48. Navigate To
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}

	//49. Navigate Back
	public void navigateBack() {
		driver.navigate().back();
	}

	//50. Navigate Forward
	public void navigateForward() {
		driver.navigate().forward();	
	}

	// 51. Read Cell Data From Excel Sheet
	public static String readCellData(String sheetname,int index1,int Index2) throws IOException {
		String res="";
		File file = new File("C:\\Users\\Gowtham\\eclipse-workspace\\FrameWork\\ExcelSheeet\\Data.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet("Dask");
		Row row = sheet.getRow(index1);
		Cell cell = row.getCell(Index2);
		CellType cellType = cell.getCellType();

		switch (cellType) {

		case STRING:
			res= cell.getStringCellValue();

			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
				res = dateFormat.format(dateCellValue);

			} else {
				double numericCellValue = cell.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				long round = Math.round(numericCellValue);
				//res = valueOf.toString();
				if (numericCellValue==round) {
					res= String.valueOf(round);

				}else {
					res=String.valueOf(numericCellValue);
				}

			}break;
		default: break;
		}
		return res;
	}

	//52.Update value in your excel 
	public static void updateCellData(String sheetname,int rownum,int cellnum,String oldData,String newdata) throws IOException {
		File f = new File("C:\\\\Users\\\\Gowtham\\\\eclipse-workspace\\\\FrameWork\\\\ExcelSheeet\\\\Details.xlsx");
		FileInputStream fileInputStream = new FileInputStream(f);
		Workbook wrk = new XSSFWorkbook(fileInputStream);
		Sheet sheet = wrk.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String stringCellValue = cell.getStringCellValue();

		if (value.equals(oldData)) {
			cell.setCellValue(newdata);
		}
		FileOutputStream fileOutputStream = new FileOutputStream(f);
		wrk.write(fileOutputStream);	
	}
	//53.To insert cell data
	public void writeCellData(String sheetname,int rownum,int cellnum,String data) throws IOException {
		File f = new File("C:\\\\Users\\\\Gowtham\\\\eclipse-workspace\\\\FrameWork\\\\ExcelSheeet\\\\Data.xlsx");
		FileInputStream fileInputStream = new FileInputStream(f);
		Workbook wrk = new XSSFWorkbook(fileInputStream);
		Sheet sheet = wrk.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(f);
		wrk.write(fileOutputStream);	 
	}

	//54.Robot Class
	public void robotTab() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}

	public void robotEnter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	//55.implicit waits
	public static void addImplicityWait(int Sleepseconds) {
		driver.manage().timeouts().implicitlyWait(Sleepseconds, TimeUnit.SECONDS);

	}
	// 56. Robot Class
		public static void robotkey(int key) throws AWTException {
			Robot r = new Robot();
			r.keyPress(key);
			r.keyRelease(key);
		}

		public static String getProjectPath() {
			String path = System.getProperty("user.dir");
			return path;
		}

		public static String getPropertyFileValue(String Key) throws IOException {
			Properties properties = new Properties();
			properties.load(new FileInputStream(getProjectPath() + "\\Configuration\\config.properties"));
			Object object = properties.get(Key);
			String value = (String) object;
			return value;
		}

		public void browserLaunch(String browserType) {
			switch (browserType) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			case "Firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			case "ie":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;

			case "Edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;

			default:
				break;
			}
		}

		public byte[] screenShot() {

			TakesScreenshot screenshot = (TakesScreenshot) driver;
			byte[] bs = screenshot.getScreenshotAs(OutputType.BYTES);
			return bs;
		}
	}
//	//57.Attach scenario
//	public void afterScenario(Scenario scenario) {
//		scenario.attach(screenShot(),"image/png","Every scenario");
//		quitwindow();
//	}




































