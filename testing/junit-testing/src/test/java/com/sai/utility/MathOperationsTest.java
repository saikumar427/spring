package com.sai.utility;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.params.provider.Arguments.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

@TestInstance(Lifecycle.PER_METHOD)
class MathOperationsTest {

	private MathOperations ops;
	@BeforeEach
	void setUp() {
		ops = Mockito.mock(MathOperations.class);
	}
	
	
	
	@Nested
	@Tag("Calculations")
	@Disabled
	class Claculate{
		@Test
		public void testAdd() {
			assertAll(
					()->assertEquals(10, ops.add(3, 7))
					);
		}
		@Test
		public void testSub() {
			assertAll(
					()->assertEquals(-4, ops.sub(3, 7))
					);
		}
	}
	
	@Tag("area")
	@ParameterizedTest(name = "{index} area with {0}")
	@ValueSource(ints = {4,5,6,7})
	void testSquareArea(int p) {
		assumeTrue(true);
		when(ops.areaOfSquare(4)).thenReturn(16);
		assertEquals(p*p, ops.areaOfSquare(p));
	}

	static Stream<Arguments> stringIntAndListProvider() {
	    return Stream.of(
	        arguments(4,2,2),
	        arguments(10,3,7)
	    );
	}
}
