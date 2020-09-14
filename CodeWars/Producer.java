package CodeWars;

import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * @author yuanyuan
 * @Desc kafka生产者
 * <p>
 * 1.kafka如果是集群，多个地址用逗号分割(,)
 * 2.Properties的put方法，第一个参数可以是字符串，如:p.put("bootstrap.servers","192.168.23.76:9092")
 * 3.kafkaProducer.send(record)可以通过返回的Future来判断是否已经发送到kafka，增强消息的可靠性。同时也可以使用send的第二个参数来回调，通过回调判断是否发送成功。
 * 4.p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);设置序列化类，可以写类的全路径
 * @Date 2020/8/20 15:25
 */
public class Producer {

    //定义主题
    public static String topic = "duanjt_test";

    public static void main(String[] args) throws InterruptedException {
        Properties p = new Properties();
        //kafka地址，多个地址用逗号分割
        p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.23.76:9092,192.168.23.77:9092");
        p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(p);
        try {
            while (true) {
                String msg = "Hello," + new Random().nextInt(100);
                ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, msg);
                kafkaProducer.send(record);
                System.out.println("消息发送成功:" + msg);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            kafkaProducer.close();
        }

    }
}
