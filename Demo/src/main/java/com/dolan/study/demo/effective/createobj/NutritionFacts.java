package com.dolan.study.demo.effective.createobj;

/**
 * Created by Administrator on 2017/7/11.
 */
public class NutritionFacts
{
    private final int servingSize;
    private final  int servings;
    private  final int calories;
    private final int fat;
    private final int sodium;
    //Builder模式创建对象  （重叠构造器的）安全性+（javabeans模式的）可读性
    public static class  Builder{

        private final int servingSize;
        private final  int servings;

        private  int calories =0;
        private  int fat=0;
        private  int sodium =0;

        public Builder(int servingSize,int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }
        public Builder fat(int fat){
            this.fat = fat;
            return  this;
        }
        public Builder calories(int calories){
            this.calories = calories;
            return this;
        }
        public Builder sodium(int sodium){
            this.sodium = sodium;
            return this;
        }
        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }
    private NutritionFacts(Builder builder){
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium=builder.sodium;
    }
}
