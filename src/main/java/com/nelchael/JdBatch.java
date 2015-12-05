package com.nelchael;

import jd.common.loader.DirectoryLoader;
import jd.common.preferences.CommonPreferences;
import jd.common.printer.text.PlainTextPrinter;
import jd.core.Decompiler;
import jd.core.loader.LoaderException;
import jd.core.preferences.Preferences;
import jd.core.process.DecompilerImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class JdBatch {
	public static void main(String[] args) {
		Preferences preferences = new Preferences();
		CommonPreferences commonPreferences = new CommonPreferences();
		Decompiler decompiler = new DecompilerImpl();

		for (String arg : args) {
			System.out.println("Decompile: " + arg);
			try {
				FileOutputStream outputStream = new FileOutputStream(new File(arg.replace(".class", ".java")));
				decompiler.decompile(preferences, new DirectoryLoader(new File(".")), new PlainTextPrinter(commonPreferences, new PrintStream
					(outputStream)), arg);
			} catch (FileNotFoundException | LoaderException e) {
				System.out.println("Failed to decompile " + arg);
			}
		}
	}
}
