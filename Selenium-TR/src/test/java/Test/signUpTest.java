package Test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import io.github.bonigarcia.wdm.WebDriverManager;

public class signUpTest {
	String firstName = "George";
	String lastName = "Ursache";
	String email = "worldhotel73@gmail.com";
	String password = "123456789aA";
	String passwordConfirmation = "123456789aA";
	int index = 1;

	@Test
	public void test1() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://politrip.com/account/sign-up");
		driver.findElement(By.id("first-name")).sendKeys(firstName);
		if (firstName == "") {
			fail("This field can not be empty");
			System.out.println("Insert First Name");
		} else {
			System.out.println("First Name Pass");
		}

	}

	@Test
	public void test2() {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://politrip.com/account/sign-up");
		driver.findElement(By.id("last-name")).sendKeys(lastName);
		if (lastName == "") {
			fail("This field can not be empty");
			System.out.println("Insert Last Name");
		} else {
			System.out.println("Last Name Pass");
		}

	}

	@Test
	public void test3() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://politrip.com/account/sign-up");
		driver.findElement(By.id("email")).sendKeys(email);
		String regex1 = "^(.+)@(.+)$";
		boolean validEmail = isValidEmail(email, regex1);
		if (!validEmail) {
			fail();
		} else {
			System.out.println("Email Pass");
		}
	}

	@Test
	public void test4() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://politrip.com/account/sign-up");
		driver.findElement(By.id("sign-up-password-input")).sendKeys(password);
		driver.findElement(By.id("sign-up-confirm-password-input")).sendKeys(passwordConfirmation);
		String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
		boolean validPassword = isValidPassword(password, regex);
		if (!validPassword) {
			fail();
		}
		if (password == passwordConfirmation) {
			System.out.println("Password Pass");
		} else {
			fail();
		}
	}

	@Test
	public void test5() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://politrip.com/account/sign-up");
		Select opt = new Select(driver.findElement(By.id("sign-up-heard-input")));
		opt.selectByIndex(index);
		if (index < 1 || index > 4) {
			fail();
		} else {
			System.out.println("Index Pass");
		}
	}

	@Test
	public void test6() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://politrip.com/account/sign-up");
		driver.findElement(By.id("first-name")).sendKeys(firstName);
		driver.findElement(By.id("last-name")).sendKeys(lastName);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("sign-up-password-input")).sendKeys(password);
		driver.findElement(By.id("sign-up-confirm-password-input")).sendKeys(passwordConfirmation);
		Select opt = new Select(driver.findElement(By.id("sign-up-heard-input")));
		opt.selectByIndex(index);
		driver.findElement(By.xpath("//*[@id=\" qa_loader-button\"]")).click();
		// driver.close();
	}

	public static boolean isValidPassword(String password, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

	public static boolean isValidEmail(String email, String regex1) {
		Pattern pattern = Pattern.compile(regex1);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
