package com.learn.datastructure.warmup;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Set<Integer> sockSet= new HashSet<>();
        int count = 0;
        for(Integer sock: ar){
            if(sockSet.contains(sock)){
                sockSet.remove(sock);
                count++;
            }else{
                sockSet.add(sock);
            }
        }
        return count;

    }

}

/*
There is a large pile of socks that must be paired by color. Given an array of integers
 representing the color of each sock, determine how many pairs of socks with matching colors there are.
*/
public class SalesByMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

