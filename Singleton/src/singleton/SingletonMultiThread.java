/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

/**
 *
 * @author congt
 */
public class SingletonMultiThread {
    // The field must be declared volatile so that double check lock would work
    // correctly.
    private static volatile SingletonMultiThread instance;

    public String value;

    private SingletonMultiThread(String value) {
        this.value = value;
    }

    public static SingletonMultiThread getInstance(String value) {
        // The approach taken here is called double-checked locking (DCL). It
        // exists to prevent race condition between multiple threads that may
        // attempt to get singleton instance at the same time, creating separate
        // instances as a result.
        //
        // It may seem that having the `result` variable here is completely
        // pointless. There is, however, a very important caveat when
        // implementing double-checked locking in Java, which is solved by
        // introducing this local variable.
        //
        // You can read more info DCL issues in Java here:
        // https://refactoring.guru/java-dcl-issue
        SingletonMultiThread result = instance;
        if (result != null) {
            return result;
        }
        synchronized(SingletonMultiThread.class) {
            if (instance == null) {
                instance = new SingletonMultiThread(value);
            }
            return instance;
        }
    }
}
