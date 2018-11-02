package com.kuerkwitz.Lsystem.resources;

import java.io.File;
import java.util.Scanner;

public class AbsolutePathEvaluator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String read = "src/com.kuerkwitz.Lsystem.resources/Untitled.png";
        File f = new File(read);

        System.out.print((f).getAbsolutePath());
        scanner.nextLine();
        f = null;
    }
}
