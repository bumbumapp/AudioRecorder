package com.dimowner.audiorecorder.app.main;

import static org.junit.Assert.assertEquals;

import com.dimowner.audiorecorder.R;

import org.junit.Test;

public class GreetingTest {
	@Test
	public void greetingFollowsTimeOfDay() {
		assertEquals(R.string.greet_evening, MainActivity.greetingRes(0));
		assertEquals(R.string.greet_evening, MainActivity.greetingRes(4));
		assertEquals(R.string.greet_morning, MainActivity.greetingRes(5));
		assertEquals(R.string.greet_morning, MainActivity.greetingRes(11));
		assertEquals(R.string.greet_afternoon, MainActivity.greetingRes(12));
		assertEquals(R.string.greet_afternoon, MainActivity.greetingRes(17));
		assertEquals(R.string.greet_evening, MainActivity.greetingRes(18));
		assertEquals(R.string.greet_evening, MainActivity.greetingRes(23));
	}
}
