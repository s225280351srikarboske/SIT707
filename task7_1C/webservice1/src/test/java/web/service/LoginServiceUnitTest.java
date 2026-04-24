package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceUnitTest {

	@Test
	public void testValidLogin() {
		Assert.assertTrue(LoginService.login("ahsan", "ahsan_pass", "1990-01-01"));
	}

	@Test
	public void testInvalidUsername() {
		Assert.assertFalse(LoginService.login("wrong", "ahsan_pass", "1990-01-01"));
	}

	@Test
	public void testInvalidPassword() {
		Assert.assertFalse(LoginService.login("ahsan", "wrong_pass", "1990-01-01"));
	}

	@Test
	public void testInvalidDob() {
		Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", "2000-01-01"));
	}

	@Test
	public void testEmptyUsername() {
		Assert.assertFalse(LoginService.login("", "ahsan_pass", "1990-01-01"));
	}

	@Test
	public void testEmptyPassword() {
		Assert.assertFalse(LoginService.login("ahsan", "", "1990-01-01"));
	}

	@Test
	public void testEmptyDob() {
		Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", ""));
	}

	@Test
	public void testNullValues() {
		Assert.assertFalse(LoginService.login(null, null, null));
	}
}