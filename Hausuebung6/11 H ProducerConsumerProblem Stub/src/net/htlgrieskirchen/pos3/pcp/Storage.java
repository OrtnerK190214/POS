/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.pcp;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Storage { 
    private final ArrayBlockingQueue<Integer> queue;
    
    private int fetchedCounter;
    private int storedCounter;
    private int underflowCounter;
    private int overflowCounter;
    private boolean productionComplete;
    
    public Storage() {
        this.queue = new ArrayBlockingQueue<>(10);
    }
    
    public synchronized boolean put(Integer data) throws InterruptedException {
        if (queue.size() == 10)
        {
            overflowCounter++;
            return false;
        }
        else {
            queue.put(data);
            storedCounter++;
            return true;
        }
    }
 
    public synchronized Integer get() {
        if (queue.size() == 0)
        {
            underflowCounter++;
            return null;
        }
        else {
            int sum = queue.poll();
            fetchedCounter++;
            return sum;
        }
    }

    public boolean isProductionComplete() {
        return productionComplete;
    }

    public void setProductionComplete() {
        productionComplete = true;
    }

    public int getFetchedCounter() {
        return fetchedCounter;
    }

    public int getStoredCounter() {
        return storedCounter;
    }

    public int getUnderflowCounter() {
        return  underflowCounter;
    }

    public int getOverflowCounter() {
        return overflowCounter;
    }
}
