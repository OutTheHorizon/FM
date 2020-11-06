package horizon.baselibrary.observer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @Author Horizon
 * @ClasssName MessageProcess
 * @Description 单例观察者
 * @UpdateDate 2020/10/23 5:51 PM
 */
public class MessageProcess {
    private static MessageProcess mProcess;

    /**
     * Single 观察者
     */
    private SingleSender mSingleSender = new SingleSender();
    private static HashMap<String, Sender> mSenderMap= new HashMap<>();

    /**
     * Multiple 多观察者
     */
    private static HashMap<String, HashMap<String, Sender>> mSendersMap= new HashMap<>();
    private MultipleSenders mMultipleSenders = new MultipleSenders();

    /**
     * 句柄
     * @return 自身
     */
    public static MessageProcess getDefault() {
        if (mProcess == null) {
            synchronized (MessageProcess.class) {
                if (mProcess == null) {
                    mProcess = new MessageProcess();
                }
            }
        }
        return mProcess;
    }

    public MultipleSenders getMultipleSenders(){
        return mMultipleSenders;
    }

    public SingleSender getSingleSender() {
        return mSingleSender;
    }

    public class SingleSender{
        /**
         * 单个观察者，但是可以有多个被观察者（通过sender发送的数据确定）
         */
        public void addSender(String key, Sender sender) {
            mSenderMap.put(key, sender);
        }

        public void delSender(String key) {
            mSenderMap.remove(key);
        }

        public Sender getSender(String key) {
            return mSenderMap.get(key);
        }
    }


    public class MultipleSenders {
        /**
         * 多个观察者观察流
         */
        public void addObserver(String observerKey, String delSenderKey, Sender sender) {
            //如果加载到同一个地方会处问题吧
            if (mSendersMap.get(observerKey) == null) {
                HashMap<String, Sender> hashMap = new HashMap<>();
                hashMap.put(delSenderKey, sender);
                mSendersMap.put(observerKey, hashMap);
            } else {
                HashMap<String , Sender> hashMap = mSendersMap.get(observerKey);
                if(hashMap.get(delSenderKey)==null){
                    hashMap.put(delSenderKey, sender);
                }else {
                    throw new ExceptionInInitializerError("已经存在key"+delSenderKey+"了");
                }
            }
        }

        public void sendMessage(String observerKey, Object key, Object data) {
            HashMap<String, Sender> hashMap = mSendersMap.get(observerKey);
            assert hashMap != null;
            Collection<Sender> collection = hashMap.values();
            Iterator<Sender> iterator = collection.iterator();
            while (iterator.hasNext()){
                iterator.next().sendMessage(key, data);
            }
        }

        public void delObserver(String observerKey, String senderKey) {
            HashMap<String, Sender> hashMap = mSendersMap.get(observerKey);
            if (hashMap != null) {
                hashMap.remove(senderKey);
            }
        }

        public void delAllObservers(String observerKey) {
            HashMap<String, Sender> hashMap = mSendersMap.get(observerKey);
            if (hashMap != null) {
                hashMap.clear();
            }
        }
    }
}
