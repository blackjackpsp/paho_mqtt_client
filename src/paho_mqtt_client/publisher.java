package paho_mqtt_client;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class publisher extends Thread {
	
	MqttClient mqttclient;
	
	public void setMqttClient(MqttClient client) {
		
		this.mqttclient=client;
		
	}
	
	public void run() {
		
		String payload="NuovoPost";
		MqttMessage message = new MqttMessage(payload.getBytes());

		while(true) {
			try {
				this.mqttclient.publish("hello/world", message);
			}
			catch(MqttException me) {
				
			}
		}
	}
	
	

}
