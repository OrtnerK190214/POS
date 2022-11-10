/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.eaustria;

/**
 *
 * @author Kai Ortner
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Class wrapping methods for implementing reciprocal array sum in parallel.
 */
public final class ReciprocalArraySum {

    /**
     * Default constructor.
     */
    private ReciprocalArraySum() {
    }

    /**
     * Sequentially compute the sum of the reciprocal values for a given array.
     *
     * @param input Input array
     * @return The sum of the reciprocals of the array input
     */
    protected static double seqArraySum(final double[] input) {
        double sum = 0;

        for (int i = 0; i<=input.length; i++) {
                sum += (1 / input[i]);
        }
        return sum;
    }

    /**
     * This class stub can be filled in to implement the body of each task
     * created to perform reciprocal array sum in parallel.
     */
    private static class ReciprocalArraySumTask extends RecursiveAction {
        /**
         * Starting index for traversal done by this task.
         */
        private final int startIndexInclusive;
        /**
         * Ending index for traversal done by this task.
         */
        private final int endIndexExclusive;
        /**
         * Input array to reciprocal sum.
         */
        private final double[] input;
        /**
         * Intermediate value produced by this task.
         */
        private double value;
        
        private static int SEQUENTIAL_THRESHOLD = 50000;

        /**
         * Constructor.
         * @param setStartIndexInclusive Set the starting index to begin
         *        parallel traversal at.
         * @param setEndIndexExclusive Set ending index for parallel traversal.
         * @param setInput Input values
         */
        ReciprocalArraySumTask(final int setStartIndexInclusive,
                final int setEndIndexExclusive, final double[] setInput) {
            this.startIndexInclusive = setStartIndexInclusive;
            this.endIndexExclusive = setEndIndexExclusive;
            this.input = setInput;
        }

        /**
         * Getter for the value produced by this task.
         * @return Value produced by this task
         */
        public double getValue() {
            return value;
        }

        @Override
        protected void compute() {
            if (input.length < 3) {
                //value += seqArraySum(input);
                value = endIndexExclusive - startIndexInclusive;
            }
            else {
                int mid = input.length / 2;
                ReciprocalArraySumTask left =
                        new ReciprocalArraySumTask(0, mid - 1, Arrays.copyOfRange(input, 0, mid));
                ReciprocalArraySumTask right =
                        new ReciprocalArraySumTask(mid, input.length - 1, Arrays.copyOfRange(input, mid, input.length));
                invokeAll(left, right);
                left.join();
                right.join();
                value = left.getValue() + right.getValue();
            }
        }
    }

    /**
     * TODO: Extend the work you did to implement parArraySum to use a set
     * number of tasks to compute the reciprocal array sum. 
     *
     * @param input Input array
     * @param numTasks The number of tasks to create
     * @return The sum of the reciprocals of the array input
     */
    protected static double parManyTaskArraySum(final double[] input, final int numTasks) {

        ForkJoinPool pool = new ForkJoinPool(numTasks);

        ReciprocalArraySumTask task
                = new ReciprocalArraySumTask(0, input.length, input);
        pool.invoke(task);
        return task.getValue();
    }


    public static void main(String[] args) {
        double[] zahlen = new double[8];
        for (int i = 0; i < zahlen.length; i++) {
            zahlen[i] = i;
        }

        System.out.println(parManyTaskArraySum(zahlen, zahlen.length));
    }
}


