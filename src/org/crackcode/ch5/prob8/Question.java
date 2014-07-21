package org.crackcode.ch5.prob8;

public class Question {
	public static void main(String[] args){
		int x1 = 1;
		int x2 = 20;
		int y = 2;
		int width = 4;
		int height = 15;
		byte[] screen = new byte[width * height];

		System.out.println("Line: " + y + ", start: " + x1 + ", end: " + x2);
		
		screen = drawHorizontalLine(screen, width, x1, x2, y);
		printScreen(screen, width);
	}

	private static byte[] drawHorizontalLine(byte[] screen, int width, int x1,
			int x2, int y) {
		int firstByte = width * y + x1 / 8;
		int lastByte = width * y + x2 / 8;
//		System.out.println(firstByte + "  " + lastByte);

		int firstOffset = x1 % 8;
		int lastOffset = 8 - x2 % 8;
		
		// all within one byte
		if (lastByte - firstByte == 0){
			int mask = 0xFF >> firstOffset;
			mask = mask << (lastOffset - 1);
			screen[firstByte] |= mask;
		}
		else {
			// occupy more than one byte, has full bytes
			if (lastByte - firstByte > 1){
				int first_full_byte = firstByte + 1;
				int last_full_byte = lastByte - 1;
					for (int i = first_full_byte; i <= last_full_byte; i++ )
						screen[i] = (byte) 0xFF;
			}
			// occupy 2 bytes, but total length is less than one byte
			int mask1 = 0xFF >> firstOffset;
			int mask2 = 0xFF << (lastOffset -1);

			screen[firstByte] |= mask1;
			screen[lastByte] |= mask2;
		}
		return screen;
	}
	
	private static void printScreen(byte[] screen, int width){
		int height = screen.length / width;
		for(int j = 0; j < height; j++){
			for (int i = 0; i < width; i++){
				printByte(screen[j * width + i]);
			}
			System.out.println();
		}
	}

	private static void printByte(byte b) {
		for (int i = 7; i >= 0; i--)
			System.out.print((b>>i) & 1);
	}
}
