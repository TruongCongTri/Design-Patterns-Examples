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
public final class SingletonSingleThread {

    private static SingletonSingleThread instance;
    public String value;

    private SingletonSingleThread(String value) {
        // The following code emulates slow initialization.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static SingletonSingleThread getInstance(String value) {
        if (instance == null) {
            instance = new SingletonSingleThread(value);
        }
        return instance;
    }
    
}
