package horizon.baselibrary.observer;

/**
 * @Author Horizon
 * @ClasssName Sender
 * @Description 被观察者
 * @UpdateDate 2020/10/23 5:49 PM
 */
public interface Sender {
    <T> T sendMessage(Object key, Object o);
}
