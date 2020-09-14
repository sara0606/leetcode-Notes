package CodeWars;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

/**
 * @author yuanyuan
 * @Desc kafka消费者
 * <p>
 * 1.订阅消息可以订阅多个主题
 * 2.ConsumerConfig.GROUP_ID_CONFIG表示消费者的分组，kafka根据分组名称判断是不是同一组消费者，同一组消费者去消费一个主题的数据的时候，数据将在这一组消费者上面轮询。
 * 3.主题涉及到分区的概念，同一组消费者的个数不能大于分区数。因为：一个分区只能被同一群组的一个消费者消费。出现分区小于消费者个数的时候，可以动态增加分区。
 * 4.注意和生产者的对比，Properties中的key和value是反序列化，而生产者是序列化。
 * @Date 2020/8/20 16:12
 */
public class Consumer {

    public static void main(String[] args) {
        Properties p = new Properties();
        p.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.23.76:9092");
        p.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.GROUP_ID_CONFIG, "duanjt_test");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(p);
        // 订阅消息
        //subscribe() 也可以接收一个正则表达式，匹配多个主题（如果有新的名称匹配的主题创建，会立即触发一次再均衡，消费者就可以读取新添加的主题）。
        kafkaConsumer.subscribe(Collections.singletonList(Producer.topic));

        try {
            while (true) {
                //// 100 是超时时间（ms），在该时间内 poll 会等待服务器返回数据
                //在第一次调用新消费者的 poll() 方法时，会负责查找 GroupCoordinator，然后加入群组，接受分配的分区。(消费者通过向作为组协调器（GroupCoordinator）的 broker（不同的组可以有不同的协调器）发送心跳来维持和群组以及分区的关系。)
                //如果发生了再均衡，整个过程也是在轮询期间进行的。心跳也是从轮询里发送出去的。
                ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
                // poll 返回一个记录列表。
                // 每条记录都包含了记录所属主题的信息、记录所在分区的信息、记录在分区里的偏移量，以及记录的键值对。
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(String.format("topic:%s,partition=%s,offset:%d,消息:%s customer=%s, country=%s",
                            record.topic(), record.partition(), record.offset(), record.value(), record.key(), record.value()));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭消费者,网络连接和 socket 也会随之关闭，并立即触发一次再均衡
            kafkaConsumer.close();
        }
    }
}
