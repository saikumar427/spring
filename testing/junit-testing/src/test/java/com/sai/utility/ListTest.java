package com.sai.utility;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class ListTest {

	@Mock
	List<String> strings;
	
	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() {
		//strings = mock(List.class);
	}
	
	@Test
	@DisplayName("List add method testing.")
	void testListAdd() {
		when(strings.get(anyInt())).thenReturn("first").thenReturn("second");
		strings.add("first");
		strings.add("first");
		assertEquals("first", strings.get(0));
		assertEquals("second", strings.get(88));
		verify(strings,atLeastOnce()).get(anyInt());
		
		 when(strings.get(anyInt())).thenThrow(new RuntimeException());
		 doReturn("first").when(strings).get(1);
		 assertEquals("first", strings.get(1));
		 //when(strings.get(1)).thenReturn("first");
		
	}
	
}
