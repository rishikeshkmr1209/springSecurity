package com.conceptandcoding.demo.multithreading;

public class SingletonDemo {
    public static void main(String[] args) {

    }

}

class Singletion {
    private static Singletion instance;
    private Singletion(){

    }

    public static Singletion getInstance() {
        if (instance == null) {
            instance = new Singletion();

        }
        return instance;

    }
}

class SingletionUsingSynchronized {
    private  static SingletionUsingSynchronized instance;
    private SingletionUsingSynchronized(){

    }

    public static synchronized SingletionUsingSynchronized getInstance() {
        if (instance == null) {
            instance = new SingletionUsingSynchronized();

        }
        return instance;

    }
}

class SingletionUsingDoubleLocking {
    private  volatile static SingletionUsingDoubleLocking instance;
    private SingletionUsingDoubleLocking(){

    }

    public static  SingletionUsingDoubleLocking getInstance() {
        if (instance == null) {
            synchronized (SingletionUsingDoubleLocking.class) {
                if (instance == null) {
                    instance = new SingletionUsingDoubleLocking();
                }
            }
            

        }
        return instance;

    }
}

class BigPullSingletion{
    private BigPullSingletion(){
    }

        class Holder{
            private static final BigPullSingletion INSTANCE=new BigPullSingletion();
        }

        public BigPullSingletion getInstance(){
            return Holder.INSTANCE;
        }
}

enum EnumSingleton{
    INSTANCE;   

    public void doSomething(){
        System.out.println("Doing something in EnumSingleton");
    }
}
