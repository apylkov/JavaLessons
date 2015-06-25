package com.rs.mvis.utils;

import java.util.Random;

public class IDGenerator
{
	private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String numbers = "0123456789";
	private static final Integer length = 16;

	/**
	 * Generate random ID with length of 16.
	 * 
	 * @return @String Generated ID
	 */
	public static String generateID()
	{
		Random random = new Random();
		StringBuilder pwd = new StringBuilder();
		for (int i = 0; i < length; i++)
		{
			char symbol;
			String str = "";
			switch (random.nextInt(3))
			{
			case 0:
				symbol = alphabet.charAt(random.nextInt(alphabet.length()));
				str = String.valueOf(symbol);
				break;
			case 1:
				symbol = numbers.charAt(random.nextInt(numbers.length()));
				str = String.valueOf(symbol);
				break;
			case 2:
				symbol = alphabet.charAt(random.nextInt(alphabet.length()));
				str = String.valueOf(symbol);
				str = str.toLowerCase();
				break;
			default:
				break;
			}
			pwd.append(str);
		}
		return pwd.toString();
	}
}
