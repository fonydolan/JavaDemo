package com.dolan.study.demo.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by fangqj on 2017/7/10.
 */
public class MathCounter implements Callable<Integer> {

    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MathCounter(File directory,String keyword,ExecutorService pool)
    {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }


    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override public Integer call() throws Exception {
        count =0;
        try
        {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();
            for(File file : files){
                if(file.isDirectory()){
                    MathCounter counter = new MathCounter(file,keyword,pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);
                }else{
                    if(FileUtils.search(file,keyword))count++;
                }
            }
            for(Future<Integer> result : results){
                try{
                    count+=result.get();
                }
                catch (ExecutionException e){
                    e.printStackTrace();
                }
            }
        }
        catch (InterruptedException e){

        }
        finally{
        }
        return count;
    }


}
