package frenchFlagProblem;

import org.junit.Test;

import junit.framework.TestCase;

public class FlagProblemTest extends TestCase {

	@Test
	public void test() {
		assertArrayEquals("simple test", new char[] { 'R', 'W', 'B' },
				FlagProblem.sortFlag(new char[] { 'B', 'W', 'R' }));
		assertArrayEquals(
				"No Ws",
				new char[] { 'R', 'R', 'R', 'R', 'B', 'B', 'B' },
				FlagProblem.sortFlag(new char[] { 'R', 'R', 'B', 'R', 'B', 'R',
						'B' }));
		assertArrayEquals(
				"No Rs",
				new char[] { 'W', 'W', 'W', 'W', 'B', 'B', 'B' },
				FlagProblem.sortFlag(new char[] { 'B', 'B', 'W', 'W', 'W', 'B',
						'W' }));
		assertArrayEquals(
				"No Bs",
				new char[] { 'R', 'R', 'R', 'R', 'W', 'W', 'W' },
				FlagProblem.sortFlag(new char[] { 'W', 'W', 'R', 'R', 'R', 'W',
						'R' }));
		assertArrayEquals(
				"Longer test",
				new char[] { 'R', 'R', 'R', 'R', 'W', 'W', 'W', 'B', 'B', 'B' },
				FlagProblem.sortFlag(new char[] { 'B', 'W', 'W', 'R', 'R', 'B',
						'R', 'W', 'R', 'B' }));
	} // test

}
