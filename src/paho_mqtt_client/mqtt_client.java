package paho_mqtt_client;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


public class mqtt_client implements MqttCallback  {
	
	public MqttClient sampleClient;
	
	mqtt_client(){
		
	}
	
	public MqttClient getMqttClient() {
		return this.sampleClient;
	}
	
	
	public void run_client(String topic, String content, int qos, String broker, String clientId) {
        /*String topic        = "MQTT Examples";
        String content      = "Message from MqttPublishSample";
        int qos             = 2;
        String broker       = "tcp://18.188.17.155:22";
        String clientId     = "JavaSample";*/
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            this.sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            this.sampleClient.connect(connOpts);
            System.out.println("Connected");
            this.sampleClient.setCallback(this);
            System.out.println("Publishing message: "+content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            this.sampleClient.subscribe("hello/world");
            this.sampleClient.publish(topic, message);
            System.out.println("Message published");
            //sampleClient.disconnect();
            //System.out.println("Disconnected");
            //System.exit(0);
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
	}
	
	
	@Override
	public void connectionLost(Throwable cause) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void messageArrived(String topic, MqttMessage message)
	        throws Exception {
	 System.out.println(message);   
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
	    // TODO Auto-generated method stub

	}


}
