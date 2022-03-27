package com.sap.ariba.algoanddata;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    static Stack<RecordOperation> undo = new Stack<>();
    static StringBuffer appender = new StringBuffer();

    static void stringEditor(int op,
                             Scanner sc) {

        int operation = 0;
        switch (op) {
            case 1:
                String str = sc.next();
                undo.push(new RecordOperation(op,
                        str));
                appender.append(str);
                break;
            case 2:
                operation = sc.nextInt();
                undo.push(new RecordOperation(op,
                        appender.substring(appender.length() - operation)));
                appender.delete(appender.length() - operation,
                        appender.length());
                break;

            case 3:
                operation = sc.nextInt();
                System.out.println(appender.charAt(operation - 1));
                break;
            case 4:
                RecordOperation cmd = undo.pop();
                if (cmd.code == 1) {
                    appender.delete(appender.length() - cmd.arg.length(),
                            appender.length());
                } else {
                    appender.append(cmd.arg);
                }
                break;
        }
    }

    public static class RecordOperation {
        public int code;
        public String arg;

        RecordOperation(int code,
                        String arg) {
            this.code = code;
            this.arg = arg;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int numberOperation = sc.nextInt();
        for (int i = 0; i < numberOperation; i++) {
            stringEditor(sc.nextInt(), sc);
        }
    }

}

