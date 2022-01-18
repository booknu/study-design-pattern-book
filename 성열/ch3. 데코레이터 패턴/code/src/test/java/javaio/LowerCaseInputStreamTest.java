package javaio;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowerCaseInputStreamTest {
	@Test
	void 소문자_stream_테스트() {
		String target = "ABCDEFG abCdEfG AaAaAAAaA CcCcCCCcC";

		InputStream in = new LowerCaseInputStream(
				new ByteArrayInputStream(target.getBytes(StandardCharsets.UTF_8)));

		Scanner sc = new Scanner(in);

		assertEquals(sc.nextLine(), target.toLowerCase(Locale.ROOT));
	}
}
